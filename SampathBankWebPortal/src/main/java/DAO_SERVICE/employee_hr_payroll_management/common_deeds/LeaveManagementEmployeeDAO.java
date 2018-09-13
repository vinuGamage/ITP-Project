package DAO_SERVICE.employee_hr_payroll_management.common_deeds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.employee_hr_payroll_management.PrimaryKeyGeneratorDAO;
import DAO_SERVICE.queries.EHPMQueries;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
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
		
		
		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		LeaveDetails leaveDetails = null;
		
		//Checking online_customer_credentials table
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0018);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next()) {
				leaveDetails = new LeaveDetails(EHPM_ResultSet0001.getString("employeeId"), EHPM_ResultSet0001.getInt("noOfLeavesLeft"), EHPM_ResultSet0001.getDate("lastEffectiveLeaveDate"));
//				if(EHPM_ResultSet0001.getDate("lastEffectiveLeaveDate") == null || EHPM_ResultSet0001.getDate("lastEffectiveLeaveDate").equals(null)) {
//					leaveDetails.setLastEffectiveLeaveDate(null);
//				} else {
//					leaveDetails.setLastEffectiveLeaveDate(EHPM_ResultSet0001.getDate("lastEffectiveLeaveDate"));
//				}
			} else {
				leaveDetails = null;
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
		
		return leaveDetails;
	}
	
	public static boolean recordInitialLeaveRequest(LeaveRequest leaveRequest) {
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
		int i = 0;
		
		//Checking online_customer_credentials table
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0021);
			EHPM_Prst0001.setString(1, leaveRequest.getEmployeeId());
			EHPM_Prst0001.setString(3, leaveRequest.getLeaveType());
			EHPM_Prst0001.setString(4, leaveRequest.getLeaveDescription());
			EHPM_Prst0001.setDate(5, leaveRequest.getLeaveRequestedDate());
			EHPM_Prst0001.setDate(6, leaveRequest.getLeaveStartDate());
			EHPM_Prst0001.setInt(7, leaveRequest.getLeaveDuration());
			EHPM_Prst0001.setString(8, "submitted");
			EHPM_Prst0001.setInt(2, PrimaryKeyGeneratorDAO.LeaveRequestKeyGenerator());
			i = EHPM_Prst0001.executeUpdate();
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
			return false;
		else
			return true;
	}

	public static Collection<LeaveRequest> getLeaveHistory(String employeeId) {
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
		int i = 0;
		Collection<LeaveRequest> leaveRequestList = new ArrayList<LeaveRequest>();
		
		//Checking online_customer_credentials table
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0022);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next()) {
				LeaveRequest leaveRequest = new LeaveRequest();
				leaveRequest.setEmployeeId(EHPM_ResultSet0001.getString("employeeId"));
				leaveRequest.setLeaveRequestId(EHPM_ResultSet0001.getInt("leaveRequestId"));
				leaveRequest.setLeaveType(EHPM_ResultSet0001.getString("leaveType"));
				leaveRequest.setLeaveDescription(EHPM_ResultSet0001.getString("leaveDescription"));
				leaveRequest.setLeaveRequestedDate(EHPM_ResultSet0001.getDate("leaveRequestedDate"));
				leaveRequest.setLeaveStartDate(EHPM_ResultSet0001.getDate("leaveStartDate"));
				leaveRequest.setLeaveDuration(EHPM_ResultSet0001.getInt("leaveDuration"));
				leaveRequest.setLeaveStatus(EHPM_ResultSet0001.getString("leaveStatus"));
				if(leaveRequest.getLeaveStatus().equals("submitted"))
					leaveRequest.setLeaveReviewedBy("Not Yet Reviewed");
				else
					leaveRequest.setLeaveReviewedBy(EHPM_ResultSet0001.getString("leaveReviewedBy"));
				
				leaveRequestList.add(leaveRequest);

				i++;
			}
			if(i == 0) {
				leaveRequestList = null;
				System.out.println("LEAVE REQUEST LIST NULL");
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
		
		return leaveRequestList;
	}
	
	public static boolean getWhetherSubmitted(String employeeId) {
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
		boolean i = false;
		
		//Checking online_customer_credentials table
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0023);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_Prst0001.setString(2, "submitted");
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next()) {
				i = true;
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
		
		return i;
	}
}