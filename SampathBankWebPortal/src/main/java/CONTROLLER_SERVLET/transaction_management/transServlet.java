package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



import DAO_SERVICE.transaction_management.otherDAO;
import DAO_SERVICE.transaction_management.validateDAO;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.StandingOrder;
import POJO_MODEL.transaction_management.Transaction;
import POJO_MODEL.user_management.Customer;

/**
 * Servlet implementation class transServlet
 */
public class transServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transServlet() {
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
		Login l = (Login)session.getAttribute("username");
		Customer customer = (Customer)session.getAttribute("customer");
		int pin = otherDAO.generatePin(l);
		
		EmailClient.sendMail(customer.getPersonalEmail(), "Sampath Bank Temperory Transaction Pin", "  "+pin+"");
		
		System.out.println(pin);
		
		//request.getRequestDispatcher("/TM_transactDetails.jsp").forward(request, response);
		request.getRequestDispatcher("/TM_pin1.jsp").forward(request, response);
	}

}
