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
import DAO_SERVICE.transaction_management.validateDAO;
import POJO_MODEL.transaction_management.Login;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
//		PrintWriter out = response.getWriter();
		
//		session.setAttribute("usrname", l);
		HttpSession session = request.getSession();
//		
//		String acc = retreiveDAO.retreiveAccno(l);
//		out.println(acc);
		
		
		if(validateDAO.validateUser(l)) {
			session.setAttribute("username", l);
			JOptionPane.showMessageDialog(null, request.getParameter("user") + " you are a  valid user.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "Invalid user account.Please register before logging");
		}
	}

}
