package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete1 {

	//図書の削除

	public static int deleteBook1(String deleteId){

		Connection con = null;

		PreparedStatement pstmt = null;

		int result = 0;


		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");


			String sql = "DELETE FROM Book_Information WHERE bookid = ?";


			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, deleteId);

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
