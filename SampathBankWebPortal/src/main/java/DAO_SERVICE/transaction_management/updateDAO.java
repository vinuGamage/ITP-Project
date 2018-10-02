package DAO_SERVICE.transaction_management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.StandingOrder;
import POJO_MODEL.transaction_management.Transaction;


public class updateDAO {

	private static Connection con;
	private static String query = "INSERT INTO transaction (accno,taccno,date,amount,status) VALUES (?,?,?,?,?)"; 
	private static String query1 = "UPDATE bankaccount SET balance=? WHERE accno=?";
	private static String query2 = "SELECT balance from bankaccount";
	private static String query3 = "INSERT INTO standingorder (accountno,taccountno,des,date,period,amount) VALUES (?,?,?,?,?,?)";
	private static String query4 = "INSERT INTO intratransaction (accno,taccno,date,amount,status) VALUES (?,?,?,?,?)"; 
	private static String query5 = "delete from itp_2018_mlb_g3_10_sampath_web_portal_vinu.pin where accno = ?";
	private static String query6 = "UPDATE transaction SET status='approved' WHERE tid=?";
	
	/*
	 * @inserting account transaction details once its confirmed by the customer
	 * 
	 */
	
	public static boolean insertTransacts(Transaction t) {
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1, t.getAccountNo());
			pst.setLong(2, t.getTaccountNo());
			pst.setString(3, t.getDate());
			pst.setDouble(4,t.getAmount());
			pst.setString(5, "approved");
			
			pst.execute();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
			
	}
	

	public static boolean insertTransactsDis(Transaction t) {
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1, t.getAccountNo());
			pst.setLong(2, t.getTaccountNo());
			pst.setString(3, t.getDate());
			pst.setDouble(4,t.getAmount());
			pst.setString(5, "pending");
			
			pst.execute();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
			
	}
	
	
	/*
	 * @inserting Intra transaction details once its confirmed by the customer
	 * 
	 */
	
	public static boolean insertIntraTransacts(Transaction t) {
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query4);
			pst.setLong(1, t.getAccountNo());
			pst.setLong(2, t.getTaccountNo());
			pst.setString(3, t.getDate());
			pst.setDouble(4,t.getAmount());
			pst.setString(5, "approved");
			
			pst.execute();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
			
	}
	
	

	/*
	 * @inserting standing order details
	 * 
	 */
	
	public static boolean insertStandingOrders(StandingOrder st) {
		
		try {
			System.out.println("booooo");
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query3);
			pst.setLong(1, st.getAccountno());
			pst.setLong(2, st.getTaccountno());
			pst.setString(3, st.getDescription());
			pst.setInt(4, st.getDate());
			pst.setInt(5, st.getPeriod());
			pst.setDouble(6, st.getAmount());
			System.out.println("booooo1");
			pst.execute();
			
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("booooo2");
		return false;
	}
	
	
	/*
	 * @updating status by the manager(the transactions)
	 * 
	 */
	
	public static boolean approvingTransactions(Transaction t) {
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query6);
			pst.setInt(1, t.getTid());
			pst.executeUpdate();
			
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * @updating account balance(the transactions)
	 * 
	 */
	
	public static boolean transactions(Transaction t) {
		
		try {
			con = DBConnection.ConnectDB();
		
			double newBalance = t.creditAccount(t.getTaccountNo(), t.getAmount());
			double newBalance1 = t.debitAccount(t.getAccountNo(), t.getAmount());
			
			PreparedStatement pst = con.prepareStatement(query1);			
			pst.setDouble(1, newBalance);
			pst.setLong(2, t.getTaccountNo() );
			pst.executeUpdate();

			PreparedStatement pst1 = con.prepareStatement(query1);			
			pst1.setDouble(1, newBalance1);
			pst1.setLong(2, t.getAccountNo() );
			pst1.executeUpdate();
			
			return true;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}




	public static boolean standingOrders(StandingOrder st) {
	
		double newamount = st.standingOrderPayments(st.getAccountno(), st.getAmount(), st.getDate(), st.getPeriod());
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query3);
			pst.setDouble(1, newamount);
			pst.setLong(2, st.getTaccountno());
			pst.executeUpdate();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean deletePin(int accountno) {
	
		try {
			con = DBConnection.ConnectDB();
			
			PreparedStatement pst = con.prepareStatement(query5);
			pst.setLong(1,accountno);
			pst.executeUpdate();
			
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
}