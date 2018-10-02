package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.transaction_management.retreiveDAO;
import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class searchServlet
 */
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int accno = Integer.parseInt(request.getParameter("search"));
		
		ArrayList<Transaction> searchList = retreiveDAO.searchResultSent(accno);
		ArrayList<Transaction> searchList1 = retreiveDAO.searchResultRetrieved(accno);
		ArrayList<Transaction> searchList2 = retreiveDAO.searchResultSentIntra(accno);
		ArrayList<Transaction> searchList3 = retreiveDAO.searchResultRetrievedIntra(accno);
		
//		int x = 0;
//		while(x<searchList1.size()) {
//			Transaction t1 = searchList.get(x);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getStatus());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
//		x++;	
//		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("SearchList", searchList);
		session.setAttribute("SearchList1",  searchList1);
		session.setAttribute("SearchList2",  searchList2);
		session.setAttribute("SearchList3",  searchList3);
		
		
		request.getRequestDispatcher("/TM_SearchResult.jsp").forward(request, response);
		
		
		

		
		
	}

}
