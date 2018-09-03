package dao_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import dao_service.common_service.ConnectionPoolManager;

public class RetrieveDAO {
	static Connection con = null;
	
	private static final String EHPM_query0001 = "SELECT * FROM gender;";
	private static final String EHPM_query0002 = "SELECT * FROM nationality;";
	private static final String EHPM_query0003 = "SELECT * FROM role;";
	private static final String EHPM_query0004 = "SELECT * FROM permission;";
	private static final String EHPM_query0005 = "SELECT * FROM branch;";
	private static final String EHPM_query0006 = "SELECT * FROM branch_contact;";
	

	/*
	 * 
	 * 
	 * @author Samarasekara S.A.M.I.D.
	 * @function Employee and HR Payroll Management
	 * @param
	 * @return
	 */
	public static void initializeCommonPojoClasses() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		//Prepared Statement initializations
		PreparedStatement EHPM_Prst0001 = null;
		 //Result Set initializations
		ResultSet EHPM_ResultSet0001 = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0001 = con.prepareStatement(EHPM_query0001);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next())
				System.out.println(EHPM_ResultSet0001.getString(2));
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		cpmObj.printDatabaseStatus();
	}
	
	private void initializeGender() {
		
	}
}
