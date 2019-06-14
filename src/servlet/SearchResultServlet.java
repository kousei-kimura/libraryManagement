package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorSelect;
import dao.NameSelect;
import dao.PublisherSelect;
import dao.Select1;
import dto.Book_InformationDto;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/SearchResultServlet.html")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String key = request.getParameter("search");


		if(request.getParameter("bookname")!= null){

			if(key.isEmpty()){

				ArrayList<Book_InformationDto> list = Select1.serchALLBook();

				request.setAttribute("list", list);

				String view = "/WEB-INF/view/searchresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

			}else{

				ArrayList<Book_InformationDto> list = NameSelect.serchBookName(key);

				request.setAttribute("list", list);

				String view = "/WEB-INF/view/searchresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

			}


		}else if(request.getParameter("author")!= null){

			if(key.isEmpty()){

				ArrayList<Book_InformationDto> list = Select1.serchALLBook();

				request.setAttribute("list", list);

				String view = "/WEB-INF/view/searchresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

			}else{

			ArrayList<Book_InformationDto> list = AuthorSelect.serchBookAuthor(key);

			request.setAttribute("list", list);

			String view = "/WEB-INF/view/searchresult.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);

			dispatcher.forward(request, response);

			}


		}else if(request.getParameter("publisher")!= null){

			if(key.isEmpty()){

				ArrayList<Book_InformationDto> list = Select1.serchALLBook();

				request.setAttribute("list", list);

				String view = "/WEB-INF/view/searchresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

			}else{

			ArrayList<Book_InformationDto> list = PublisherSelect.serchBookPublisher(key);

			request.setAttribute("list", list);

			String view = "/WEB-INF/view/searchresult.jsp";

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
