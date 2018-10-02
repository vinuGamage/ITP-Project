package DAO_SERVICE.transaction_management;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import java.sql.PreparedStatement;

import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.Transaction;


public class retreiveDAO {
	
	private static Connection con;
	private static String query = "SELECT * FROM login WHERE user = ?";
	private static String query1 = "SELECT accno FROM login WHERE user=?";
	private static String query2 = "SELECT * FROM transaction WHERE accno=? and status='approved'";
	private static String query3 = "SELECT * FROM transaction WHERE taccno=? and status='approved'";
	private static String query4 = "SELECT * FROM bankaccount WHERE accno=?";
	private static String query5 = "SELECT * FROM intratransaction WHERE accno=? and status='approved'";
	private static String query7 = "SELECT * FROM intratransaction WHERE taccno=? and status='approved'";
	private static String query6 = "SELECT * FROM pin WHERE accno=?";
	private static String query8= "SELECT * FROM transaction WHERE status='pending'";
	private static String query9= "SELECT * FROM intratransaction WHERE status='pending'";
	private static String query10="SELECT * FROM transaction";
	private static String query11="SELECT * FROM intratransaction";
	private static String query12="SELECT * FROM transaction where tid like ? AND accno like ? AND taccno like ? AND date like ? AND amount like ? AND status like ? ";
	private static String query13="SELECT * FROM intratransaction where tid like ? AND accno like ? AND taccno like ? AND date like ? AND amount like ? AND status like ? ";
	
	/*
	 * @validating the user password and username
	 *   
	 */
	
	public static boolean validate( Login c) {
		try {
			
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, c.getUsername());
			
			
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				return true;
				
			}
			else return false;
			
			
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
	 * @Retrieving accountNo according to the username
	 * 
	 */
	
	public static String retreiveAccno(Login l) {
		String acc;
		try {
			
			con = DBConnection.ConnectDB();
			System.out.println("hooo0");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, l.getUsername());
			System.out.println("hooo1");
			ResultSet rst = pst.executeQuery();
			System.out.println("hooo5");
			while(rst.next()) {
			
				acc = rst.getString("accno");
				System.out.println("hooo2"); 
				return acc;
				 
			}
			
			//String acc = rst.getString(4);
			System.out.println("hooo2");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hooo3");
		return null;
	}
	
	/*
	 * @Retrieving pin
	 * 
	 */
	
	public static int getPin(int accountno) {
		
		int pin=0;
		try {
			con = DBConnection.ConnectDB();
			
			PreparedStatement pst = con.prepareStatement(query6);
			pst.setLong(1, accountno);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				pin = rst.getInt("pinid");
				System.out.println("pin worked");
				
			}
			System.out.println("pin is done");
			return pin;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("pin not done");
		return 0;
	}
	
	/*
	 * @Retrieving account balance(credit account)
	 * 
	 */
	
	public static double accountBalance(Transaction t) {
		
		try {
			String balance= null;
			double amount=0.0;
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query4);
			pst.setLong(1, t.getTaccountNo());
			ResultSet rst =  pst.executeQuery();
			
			while(rst.next()) {
				balance = rst.getString("balance");
				amount = Double.parseDouble(balance);
			}
			
			
			return amount;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	
	/*
	 * @Retrieving account balance(debit account)
	 * 
	 */
	
	
	public static double debitAccountBalance(Transaction t) {
		
		try {
			String balance= null;
			double amount=0.0;
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query4);
			pst.setLong(1, t.getAccountNo());
			ResultSet rst =  pst.executeQuery();
			
			while(rst.next()) {
				balance = rst.getString("balance");
				amount = Double.parseDouble(balance);
			}
			
			
			return amount;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	public static ArrayList <Transaction> getAllTransacts(){
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query10);
			ResultSet rst = pst.executeQuery();
			
			ArrayList<Transaction> transactions = new ArrayList<Transaction>();
			
			while(rst.next()) {
				Transaction t1 =new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(4), rst.getDouble(5),rst.getInt(1),rst.getString(6));
				transactions.add(t1);
			}
			
		return transactions ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	
	public static ArrayList <Transaction> getAllIntraTransacts(){
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query11);
			ResultSet rst = pst.executeQuery();
			
			ArrayList<Transaction> transactions = new ArrayList<Transaction>();
			
			while(rst.next()) {
				Transaction t1 =new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(5), rst.getDouble(4),rst.getInt(1),rst.getString(6));
				transactions.add(t1);
			}
			
		return transactions ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 

	/*
	 * @Retrieving disapproved list
	 * 
	 */
	
	
	public static ArrayList<Transaction> getDisapprovedList(){
		
		try {
			con =DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query8);
			ResultSet rst = pst.executeQuery();
			
			ArrayList<Transaction> disApprovedList = new ArrayList<Transaction>();
			
			while(rst.next()) {
				Transaction t1 =new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(4), rst.getDouble(5),rst.getInt(1));
				disApprovedList.add(t1);
			}
			
		return disApprovedList;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<Transaction> getDisapprovedListIntra(){
		
		try {
			con =DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query9);
			ResultSet rst = pst.executeQuery();
			
			ArrayList<Transaction> disApprovedList = new ArrayList<Transaction>();
			
			while(rst.next()) {
				Transaction t1 =new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(5), rst.getDouble(4),rst.getInt(1));
				disApprovedList.add(t1);
			}
			
		return disApprovedList;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * @Retrieving transaction history
	 * 
	 */
	

	public static ArrayList<Transaction> getDetailsSent(int accountno){
	
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			pst.setInt(1,accountno);
			ResultSet rst = pst.executeQuery();
		
			ArrayList<Transaction> transactHis = new ArrayList<Transaction>();
		
			while(rst.next()) {
			Transaction t1=new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(4), rst.getDouble(5),rst.getInt(1));
			transactHis.add(t1);
		
		}
		
		
		return transactHis;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @Retrieving transaction history retrieved
	 * 
	 */
	

	public static ArrayList<Transaction> getDetailsRetrived(int accountno){
	
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query3);
			pst1.setInt(1,accountno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis1 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(4), rst1.getDouble(5),rst1.getInt(1));
			transactHis1.add(t1);
		}
		
		
			return transactHis1;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Transaction> getDetailsSentIntra(int accountno){
		
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query5);
			pst.setInt(1,accountno);
			ResultSet rst = pst.executeQuery();
		
			ArrayList<Transaction> transactHis3 = new ArrayList<Transaction>();
		
			while(rst.next()) {
			Transaction t1 =new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(5), rst.getDouble(4),rst.getInt(1));
			transactHis3.add(t1);
			}
		
				
		return transactHis3;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @Retrieving transaction history retrieved
	 * 
	 */
	

	public static ArrayList<Transaction> getDetailsRetrivedIntra(int accountno){
	
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query7);
			pst1.setInt(1,accountno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis4 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(5), rst1.getDouble(4),rst1.getInt(1));
			transactHis4.add(t1);
			System.out.println(t1.getAccountNo());
			System.out.println(t1.getAmount());
			System.out.println(t1.getDate());
			System.out.println(t1.getTaccountNo());
			System.out.println(t1.getTid());
			
		}
		
			return transactHis4;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	/*
	 * @Search results
	 * 
	 */
	
	public static ArrayList<Transaction> searchResultSent(int accno){
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query3);
			pst1.setInt(1,accno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis5 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(4), rst1.getDouble(5),rst1.getInt(1));
			transactHis5.add(t1);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
//			
		}
		
			return transactHis5;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public static ArrayList<Transaction> searchResultRetrieved(int accno){
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query2);
			pst1.setInt(1,accno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis6 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(4), rst1.getDouble(5),rst1.getInt(1));
			transactHis6.add(t1);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
			
		}
		
			return transactHis6;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public static ArrayList<Transaction> searchResultSentIntra(int accno){
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query7);
			pst1.setInt(1,accno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis7 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(5), rst1.getDouble(4),rst1.getInt(1));
			transactHis7.add(t1);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
			
		}
		
			return transactHis7;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public static ArrayList<Transaction> searchResultRetrievedIntra(int accno){
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst1 = con.prepareStatement(query5);
			pst1.setInt(1,accno);
			ResultSet rst1 = pst1.executeQuery();
		
			ArrayList<Transaction> transactHis8 = new ArrayList<Transaction>();
			
			while(rst1.next()) {
			Transaction t1=new Transaction(rst1.getLong(2), rst1.getLong(3), rst1.getString(5), rst1.getDouble(4),rst1.getInt(1));
			transactHis8.add(t1);
//			System.out.println(t1.getAccountNo());
//			System.out.println(t1.getAmount());
//			System.out.println(t1.getDate());
//			System.out.println(t1.getTaccountNo());
//			System.out.println(t1.getTid());
			
		}
		
			return transactHis8;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * @Retrieving balance amount
	 * 
	 */
	
	
	public static double getAccountBalance(int accountno) {
		double amount=0.0;
		
		 try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query4);
			pst.setLong(1,accountno);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				amount = rst.getDouble("balance");
			}
			return amount;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amount;
	}
	
	public static ArrayList<Transaction> GetSpecificTransaction(Transaction t1) throws ClassNotFoundException, SQLException{
		con = DBConnection.ConnectDB();
		PreparedStatement pst = con.prepareStatement(query12);
		String Tid = "";
		String accno = "";
		String taccno = "";
		String amount = "";
		
		if(t1.getTid()==0) {
			Tid="";
		}
		else if(t1.getTid()!=0) {
			Tid =String.valueOf(t1.getTid());
		}
		if(t1.getAccountNo()==0) {
			accno="";
		}
		else if(t1.getAccountNo()!=0) {
			accno =String.valueOf(t1.getAccountNo());
		}
		if(t1.getTaccountNo()==0) {
			taccno="";
			
		}
		else if(t1.getTaccountNo()!=0) {
			taccno =String.valueOf(t1.getTaccountNo());
		}
		
		if(t1.getAmount()==0.0) {
			amount="";
		}
		
		else if(t1.getAmount()!=0.0) {
			amount =String.valueOf(t1.getAmount());
		}
		System.out.println("DAO");
		System.out.println(Tid);
		System.out.println(accno);
		System.out.println(taccno);
		System.out.println(amount);
		
		
		
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		pst.setString(1,"%"+Tid+"%");
		pst.setString(2,"%"+accno+"%");
		pst.setString(3,"%"+taccno+"%");
		pst.setString(4,"%"+t1.getDate()+"%");
		pst.setString(5,"%"+amount+"%");
		pst.setString(6,"%"+t1.getStatus()+"%");
		
		ResultSet rst = pst.executeQuery();
		while(rst.next()) {
			Transaction t2=new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(4), rst.getDouble(5),rst.getInt(1),rst.getString(6));
			transList.add(t2);
			
		}
		return transList;
	}
	
	public static ArrayList<Transaction> GetSpecificIntraTransaction(Transaction t1) throws ClassNotFoundException, SQLException{
		con = DBConnection.ConnectDB();
		PreparedStatement pst = con.prepareStatement(query13);
		String Tid = "";
		String accno = "";
		String taccno = "";
		String amount = "";
		
		if(t1.getTid()==0) {
			Tid="";
		}
		else if(t1.getTid()!=0) {
			Tid =String.valueOf(t1.getTid());
		}
		if(t1.getAccountNo()==0) {
			accno="";
		}
		else if(t1.getAccountNo()!=0) {
			accno =String.valueOf(t1.getAccountNo());
		}
		if(t1.getTaccountNo()==0) {
			taccno="";
			
		}
		else if(t1.getTaccountNo()!=0) {
			taccno =String.valueOf(t1.getTaccountNo());
		}
		
		if(t1.getAmount()==0.0) {
			amount="";
		}
		
		else if(t1.getAmount()!=0.0) {
			amount =String.valueOf(t1.getAmount());
		}
		System.out.println("DAO");
		System.out.println(Tid);
		System.out.println(accno);
		System.out.println(taccno);
		System.out.println(amount);
		
		
		
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		pst.setString(1,"%"+Tid+"%");
		pst.setString(2,"%"+accno+"%");
		pst.setString(3,"%"+taccno+"%");
		pst.setString(4,"%"+t1.getDate()+"%");
		pst.setString(5,"%"+amount+"%");
		pst.setString(6,"%"+t1.getStatus()+"%");
		
		ResultSet rst = pst.executeQuery();
		while(rst.next()) {
			Transaction t2=new Transaction(rst.getLong(2), rst.getLong(3), rst.getString(5), rst.getDouble(4),rst.getInt(1),rst.getString(6));
			transList.add(t2);
			
		}
		return transList;
	}

}
