package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.USER_DateDto;

public class LoginDao {

	//IDとパスワードが一致しているか

	public static USER_DateDto serchLogin(String loginId){

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		USER_DateDto result = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");

			String sql = "SELECT * FROM USER_Date WHERE UserID = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, loginId);

			rs = pstmt.executeQuery();

			if(rs.next()){

			String userid = rs.getString("userid");

			String loginpw = rs.getString("loginpw");

			String name = rs.getString("name");

			int age = rs.getInt("age");

			String streetaddress = rs.getString("streetaddress");

			Date recordday = rs.getDate("recordday");

			Date resetday = rs.getDate("resetday");

			result = new USER_DateDto(userid, loginpw , name , age , streetaddress , recordday , resetday);

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
