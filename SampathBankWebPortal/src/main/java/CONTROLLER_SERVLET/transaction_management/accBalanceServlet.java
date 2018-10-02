package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.retreiveDAO;
import DAO_SERVICE.transaction_management.updateDAO;
import POJO_MODEL.transaction_management.Login;

/**
 * Servlet implementation class accBalanceServlet
 */
public class accBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/TM_accountBalance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out= response.getWriter();
		
		HttpSession session = request.getSession();
		Login l =  (Login)session.getAttribute("username");
		int accountno =l.getAccount();
		

		
		int pin  = Integer.parseInt(request.getParameter("pinid"));

		int pinid = retreiveDAO.getPin(accountno);
		out.println(pinid);
		out.println("blueeeeeeeeeee");
		out.println(pin);
 
		System.out.println(pin == pinid);
		
		//validate pin method
		if(pin == pinid) {
			JOptionPane.showMessageDialog(null, " Pin is validated. ");
			updateDAO.deletePin(accountno);
			request.getRequestDispatcher("/TM_accountBalance.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, " Not a valid pin.Please re-eneter ");
			request.getRequestDispatcher("/TM_pin1.jsp").forward(request, response);
		}
	
//	
	


		
		
//		session.setAttribute("balance", retreiveDAO.getAccountBalance(accountno));
		//request.getRequestDispatcher("/accountBalance.jsp").forward(request, response);
		//request.getRequestDispatcher("/intraBankTransacts.jsp").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.println(retreiveDAO.retreiveAccno(l));
//		out.print(retreiveDAO.getAccountBalance(accountno));
	}

}
