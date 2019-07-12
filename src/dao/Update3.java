package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update3 {

	//図書履歴の更新(未使用)

	public static int updateBook3(Date updeteDay , String updeteId){

		Connection con = null;

		PreparedStatement pstmt = null;

		int result = 0;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");


			String sql = "UPDATE Loan_history SET ReturnDay = ? WHERE LoanBookID = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setDate(1,  updeteDay);

			pstmt.setString(2, updeteId);

			result = pstmt.executeUpdate();


		} catch (SQLException e){

			System.out.println("DBアクセスに失敗しました。");

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("DBアクセスに失敗しました。");

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
