package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Delete1;

/**
 * Servlet implementation class DeleteResultServlet
 */
@WebServlet("/DeleteResultServlet.html")
public class DeleteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String sid = request.getParameter("bookid");

		String result;

		if(sid.isEmpty()){

			String view = "/WEB-INF/view/delete.jsp?error1=1";

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);

			dispatcher.forward(request, response);


		}else if(request.getParameter("button").equals("削除")){

			int de = (Delete1.deleteBook1(sid));

			if(de == 0){

				result = "エラーです。本が削除されませんでした。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/deleteresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else{

				result = "この本を削除しました。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/deleteresult.jsp";

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
