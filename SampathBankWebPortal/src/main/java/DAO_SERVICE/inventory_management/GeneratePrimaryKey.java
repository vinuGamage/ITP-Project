package DAO_SERVICE.inventory_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class GeneratePrimaryKey {

	
	private static Connection con;
	private static String query1="select * from im_inventory_item";
	private static String query2="select * from im_request_item";
	private static String query3="select * from im_history";
	
	
	public static String generateItemId() throws ClassNotFoundException, SQLException {
		
		int x;
		String oldId = null;
		String newId;
		con=DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "AA01";
		}
		else {
			ResultSet rst2 = pst.executeQuery(query1);
		while(rst2.next()) {
			
			oldId = rst2.getString(1);
		}
		
		
		x=Integer.parseInt(oldId.substring(2));
		 x=x+1;
		 DecimalFormat formatter = new DecimalFormat("00");
		 String newX = formatter.format(x);
		newId = oldId.substring(0,2)+ newX;
		return newId;
		}
	} 
	
	public static String generateRequestItemId() throws ClassNotFoundException, SQLException {
		
		
			int x=0;
			String oldId = null;
			String newId;
			con=DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			ResultSet rst= pst.executeQuery();
			
			if (rst.next()==false) {
				return "BB01";
			}
			else {
				ResultSet rst2 = pst.executeQuery();
			
				
				while(rst2.next()) {
				
				oldId = rst2.getString(1);
		
				}
			
			x=Integer.parseInt(oldId.substring(2));
			 x=x+1;
			 
			 DecimalFormat formatter = new DecimalFormat("00");
			 String newX = formatter.format(x);
			newId = oldId.substring(0,2)+ newX;
			
			return newId;
			}
	}
	
	
	
	public static String generateHistoryId() throws ClassNotFoundException, SQLException {
		
		
		int x=0;
		String oldId = null;
		String newId;
		con=DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query3);
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "HH01";
		}
		else {
			ResultSet rst2 = pst.executeQuery();
		
			
			while(rst2.next()) {
			
			oldId = rst2.getString(1);
	
			}
		
		x=Integer.parseInt(oldId.substring(2));
		 x=x+1;
		 
		 DecimalFormat formatter = new DecimalFormat("00");
		 String newX = formatter.format(x);
		newId = oldId.substring(0,2)+ newX;
		
		return newId;
		}
}
	
	
}
