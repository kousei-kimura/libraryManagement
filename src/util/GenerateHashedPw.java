package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class GenerateHashedPw {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    private static final int ITERATION_COUNT = 10000;

    private static final int KEY_LENGTH = 256;


    private static byte[] getHashedSalt(String salt) {

        MessageDigest messageDigest;

        try {

            messageDigest = MessageDigest.getInstance("SHA-256");

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);

        }

        messageDigest.update(salt.getBytes());

        return messageDigest.digest();

    }

    public static String getSafetyPassword(String password, String salt) {

        char[] passCharAry = password.toCharArray();


        byte[] hashedSalt = getHashedSalt(salt);

        /*第1引数：パスワード
		  第2引数：ソルト
		  第3引数：ストレッチング回数
		  第4引数：生成文字列長
        */
        PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, ITERATION_COUNT, KEY_LENGTH);

        SecretKeyFactory skf;

        try {

	            skf = SecretKeyFactory.getInstance(ALGORITHM);

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);

        }

        SecretKey secretKey;

        try {

            secretKey = skf.generateSecret(keySpec);

        } catch (InvalidKeySpecException e) {

            throw new RuntimeException(e);

        }

        byte[] passByteAry = secretKey.getEncoded();

        StringBuilder sb = new StringBuilder(64);

        for (byte b : passByteAry) {

            sb.append(String.format("%02x", b & 0xff));

        }

        return sb.toString();

    }

}
