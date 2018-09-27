package DAO_SERVICE.inventory_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static Connection connection;
	
	public static Connection connectDB() throws SQLException, ClassNotFoundException {
		
		String url="jdbc:mysql://localhost:3306/itp_2018_mlb_g3_10_sampath_web_portal_atheeq?autoReconnect=true&useSSL=false";
		String user="ITP";
		String pass="thisstuff";
		
		
		if(connection== null || connection.isClosed()) {
		
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, pass);
			
			
			
		}
		return connection;
		
	}

}
