package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.transaction_management.retreiveDAO;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class showAllTransactDetailsServlet
 */
public class showAllTransactDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showAllTransactDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<Transaction> allTransacts = retreiveDAO.getAllTransacts();
		ArrayList<Transaction> allIntraTransacts = retreiveDAO.getAllIntraTransacts();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("allTransacts",  allTransacts );
		session.setAttribute("allIntraTransacts", allIntraTransacts);
		
//		int y =0;
//		while(y<allTransacts.size()) {
//			
//			Transaction t1= allTransacts.get(y);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getStatus());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
//			y++;
//			
//		}
		
		request.getRequestDispatcher("/TM_empShowAllTransacts.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
