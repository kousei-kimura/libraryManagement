package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Insert1;

/**
 * Servlet implementation class AddResultServlet
 */
@WebServlet("/AddResultServlet.html")
public class AddResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String sid = request.getParameter("bookid");

		String sname = request.getParameter("bookname");

		String sauthor = request.getParameter("author");

		String spublisher = request.getParameter("publisher");

		String sisbnid = request.getParameter("isbnid");

		 Date recordday = new Date(Calendar.getInstance().getTimeInMillis()); //登録日時

		 Date resetday = new Date(Calendar.getInstance().getTimeInMillis()); //更新日時

		String result;

		if(sid.isEmpty() || sname.isEmpty() || sauthor.isEmpty() || spublisher.isEmpty() || sisbnid.isEmpty()){

			String view = "/WEB-INF/view/add.jsp?error1=1";

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);

			dispatcher.forward(request, response);


		}else if(request.getParameter("button").equals("登録")){

			int isbnid = Integer.parseInt(sisbnid);

			int is = Insert1.insertBook(sid, sname, sauthor, spublisher, isbnid, recordday, resetday, "貸出可");

			if(is == 0){

				result = "エラーです。本が登録されませんでした。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/addresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else{

				result = "この本を登録しました。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/addresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

			}


		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
