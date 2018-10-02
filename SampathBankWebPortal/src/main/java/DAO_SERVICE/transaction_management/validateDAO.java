package DAO_SERVICE.transaction_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


import POJO_MODEL.transaction_management.Login;
import POJO_MODEL.transaction_management.Transaction;




public class validateDAO {

	private static Connection con;
	
	private static String query1 = "SELECT * FROM login WHERE user = ?";
	private static String query2 = "SELECT * FROM bankaccount WHERE accno=? ";
	private static String query3 = "SELECT * FROM pin WHERE accno=?";
	
	
	/*
	 * @validating the user
	 * 
	 */
	
	public static boolean validateUser(Login l) {
		try {
			con = DBConnection.ConnectDB();
			
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setString(1, l.getUsername());
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				return true;
			}
			
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
	 * @validating the debit account existency
	 * 
	 */
	
	public static boolean validateDebitAccount(Transaction t) {
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			pst.setLong(1, t.getAccountNo());
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				return true;
			}
			
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
	 * @validating the credit account existency
	 * 
	 */
	
	public static boolean validateCreditAccount(Transaction t) {
		try {
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			pst.setLong(1, t.getTaccountNo());
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				return true;
			}
			
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
	 * @validating the pin id 
	 * 	 
	 */
	
	public static int validatePin(Login l) {
		
		try {
				
				int pinid = 0;
			
				con = DBConnection.ConnectDB();
				
				PreparedStatement pst = con.prepareStatement(query3);
				pst.setLong(1, l.getAccount());
				ResultSet rst = pst.executeQuery();
				while(rst.next()) {
					pinid = Integer.parseInt(rst.getString("pinid"));
					
				}
				return pinid;
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public static boolean validateExistingBalanceAmount(double amount,long accno) {
		
		
		try {
			double Amount=0.0;
			con = DBConnection.ConnectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			pst.setLong(1,accno);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				Amount = rst.getDouble(2);
			}
			
			if(amount <= Amount)
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
