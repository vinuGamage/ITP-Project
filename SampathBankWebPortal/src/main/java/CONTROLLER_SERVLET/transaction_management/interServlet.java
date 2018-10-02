package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.validateDAO;
import POJO_MODEL.transaction_management.StandingOrder;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class interServlet
 */
public class interServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public interServlet() {
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
		
		Transaction t = new Transaction(Long.parseLong(request.getParameter("accountno")), Long.parseLong(request.getParameter("Taccountno")), request.getParameter("dateTime"), Double.parseDouble(request.getParameter("amount"))); 
		//StandingOrder st = new StandingOrder(Long.parseLong(request.getParameter("accountno")), Long.parseLong(request.getParameter("Taccountno")), request.getParameter("description"), Double.parseDouble(request.getParameter("stamount")), request.getParameter("date"));
		
		HttpSession session = request.getSession();
		session.setAttribute("IntraTransacts", t);
		//session.setAttribute("StandingOrders", st);
		
		request.getRequestDispatcher("/TM_transactDeets.jsp").forward(request, response);
		
//		if(validateDAO.validateCreditAccount(t) && validateDAO.validateDebitAccount(t)) {
//			JOptionPane.showMessageDialog(null, "All the details are validated.");
//			request.getRequestDispatcher("/transactDeets.jsp").forward(request, response);
//		}else {
//			JOptionPane.showMessageDialog(null, "Please re-enter a valid(existing) debit account.");
//			request.getRequestDispatcher("/intraBankTransacts.jsp").forward(request, response);
//		}
	}

}
