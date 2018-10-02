package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.updateDAO;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class intraConfirmServlet
 */
public class intraConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public intraConfirmServlet() {
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
		

		Transaction transaction1 = new Transaction(Long.parseLong(request.getParameter("accountno")),Long.parseLong(request.getParameter("Taccountno")),request.getParameter("dateTime"),Double.parseDouble(request.getParameter("amount")));
	
//		updateDAO.insertIntraTransacts(transaction1);
//		JOptionPane.showMessageDialog(null, "Successful.");
//		request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
//		
		if(updateDAO.transactions(transaction1)) {
			//System.out.println("vinuuuuuuuuuuuu");
			updateDAO.insertIntraTransacts(transaction1);
			JOptionPane.showMessageDialog(null, "Successful.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
			//System.out.println("i did it");
		}else {
			//System.out.println("babbbabababba");
			JOptionPane.showMessageDialog(null, "Details were not updated in our server.Please re-enter details.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
		}
		
	}

}
