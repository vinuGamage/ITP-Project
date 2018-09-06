package DAO_SERVICE.common_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/sampath_web_portal_itp_2018_mlb_g3_10_version_beginner?autoReconnect=true&useSSL=false";
	private static String username = "ITP";
	private static String password = "thisstuff";
	
	public static Connection connect() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(con != null) {
			// Critical Point Marker
			System.out.println("Connected from connect() method!");
		}
		
		else {
			// Critical Point Marker
			System.out.println("Not Connected from connect() method!");
		}
		
	return con;
	}
	
	public static void connectionClose() {
		
	}
}
