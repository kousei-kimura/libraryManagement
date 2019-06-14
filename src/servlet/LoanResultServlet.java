package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Select3;
import dao.Update1;
import dao.Update2;
import dto.Book_InformationDto;

/**
 * Servlet implementation class LoanResultServlet
 */
@WebServlet("/LoanResultServlet.html")
public class LoanResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String sid = request.getParameter("id");

		String result;


		if(sid.isEmpty()){

			String view = "/WEB-INF/view/loan.jsp?error=1";

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);

			dispatcher.forward(request, response);


		}else if(request.getParameter("button").equals("貸出")){

			Book_InformationDto serch = Select3.serchBook3(sid);

			if(serch == null){

				result = "本のデータがありません。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/loanresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else if(serch.getLoanstate().equals("貸出中")){

				result = "この本は貸出中です。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/loanresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else if(serch.getLoanstate().equals("貸出可")){

				int up1 = (Update1.updateBook1(sid));

				if(up1 == 0){

					result = "本を貸出すことができませんでした。";

					request.setAttribute("result", result);

					String view = "/WEB-INF/view/loanresult.jsp";

					RequestDispatcher dispatcher = request.getRequestDispatcher(view);

					dispatcher.forward(request, response);


				}else{

				result = "この本を貸出しました。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/loanresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);

				}

			}


		}else if(request.getParameter("button").equals("返却")){

			Book_InformationDto serch = Select3.serchBook3(sid);

			if(serch == null){

				result = "本のデータがありません。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/loanresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else if(serch.getLoanstate().equals("貸出可")){

				result = "既に返却されてます。";

				request.setAttribute("result", result);

				String view = "/WEB-INF/view/loanresult.jsp";

				RequestDispatcher dispatcher = request.getRequestDispatcher(view);

				dispatcher.forward(request, response);


			}else if(serch.getLoanstate().equals("貸出中")){

				int up2 = (Update2.updateBook2(sid));

				if(up2 == 0){

					result = "IDと一致する本がありません。";

					request.setAttribute("result", result);

					String view = "/WEB-INF/view/loanresult.jsp";

					RequestDispatcher dispatcher = request.getRequestDispatcher(view);

					dispatcher.forward(request, response);

				}else {

					result = "この本を返却しました。";

					request.setAttribute("result", result);

					String view = "/WEB-INF/view/loanresult.jsp";

					RequestDispatcher dispatcher = request.getRequestDispatcher(view);

					dispatcher.forward(request, response);

				}

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
