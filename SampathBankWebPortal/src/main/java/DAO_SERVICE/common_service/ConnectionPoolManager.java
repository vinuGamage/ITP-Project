package DAO_SERVICE.common_service;

import javax.sql.DataSource;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;


public class ConnectionPoolManager {
	static final String mysql_driver = "com.mysql.jdbc.Driver";
	static final String mysql_db_url = "jdbc:mysql://localhost:3306/sampath_web_portal_itp_2018_mlb_g3_10_version_beginner?autoReconnect=true&useSSL=false";
	static final String mysql_db_username = "ITP";
	static final String mysql_db_password = "thisstuff";
	
	private static GenericObjectPool genericPool = null;
	
    @SuppressWarnings("unused")
    public DataSource initializePool() throws Exception {
    	Class.forName(mysql_driver);
    	
    	// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
    	genericPool = new GenericObjectPool();
    	genericPool.setMaxActive(5);
    	
        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(mysql_db_url, mysql_db_username, mysql_db_password);
        
        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, genericPool, null, null, false, true);
        
        return new PoolingDataSource(genericPool);
    }
    
    public GenericObjectPool getConnectionPool() {
        return genericPool;
    }

    // This Method Is Used To Print The Connection Pool Status
    public void printDatabaseStatus() {
        System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
    }

}
