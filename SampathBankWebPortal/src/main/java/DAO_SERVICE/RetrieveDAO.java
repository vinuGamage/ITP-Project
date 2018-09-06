package dao_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import dao_service.common_service.ConnectionPoolManager;

public class RetrieveDAO {
	static Connection con = null;
	
	private static final String EHPM_query0007_01 = "SELECT personId FROM person ORDER BY personId DESC LIMIT 1;";
	private static final String EHPM_query0008_01 = "SELECT onlineSecurityId FROM online_security_key ORDER BY onlineSecurityId DESC LIMIT 1;";
	

	/*
	 * 
	 * 
	 * @author Samarasekara S.A.M.I.D.
	 * @function Employee and HR Payroll Management
	 * @param
	 * @return
	 */
	public static String getLastPersonId() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		//Prepared Statement initializations
		PreparedStatement EHPM_Prst0007 = null;
		 //Result Set initializations
		ResultSet EHPM_ResultSet0007 = null;
		
		String last = null;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0007 = con.prepareStatement(EHPM_query0007_01);
			EHPM_ResultSet0007 = EHPM_Prst0007.executeQuery();
			
			while(EHPM_ResultSet0007.next()) {
				last = EHPM_ResultSet0007.getString(1);
				System.out.println(last);
			}
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0007 != null)
					EHPM_ResultSet0007.close();
				
				if(EHPM_Prst0007 != null)
					EHPM_Prst0007.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		cpmObj.printDatabaseStatus();
		return last;
	}
	
	public static int getLastSecurityId() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		//Prepared Statement initializations
		PreparedStatement EHPM_Prst0008 = null;
		 //Result Set initializations
		ResultSet EHPM_ResultSet0008 = null;
		
		int last = 0;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0008 = con.prepareStatement(EHPM_query0008_01);
			EHPM_ResultSet0008 = EHPM_Prst0008.executeQuery();
			
			if(EHPM_ResultSet0008.next()) {
				last = EHPM_ResultSet0008.getInt(1);
				System.out.println(last);
			}
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0008 != null)
					EHPM_ResultSet0008.close();
				
				if(EHPM_Prst0008 != null)
					EHPM_Prst0008.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		cpmObj.printDatabaseStatus();
		return last;
	}
}
