package DAO_SERVICE.employee_hr_payroll_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.user_management.OnlineAccount;

public class LeaveManagementEmployeeDAO {
	private static Connection con = null;
	
	public static LeaveDetails getLeaveDetails(String employeeId) {
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		
		PreparedStatement UM_Prst0001 = null;
		ResultSet UM_ResultSet0001 = null;
		String usernameDB = null;
		String passwordDB = null;
		OnlineAccount onlineAccount = null;
		
		//Checking online_customer_credentials table
		try {
			UM_Prst0001 = con.prepareStatement(UMQueries.queryUM_01);
			UM_ResultSet0001 = UM_Prst0001.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_ResultSet0001 != null)
					UM_ResultSet0001.close();
				
				if(UM_Prst0001 != null)
					UM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
}
