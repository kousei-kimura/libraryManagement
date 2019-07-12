package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Loan_historyDto;

public class Select2 {

	//図書履歴の一覧(未使用)

	public static ArrayList<Loan_historyDto> serchALLHistory(){

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		ArrayList<Loan_historyDto> resultList = new ArrayList<Loan_historyDto>();

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/librarymanagement?serverTimezone=JST",
					"root",
					"(パスワード)");

			String sql = "SELECT * FROM Loan_history";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while( rs.next() ){

				int loanhistoryid = rs.getInt("loanhistoryid");

				String loanbookid = rs.getString("loanbookid");

				String loanuserid = rs.getString("loanuserid");

				Date loanday = rs.getDate("loanday");

				Date returnda = rs.getDate("returnday");

				resultList.add(new Loan_historyDto(loanhistoryid, loanbookid, loanuserid, loanday, returnda));
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

		return resultList;

	}


}
