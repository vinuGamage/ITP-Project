package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.retreiveDAO;
import DAO_SERVICE.transaction_management.updateDAO;
import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.StandingOrder;
import POJO_MODEL.transaction_management.Transaction;


/**
 * Servlet implementation class transConfirmServlet
 */
public class transConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transConfirmServlet() {
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
		PrintWriter out = response.getWriter();
		
		Transaction transaction1 = new Transaction(Long.parseLong(request.getParameter("accountno")),Long.parseLong(request.getParameter("Taccountno")),request.getParameter("dateTime"),Double.parseDouble(request.getParameter("amount")));
		//StandingOrder st = new StandingOrder(Long.parseLong(request.getParameter("accountno")), Long.parseLong(request.getParameter("Taccountno")),request.getParameter("description"),Double.parseDouble(request.getParameter("stamount")) , Integer.parseInt(request.getParameter("date")),Integer.parseInt(request.getParameter("period")));
		//out.println(transaction1.getAccountNo());
		
		//updateDAO.transactions(transaction1);
		//updateDAO.insertTransacts(transaction1);
		
		
		
//		Transaction t= (Transaction)session.getAttribute("transactions");
//		
		//out.println(t.getAccountNo());
		//request.getRequestDispatcher("/transactHistory.jsp").forward(request, response);
		//Transaction t = (Transaction)request.getAttribute("transactions");
		//updateDAO.insertTransacts(t);
		
		//updateDAO.insertStandingOrders(st1);
		//request.getRequestDispatcher("/accountBalance.jsp").forward(request, response);
		if(Double.parseDouble(request.getParameter("amount")) >= 100000) {
			//System.out.println("vinuuuuuuuuuuuu");
			updateDAO.insertTransactsDis(transaction1);
			//updateDAO.insertTransacts(transaction1);
			//updateDAO.transactions(transaction1);
			JOptionPane.showMessageDialog(null, "As the amount is " + request.getParameter("amount")+ " check for more  details.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
			
		}else if(Double.parseDouble(request.getParameter("amount")) < 100000) {
				//updateDAO.insertStandingOrders(st);
				//updateDAO.standingOrders(st);
				updateDAO.insertTransacts(transaction1);
				updateDAO.transactions(transaction1);
				JOptionPane.showMessageDialog(null, "Successful.");
				request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
		}
		else {
			//System.out.println("babbbabababba");
			JOptionPane.showMessageDialog(null, "Details were not updated in our server.Please re-enter details.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
		}
			
		
	}

}
