package DAO_SERVICE.employee_hr_payroll_management.human_resource_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;

public class HRLeaveRequestManagementDAO {
	private static Connection con = null;
	
	public static Collection<LeaveRequest> getAllLeaveRequestsForManagement() {
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
		
		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		Collection<LeaveRequest> managementLeaveRequestList = new ArrayList<LeaveRequest> ();
		LeaveRequest leaveRequest = null;
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0039);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next()) {
				i++;
				leaveRequest = new LeaveRequest();
				
				leaveRequest.setEmployeeId(EHPM_ResultSet0001.getString("employeeId"));
				leaveRequest.setLeaveRequestId(EHPM_ResultSet0001.getInt("leaveRequestId"));
				leaveRequest.setLeaveType(EHPM_ResultSet0001.getString("leaveType"));
				leaveRequest.setLeaveDescription(EHPM_ResultSet0001.getString("leaveDescription"));
				leaveRequest.setLeaveRequestedDate(EHPM_ResultSet0001.getDate("leaveRequestedDate"));
				leaveRequest.setLeaveStartDate(EHPM_ResultSet0001.getDate("leaveStartDate"));
				leaveRequest.setLeaveDuration(EHPM_ResultSet0001.getInt("leaveDuration"));
				leaveRequest.setLeaveStatus(EHPM_ResultSet0001.getString("leaveStatus"));
				leaveRequest.setLeaveReviewSpeed(EHPM_ResultSet0001.getString("leaveReviewSpeed"));
				
				managementLeaveRequestList.add(leaveRequest);
			}
			
		} catch (SQLException e) {
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
		
		if(i == 0)
			managementLeaveRequestList = null;
		
	
		return managementLeaveRequestList;
	}

	public static boolean grantLeave(LeaveRequest leaveR, String empId) {
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
		
		PreparedStatement EHPM_Prst0001 = null;
		PreparedStatement EHPM_Prst0002 = null;
		int i = 0;
		int j = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0040);
			EHPM_Prst0001.setString(1, "granted");
			EHPM_Prst0001.setString(2, empId);
			EHPM_Prst0001.setInt(3, leaveR.getLeaveRequestId());
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0) {
				EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0041);
				EHPM_Prst0002.setInt(1, leaveR.getLeaveDuration());
				EHPM_Prst0002.setDate(2, leaveR.getLeaveStartDate());
				EHPM_Prst0002.setString(3, leaveR.getEmployeeId());
				j = EHPM_Prst0002.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_Prst0002 != null)
					EHPM_Prst0002.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		
		if(j == 0)
			return false;
		else
			return true;
	}
	
	public static boolean rejectLeave(int leaveReqId, String empId) {
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
		
		PreparedStatement EHPM_Prst0001 = null;
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0040);
			EHPM_Prst0001.setString(1, "rejected");
			EHPM_Prst0001.setString(2, empId);
			EHPM_Prst0001.setInt(3, leaveReqId);
			i = EHPM_Prst0001.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		
		if(i == 0)
			return false;
		else
			return true;
	}
}
