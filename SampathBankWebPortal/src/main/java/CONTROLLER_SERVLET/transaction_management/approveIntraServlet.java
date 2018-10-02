package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.updateDAO;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class approveIntraServlet
 */
public class approveIntraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approveIntraServlet() {
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
		
		HttpSession session = request.getSession();
		ArrayList<Transaction> list = (ArrayList<Transaction>) session.getAttribute("allIntraTransacts");
	
		
		Transaction t1 = list.get(Integer.parseInt(request.getParameter("approve1")));
		if(updateDAO.approvingTransactions(t1)) {
			updateDAO.transactions(t1);
			JOptionPane.showMessageDialog(null, "Transaction was successfully approved.");
			request.getRequestDispatcher("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "Transaction was not successfully approved.");
			
		}
	}

}
