package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

		//図書の追加

public class Insert1 {

	public static int insertBook(String insertId , String insertName , String insertAuthor ,
													String insertPublisher , int insertISBNID , Date insertRecordDay ,
													Date insertResetDay , String insertLoanState){


		Connection con = null;

		PreparedStatement pstmt = null;

		int result = 0;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");


			String sql = "INSERT INTO Book_Information VALUES(?,?,?,?,?,?,?,?)";


			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,insertId);

			pstmt.setString(2, insertName);

			pstmt.setString(3, insertAuthor);

			pstmt.setString(4, insertPublisher);

			pstmt.setInt(5, insertISBNID);

			pstmt.setDate(6, insertRecordDay);

			pstmt.setDate(7, insertResetDay);

			pstmt.setString(8, insertLoanState);

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
