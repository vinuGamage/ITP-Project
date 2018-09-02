package dao_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao_service.common_service.ConnectionManager;

public class RetrieveDAO {
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
		Connection con = ConnectionManager.connect();
		PreparedStatement EHPM_Prst0001 = null;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPM_query0001);
			ResultSet EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
