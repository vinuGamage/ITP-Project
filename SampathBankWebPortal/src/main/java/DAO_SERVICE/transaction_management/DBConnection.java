package DAO_SERVICE.transaction_management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection;
	
	
	public static Connection ConnectDB() throws ClassNotFoundException, SQLException{
			
			System.out.println("hello");
			if(connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp_2018_mlb_g3_10_sampath_web_portal_vinu", "ITP", "thisstuff");
				System.out.println("connected");
			}
			return connection;
		} 
		

}
