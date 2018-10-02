package DAO_SERVICE.transaction_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO_MODEL.transaction_management.Login;

public class otherDAO {

	private static Connection con;
	private static String query = "INSERT INTO pin (pinid,accno) VALUES (?,?)"; 
	
	public static int generatePin(Login l) {
	
		try {
			con = DBConnection.ConnectDB();
			
			//generate a 4 digit integer 1000 <10000
	        int randomPIN = (int)(Math.random()*9000)+1000;
			
	        PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, randomPIN);
			pst.setInt(2, l.getAccount());
			pst.execute();
	        
			return randomPIN;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
		
	}

}
