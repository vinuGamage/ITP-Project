package DAO_SERVICE.user_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.user_management.Gender;
import POJO_MODEL.user_management.validators.Validator;

public class LoginDAO {
	private static Connection con = null;
	
	public static void checkLoginCredentials(String username, String password) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement UM_Prst0001 = null;
		ResultSet UM_ResultSet0001 = null;
		String usernameDB = null;
		String passwordDB = null;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			UM_Prst0001 = con.prepareStatement(UMQueries.queryUM_01);
			UM_Prst0001.setString(1, username);
			UM_Prst0001.setString(2, password);
			UM_ResultSet0001 = UM_Prst0001.executeQuery();
			
			while(UM_ResultSet0001.next()) {
				usernameDB = UM_ResultSet0001.getString("username");
				passwordDB = UM_ResultSet0001.getString("password");
				
				if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
					
				}
				else {
					PreparedStatement UM_Prst0002 = null;
					ResultSet UM_ResultSet0002 = null;
					UM_Prst0002 = con.prepareStatement(UMQueries.queryUM_02);
					UM_Prst0002.setString(1, username);
					UM_Prst0002.setString(2, password);
					UM_ResultSet0002 = UM_Prst0002.executeQuery();
					
					if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
						
					}
					
					else {
						
					}
				}
			}
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/*if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();*/
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
}
