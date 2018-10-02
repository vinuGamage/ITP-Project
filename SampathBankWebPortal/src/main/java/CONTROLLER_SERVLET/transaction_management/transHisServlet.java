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
 * Servlet implementation class transHisServlet
 */
public class transHisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transHisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login l =  (Login)session.getAttribute("username");
		int accountno =l.getAccount();
		 session.setAttribute("accountno", accountno);
		PrintWriter out = response.getWriter();
		//out.print(accountno);
		
		ArrayList<Transaction> transactList = retreiveDAO.getDetailsSent(accountno);
		ArrayList<Transaction> transactList1 = retreiveDAO.getDetailsRetrived(accountno);
		
		ArrayList<Transaction> transactList3 = retreiveDAO.getDetailsSentIntra(accountno);
		ArrayList<Transaction> transactList2 = retreiveDAO.getDetailsRetrivedIntra(accountno);
	
//	Transaction t1= transactList3.get(0);
//	System.out.println(t1.getAccountNo());
//		System.out.println(t1.getAmount());
//		System.out.println(t1.getDate());
//		System.out.println(t1.getTaccountNo());
//		System.out.println(t1.getTid());
		
		session = request.getSession();
		session.setAttribute("List", transactList);
		session.setAttribute("List1", transactList1);
		session.setAttribute("List2", transactList3);
		session.setAttribute("List3", transactList2);
		
		request.getRequestDispatcher("/TM_transactHistory.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	
		
		
		
	}

}
