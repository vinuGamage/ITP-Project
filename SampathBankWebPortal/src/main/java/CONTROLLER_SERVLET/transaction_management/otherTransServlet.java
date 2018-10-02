package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.otherDAO;
import DAO_SERVICE.transaction_management.retreiveDAO;
import DAO_SERVICE.transaction_management.updateDAO;
import DAO_SERVICE.transaction_management.validateDAO;
import POJO_MODEL.transaction_management.Login;

/**
 * Servlet implementation class otherTransServlet
 */
public class otherTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otherTransServlet() {
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
		
		HttpSession session = request.getSession();
		Login l = (Login)session.getAttribute("username");
		int pin  = Integer.parseInt(request.getParameter("pinid"));
		int accountno =Integer.parseInt(retreiveDAO.retreiveAccno(l));
		int pinid = retreiveDAO.getPin(accountno);
		out.println(pinid);
		out.println("blueeeeeeeeeee");
		out.println(pin);
		
		//validate pin method
		if(pin == pinid) {
			JOptionPane.showMessageDialog(null, " Pin is validated. ");
			if(updateDAO.deletePin(accountno)) {
				request.getRequestDispatcher("/TM_accountBalance.jsp").forward(request, response);
			}else {
				JOptionPane.showMessageDialog(null, " Error ");
				request.getRequestDispatcher("/TM_pin1.jsp").forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, " Please re-enter the pin ");
			request.getRequestDispatcher("/TM_pin1.jsp").forward(request, response);
		}
		
		
		//request.getRequestDispatcher("/TM_intraBankTransacts.jsp").forward(request, response);
	}

}
