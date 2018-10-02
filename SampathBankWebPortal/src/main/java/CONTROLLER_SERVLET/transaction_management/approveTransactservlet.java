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
 * Servlet implementation class approveTransactservlet
 */
public class approveTransactservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approveTransactservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		ArrayList<Transaction> disApproved = retreiveDAO.getDisapprovedList();
		ArrayList<Transaction> disApproved1 = retreiveDAO.getDisapprovedListIntra();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("allTransacts", disApproved);
		session.setAttribute("allIntraTransacts", disApproved1);
		
		request.getRequestDispatcher("/TM_showDisApprovedList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
