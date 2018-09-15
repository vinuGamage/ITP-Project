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
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.validators.Validator;

public class OnlineEmployeeAccountManagementDAO {
	private static Connection con = null;
	
	public static Collection<Employee> getAllNewEmployees() {
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
		ResultSet EHPM_ResultSet0001 = null;
		Collection<Employee> newEmployeeList = new ArrayList<Employee> ();
		Employee employee = null;
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0028);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();

			while(EHPM_ResultSet0001.next()) {
				i++;
				employee = new Employee();
				employee.setPersonId(EHPM_ResultSet0001.getString("personId"));
				employee.setName(EHPM_ResultSet0001.getString("firstName"), EHPM_ResultSet0001.getString("middleName"), EHPM_ResultSet0001.getString("lastName"), EHPM_ResultSet0001.getString("otherNames"));
				employee.setEmployeeType(EHPM_ResultSet0001.getString("employeeType"));
				employee.setBranch(CEM.getBranch(EHPM_ResultSet0001.getString("branchId")));
				employee.setPhysicalRegistrationDate(EHPM_ResultSet0001.getDate("physicalRegistrationDate"));
				employee.setNic(EHPM_ResultSet0001.getString("nic"));
				employee.setPersonalEmail(EHPM_ResultSet0001.getString("personalEmail"));
				newEmployeeList.add(employee);
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
		
		if(i != 0)
			return newEmployeeList;
		else
			return null;
	}
	
	public static boolean createEmployeeOnlineAccount(Employee employee) {
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
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0008);
			EHPM_Prst0001.setInt(1, employee.getOnlineSecurityKey().getOnlineSecurityId());
			EHPM_Prst0001.setString(2, employee.getOnlineSecurityKey().getOnlineSecurityKey());
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0) {
				EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0009);
				EHPM_Prst0002.setString(1, employee.getOnlineAccount().getOnlinePersonId());
				EHPM_Prst0002.setString(2, employee.getOnlineAccount().getPhysicalPersonId());
				EHPM_Prst0002.setString(3, employee.getOnlineAccount().getUsername());
				EHPM_Prst0002.setString(4, employee.getOnlineAccount().getPassword());
				
				j = EHPM_Prst0002.executeUpdate();
				
				if(j != 0) {
					EHPM_Prst0003 = con.prepareStatement(EHPMQueries.EHPMquery0010);
					EHPM_Prst0003.setDate(1, DateConverter.getCurrentSqlDate());
					EHPM_Prst0003.setInt(2, employee.getOnlineSecurityKey().getOnlineSecurityId());
					EHPM_Prst0003.setString(3, employee.getPersonId());
					
					k = EHPM_Prst0003.executeUpdate();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(k != 0) {
/*			String subject = "Online Account Details of Employee: " + employee.getName().getFullName();
			String content = "Please use these credentials for your new online account at SampathBankWebPortal.\n"
					+ "\tYour Username: " + employee.getOnlineAccount().getUsername() + ".\n"
					+ "\tPassword: " + employee.getOnlineAccount().getPassword() + ".\n"
					+ "\tOnline Security Key: " + employee.getOnlineSecurityKey().getOnlineSecurityKey() + ".\n\n"
					+ "Use the online security key in emergencies.";
			EmailClient.sendMail(employee.getPersonalEmail(), subject, content);*/
			
			return true;
		}
		else
			return false;
	}
}
