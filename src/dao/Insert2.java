package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert2 {

//	ユーザー登録

	public static int insertUser(String insertId , String insertPW , String insertname , int insertage ,
											String insertstreetaddress , Date insertRecordDay , Date insertResetDay){


		Connection con = null;

		PreparedStatement pstmt = null;

		int result = 0;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");


			String sql = "INSERT INTO USER_Date VALUES(?,?,?,?,?,?,?)";


			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,insertId);

			pstmt.setString(2, insertPW);

			pstmt.setString(3, insertname);

			pstmt.setInt(4, insertage);

			pstmt.setString(5, insertstreetaddress);

			pstmt.setDate(6, insertRecordDay);

			pstmt.setDate(7, insertResetDay);

			result = pstmt.executeUpdate();


		} catch (SQLException e){

			System.out.println("DBアクセスに失敗しました。");

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("JDBCドライバのロードに失敗しました");

			e.printStackTrace();

		} finally {

		try {

			if( pstmt != null){

			pstmt.close();

		}

		} catch(SQLException e){

			System.out.println("DB切断時にエラーが発生しました。");

			e.printStackTrace();

		}

		try {

			if( con != null){

				con.close();

		}

		} catch (SQLException e){

			System.out.println("DB切断時にエラーが発生しました。");

			e.printStackTrace();

		}

		}

		return result;

	}

}
