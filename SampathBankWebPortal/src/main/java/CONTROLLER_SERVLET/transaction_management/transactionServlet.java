package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DAO_SERVICE.transaction_management.DBConnection;
import DAO_SERVICE.transaction_management.validateDAO;
import POJO_MODEL.transaction_management.StandingOrder;
import POJO_MODEL.transaction_management.Transaction;

import java.sql.*;
/**
 * Servlet implementation class sampleServlet
 */
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "jdbc:mysql://localhost:3306/sample";
//		 String user = "root";
//		 String pass = "root";	
//		 
//		 
//		 Connection con = null;
//			
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				con = DriverManager.getConnection(url, user, pass);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			if(con != null) {
//				// Critical Point Marker
//				System.out.println("Connected from connect() method!");
//			}
//			
//			else {
//				// Critical Point Marker
//				System.out.println("Not Connected from connect() method!");
//			}
		
		Connection con;
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement("select * from intratransaction where tid = ?");
			pst.setInt(1,5);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				
				System.out.println(rst.getInt(1));
				System.out.println(rst.getLong(2));
				System.out.println(rst.getLong(3));
				System.out.println(rst.getDouble(4));
				System.out.println(rst.getString(5));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Transaction t = new Transaction(Long.parseLong(request.getParameter("accountno")),Long.parseLong(request.getParameter("Taccountno")),request.getParameter("dateTime"),Double.parseDouble(request.getParameter("amount")));
		//StandingOrder st = new StandingOrder(Long.parseLong(request.getParameter("accountno")), Long.parseLong(request.getParameter("Taccountno")),request.getParameter("description"),Double.parseDouble(request.getParameter("stamount")) , Integer.parseInt(request.getParameter("date")) ,Integer.parseInt(request.getParameter("period")));
		
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("amount"));
		out.println(Double.parseDouble(request.getParameter("amount")));
		
		out.print(t.getAccountNo());
		
		HttpSession session = request.getSession();
		session.setAttribute("InterTransacts", t);
		//session.setAttribute("standingOrders", st);

		
		if(validateDAO.validateCreditAccount(t) && validateDAO.validateDebitAccount(t)) {
			if(validateDAO.validateExistingBalanceAmount(Double.parseDouble(request.getParameter("amount")),Long.parseLong(request.getParameter("accountno")))) {
			
				JOptionPane.showMessageDialog(null, "All the details are validated.");
				request.getRequestDispatcher("/TM_transactDetails.jsp").forward(request, response);
		
			}else {
				JOptionPane.showMessageDialog(null, "Current balance is not valid to perform the transaction.");
				request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Please re-enter a valid(existing) debit account.");
			request.getRequestDispatcher("/TM_interBankTransacts.jsp").forward(request, response);
		}
	}

}
