package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert3 {

	//図書履歴の記録

	public static int insertLoan(int insertloanhistoryId , String insertloanbookId , String insertloanuserId ,
												Date insertloanDay ,Date insertreturnDay){


			Connection con = null;

			PreparedStatement pstmt = null;

			int result = 0;

			try{

				Class.forName("com.mysql.cj.jdbc.Driver");


				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librarymanagement?serverTimezone=JST",
													"root",
													"(パスワード)");


				String sql = "INSERT INTO Loan_history  (LoanBookID , LoanUserID , LoanDay , ReturnDay) VALUES(?,?,?,?)";




				pstmt = con.prepareStatement(sql);


				pstmt.setString(1, insertloanbookId);

				pstmt.setString(2, insertloanuserId);

				pstmt.setDate(3, insertloanDay);

				pstmt.setDate(4, insertreturnDay);

				result = pstmt.executeUpdate();



//			Main.getInstance().setTempre(result2);


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
