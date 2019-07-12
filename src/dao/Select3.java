package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Book_InformationDto;

public class Select3 {

	//図書の検索

	public static Book_InformationDto serchBook3(String searchId){

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		Book_InformationDto result = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");

			String sql = "SELECT * FROM book_information WHERE bookid = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, searchId);

			rs = pstmt.executeQuery();

			while( rs.next() ){

				String bookid = rs.getString("bookid");

				String bookname = rs.getString("bookname");

				String author = rs.getString("author");

				String publisher = rs.getString("publisher");

				int isbnid = rs.getInt("isbnid");

				Date recordday = rs.getDate("recordday");

				Date resetday = rs.getDate("resetday");

				String loanstate = rs.getString("loanstate");

				result =  new Book_InformationDto(bookid, bookname, author, publisher,isbnid, recordday, resetday,loanstate);
			}

		} catch (SQLException e){

			System.out.println("DBアクセスに失敗しました。");

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("JDBCドライバのロードに失敗しました");

			e.printStackTrace();

		} finally {

			try {
				if( rs != null){

					rs.close();

				}

			} catch(SQLException e){

				System.out.println("DB切断時にエラーが発生しました。");

				e.printStackTrace();

			}

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
