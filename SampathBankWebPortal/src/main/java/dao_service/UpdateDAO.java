package dao_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dao_service.common_service.ConnectionPoolManager;
import pojo_model.employee_hr_payroll_management.Employee;
import pojo_model.employee_hr_payroll_management.EmployeeRegHelp;
import pojo_model.employee_hr_payroll_management.generators.OnlineSecurityKeyGenerator;
import pojo_model.employee_hr_payroll_management.generators.PrimaryKeyGenerator;
import pojo_model.user_management.Gender;
import pojo_model.user_management.OnlineSecurityKey;

public class UpdateDAO {
	static Connection con = null;
	private static final String EHPM_query0009_01 = "INSERT INTO online_security_key (onlineSecurityId, onlineSecurityKey) VALUES (?, ?);";
	private static final String EHPM_query0010_01 = "INSERT INTO person (personId, firstName, middleName, lastName, otherNames, addressStreet01,"
			+ "addressStreet02, addressCity, addressProvince, addressZipCode, physicalRegistrationDate, onlineRegistrationDate, personalEmail, "
			+ "genderId, nic, nationalityId, dateOfBirth, branchId, onlineSecurityId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	public static boolean storeEmployee(Employee employee) {
		EmployeeRegHelp<Boolean, Integer> helper =	saveOnlineSecurityKey(employee);
		
		if(helper.getX()) {
			employee.setOnlineSecurityId(helper.getY());
			if(savePerson(employee)) {
				return true;
			}
			else
				return false;
		}
		else {
			System.out.println("Fail");
			return false;
		}
	}
	
	private static EmployeeRegHelp<Boolean, Integer> saveOnlineSecurityKey(Employee employee) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		//Prepared Statement initializations
		PreparedStatement EHPM_Prst0009 = null;
		 //Result Set initializations
		ResultSet EHPM_ResultSet0009 = null;
		//Required Class Object
		int i = 0;
		int key = 0;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			key = new PrimaryKeyGenerator().newSecurityId();
			EHPM_Prst0009 = con.prepareStatement(EHPM_query0009_01);
			EHPM_Prst0009.setInt(1, key);
			EHPM_Prst0009.setString(2, new OnlineSecurityKeyGenerator().generateOnlineSecurityKey());
			i = EHPM_Prst0009.executeUpdate();
			
			
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0009 != null)
					EHPM_ResultSet0009.close();
				
				if(EHPM_Prst0009 != null)
					EHPM_Prst0009.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		boolean x = true;
		EmployeeRegHelp<Boolean, Integer> helper = new EmployeeRegHelp<Boolean, Integer> (x, key);
		
		if(i > 0) {
			helper.setX(true);
			helper.setY(key);
		}
		else {
			helper.setX(false);
			helper.setY(key);
		}
		return helper;
	}
	
	private static boolean savePerson(Employee employee) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		//Prepared Statement initializations
		PreparedStatement EHPM_Prst0010 = null;
		 //Result Set initializations
		ResultSet EHPM_ResultSet0010 = null;
		//Required Class Object
		
		int i = 0;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0010 = con.prepareStatement(EHPM_query0010_01);
			EHPM_Prst0010.setString(1, employee.getPersonId());
			EHPM_Prst0010.setString(2, employee.getName().getFirstName());
			EHPM_Prst0010.setString(3, employee.getName().getMiddleName());
			EHPM_Prst0010.setString(4, employee.getName().getLastName());
			EHPM_Prst0010.setString(5, employee.getName().getOtherNames());
			EHPM_Prst0010.setString(6, employee.getAddress().getAddressStreet01());
			EHPM_Prst0010.setString(7, employee.getAddress().getAddressStreet02());
			EHPM_Prst0010.setString(8, employee.getAddress().getAddressCity());
			EHPM_Prst0010.setString(9, employee.getAddress().getAddressProvince());
			EHPM_Prst0010.setInt(10, employee.getAddress().getAddressZIPCode());
			EHPM_Prst0010.setDate(11, employee.getRegistrationDates().getPhysicalRegistrationDate());
			EHPM_Prst0010.setDate(12, employee.getRegistrationDates().getOnlineRegistrationDate());
			EHPM_Prst0010.setString(13, employee.getPersonalEmail());
			EHPM_Prst0010.setInt(14, employee.getGenderId());
			EHPM_Prst0010.setString(15, employee.getNic());
			EHPM_Prst0010.setInt(16, employee.getNationalityId());
			EHPM_Prst0010.setDate(17, employee.getDateOfBirth());
			EHPM_Prst0010.setString(18, employee.getBranchId());
			EHPM_Prst0010.setInt(19, employee.getOnlineSecurityId());
			
			
			i = EHPM_Prst0010.executeUpdate();
			if(i > 0)
			System.out.println("Yay " + i);
			
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0010 != null)
					EHPM_ResultSet0010.close();
				
				if(EHPM_Prst0010 != null)
					EHPM_Prst0010.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		
		if(i > 0)
			return true;
		else return false;
	}
}