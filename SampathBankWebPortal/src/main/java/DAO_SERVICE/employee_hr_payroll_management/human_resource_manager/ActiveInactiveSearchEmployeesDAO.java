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
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.OnlineSecurityKey;
import POJO_MODEL.user_management.RegistrationDates;

public class ActiveInactiveSearchEmployeesDAO {
	private static Connection con = null;
	
	public static Collection<Employee> getAllActiveEmployees() {
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
		
		CommonEntityManager CEM = CommonEntityManager.getInstance();
		PreparedStatement EHPM_Prst0001 = null;
		PreparedStatement EHPM_Prst0002 = null;
		PreparedStatement EHPM_Prst0003 = null;
		ResultSet EHPM_ResultSet0001 = null;
		ResultSet EHPM_ResultSet0002 = null;
		ResultSet EHPM_ResultSet0003 = null;
		Collection<Employee> activeEmployeeList = new ArrayList<Employee> ();
		Employee employee = null;
		int i = 0;
		int onlineSecurityId = 0;
		
		
		//Checking employee and person table for active employees
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0029);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next()) {
				i++;
				employee = null;
				employee = new Employee();
				
				employee.setPersonId(EHPM_ResultSet0001.getString("personId"));
				employee.setName(EHPM_ResultSet0001.getString("firstName"), EHPM_ResultSet0001.getString("middleName"), EHPM_ResultSet0001.getString("lastName"), EHPM_ResultSet0001.getString("otherNames"));
				employee.setAddress(EHPM_ResultSet0001.getString("addressStreet01"), EHPM_ResultSet0001.getString("addressStreet02"), EHPM_ResultSet0001.getString("addressCity"), EHPM_ResultSet0001.getString("addressProvince"), EHPM_ResultSet0001.getInt("addressZipCode"));
				employee.setNic(EHPM_ResultSet0001.getString("nic"));
				employee.setDateOfBirth(EHPM_ResultSet0001.getDate("dateOfBirth"));
				employee.setPersonalEmail(EHPM_ResultSet0001.getString("personalEmail"));
				employee.setRegistrationDates(new RegistrationDates(EHPM_ResultSet0001.getDate("physicalRegistrationDate"), EHPM_ResultSet0001.getDate("onlineRegistrationDate")));
				employee.setGender(CEM.getGender(EHPM_ResultSet0001.getInt("genderId")));
				employee.setNationality(CEM.getNationality(EHPM_ResultSet0001.getInt("nationalityId")));
				employee.setBranch(CEM.getBranch(EHPM_ResultSet0001.getString("branchId")));
				employee.setHomeContact(EHPM_ResultSet0001.getString("homeContact"));
				employee.setMobileContact(EHPM_ResultSet0001.getString("mobileContact"));
				employee.setDepartment(CEM.getDepartment(EHPM_ResultSet0001.getString("departmentId")));
				employee.setCompanyEmail(EHPM_ResultSet0001.getString("companyEmail"));
				employee.setDesignation(CEM.getDesignation(EHPM_ResultSet0001.getInt("designationId")));
				employee.setEmployeeType(EHPM_ResultSet0001.getString("employeetype"));
				
				onlineSecurityId = EHPM_ResultSet0001.getInt("onlineSecurityId");
				if(onlineSecurityId != 0) {
					System.out.println(employee.getName().getFirstName() + " has an online account.");
					//Retrieving from online_security_key table
					EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0030);
					EHPM_Prst0002.setInt(1, onlineSecurityId);
					EHPM_ResultSet0002 = EHPM_Prst0002.executeQuery();
					
					if(EHPM_ResultSet0002.next()) {
						employee.setOnlineSecurityKey(new OnlineSecurityKey(onlineSecurityId, EHPM_ResultSet0002.getString("onlineSecurityKey")));
						//Retrieving from online_employee_credentials table
						EHPM_Prst0003 = con.prepareStatement(EHPMQueries.EHPMquery0031);
						EHPM_Prst0003.setString(1, employee.getPersonId());
						EHPM_ResultSet0003 = EHPM_Prst0003.executeQuery();
						if(EHPM_ResultSet0003.next()) {
							employee.setOnlineAccount(new OnlineAccount(EHPM_ResultSet0003.getString("onlineEmployeeId"), employee.getPersonId(), EHPM_ResultSet0003.getString("username")));
						} else {
							
						}
						
					} else {
						
					}
				} else {
					employee.setOnlineSecurityKey(null);
				}
				
				activeEmployeeList.add(employee);
			}
			
			if(i == 0) {
				activeEmployeeList = null;
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
		
		return activeEmployeeList;
	}
	
	public static boolean removeEmployeeOnlineAccount(Employee employee) {
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
		
		CommonEntityManager CEM = CommonEntityManager.getInstance();
		PreparedStatement EHPM_Prst0001 = null;
		PreparedStatement EHPM_Prst0002 = null;
		PreparedStatement EHPM_Prst0003 = null;
		int i = 0;
		int j = 0;
		int k = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0032);
			EHPM_Prst0001.setString(1, employee.getPersonId());
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0) {
				EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0033);
				EHPM_Prst0002.setInt(1, employee.getOnlineSecurityKey().getOnlineSecurityId());
				j = EHPM_Prst0002.executeUpdate();
				
				if(j != 0) {
					EHPM_Prst0003 = con.prepareStatement(EHPMQueries.EHPMquery0034);
					EHPM_Prst0003.setString(1, employee.getPersonId());
					k = EHPM_Prst0003.executeUpdate();
				} else {
					
				}
			} else {
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_Prst0003 != null)
					EHPM_Prst0003.close();
				
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
		
		if(employee.getOnlineSecurityKey() == null)
			return true;
		else {
			if(k != 0)
				return true;
			else
				return false;
		}
	}

	public static boolean inactivateEmployee(Employee employee, String reason) {
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
		
		CommonEntityManager CEM = CommonEntityManager.getInstance();
		PreparedStatement EHPM_Prst0001 = null;
		PreparedStatement EHPM_Prst0002 = null;
		int i = 0;
		int j = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0035);
			EHPM_Prst0001.setString(1, employee.getPersonId());
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0) {
				EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0036);
				EHPM_Prst0002.setString(1, employee.getPersonId());
				EHPM_Prst0002.setString(2, reason);
				j = EHPM_Prst0002.executeUpdate();
			} else {
				
			}
			
			
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
		
		if(j != 0)
			return true;
		else
			return false;
	}
}
