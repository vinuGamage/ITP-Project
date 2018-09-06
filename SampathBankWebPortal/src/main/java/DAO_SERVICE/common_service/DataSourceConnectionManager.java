//package dao_service.common_service;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//
//
//public class DataSourceConnectionManager {
//	private static final String db_url = "mysql.url";
//	private static final String db_username = "mysql.username";
//	private static final String db_password = "mysql.password";
//	private static Properties properties = null;
//	private static MysqlDataSource mySqlDS = null;
//	
//	static {
//			String resource = "src/main/resources/database.properties";
//			properties = new Properties();
//		try {
//			properties.load(resourceStream);
//			mySqlDS = new MysqlDataSource();
//			mySqlDS.setURL(properties.getProperty(db_url));
//			mySqlDS.setUser(properties.getProperty(db_username));
//			mySqlDS.setPassword(properties.getProperty(db_password));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static MysqlDataSource getMySQLDataSource() {
//		return mySqlDS;
//	}
//}

package dao_service.common_service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DataSourceConnectionManager {
	private static final String db_url = "mysql.url";
	private static final String db_username = "mysql.username";
	private static final String db_password = "mysql.password";
	private static Properties properties = null;
	private static MysqlDataSource mySqlDS = null;
	
	static {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("database.properties"));
			
			mySqlDS = new MysqlDataSource();
			mySqlDS.setURL(properties.getProperty(db_url));
			mySqlDS.setUser(properties.getProperty(db_username));
			mySqlDS.setPassword(properties.getProperty(db_password));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MysqlDataSource getMySQLDataSource() {
		return mySqlDS;
	}
}
