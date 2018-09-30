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
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.RegistrationDates;

public class SearchForEmployeeDAO {
	private static Connection con = null;
	
	public static Collection<Employee> getEmployeesForSearch(String search) {
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
		Collection<Employee> employeeSearchList01 = new ArrayList<Employee> ();
		Employee employee = null;
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0057);
			EHPM_Prst0001.setString(1, "%"+search+"%");//personId
			EHPM_Prst0001.setString(2, "%"+search+"%");//firstName
			EHPM_Prst0001.setString(3, "%"+search+"%");//middleName
			EHPM_Prst0001.setString(4, "%"+search+"%");//lastName
			EHPM_Prst0001.setString(5, "%"+search+"%");//otherNames
			EHPM_Prst0001.setString(6, "%"+search+"%");//addressStreet01
			EHPM_Prst0001.setString(7, "%"+search+"%");//addressStreet02
			EHPM_Prst0001.setString(8, "%"+search+"%");//addressCity
			EHPM_Prst0001.setString(9, "%"+search+"%");//addressProvince
			EHPM_Prst0001.setString(10, "%"+search+"%");//addressZipCode
			EHPM_Prst0001.setString(11, "%"+search+"%");//nic
			EHPM_Prst0001.setString(12, "%"+search+"%");//personalEmail
			EHPM_Prst0001.setString(13, "%"+search+"%");//branchId
			EHPM_Prst0001.setString(14, "%"+search+"%");//homeContact
			EHPM_Prst0001.setString(15, "%"+search+"%");//mobileContact
			EHPM_Prst0001.setString(16, "%"+search+"%");//departmentId
			EHPM_Prst0001.setString(17, "%"+search+"%");//companyEmail
			EHPM_Prst0001.setString(18, "%"+search+"%");//employeeType
			
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next()) {
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
				
				employeeSearchList01.add(employee);
				i++;
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
			employeeSearchList01 = null;
		
	
		return employeeSearchList01;
	}
}
