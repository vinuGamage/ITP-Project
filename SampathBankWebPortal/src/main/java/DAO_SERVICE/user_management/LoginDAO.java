package DAO_SERVICE.user_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.NormalEmployee;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.GenericLogin;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.OnlineSecurityKey;
import POJO_MODEL.user_management.RegistrationDates;
import POJO_MODEL.user_management.validators.Validator;

public class LoginDAO {
	private static Connection con = null;
	
	public static GenericLogin<Boolean, String, Customer, Employee> checkLoginCredentials(String username, String password, CommonEntityManager commonEntityManager) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		GenericLogin<Boolean, String, Customer, Employee> genericLogin = new GenericLogin<Boolean, String, Customer, Employee>();
		genericLogin.setFound(false);
		genericLogin.setType(null);
		genericLogin.setCustomer(null);
		genericLogin.setEmployee(null);
		
		OnlineAccount onlineAccount = checkOnlineCustomerCredentials(username, password);
		if(onlineAccount != null) {
			Customer customer = checkCustomerPhysicalDetails(onlineAccount, commonEntityManager);
			
			if(customer != null ) {
				genericLogin.setFound(true);
				genericLogin.setType("customer");
				genericLogin.setCustomer(customer);
				genericLogin.setEmployee(null);
			} else {
				genericLogin.setFound(false);
				genericLogin.setType("customerError01");
				genericLogin.setCustomer(null);
				genericLogin.setEmployee(null);
			}
		} else {
			onlineAccount = checkOnlineEmployeeCredentials(username, password);
			if(onlineAccount != null) {
				Employee employee = checkEmployeePhysicalDetails(onlineAccount, commonEntityManager);
				
				if(employee != null) {
					genericLogin.setFound(true);
					genericLogin.setType("employee");
					genericLogin.setCustomer(null);
					genericLogin.setEmployee(employee);
				} else {
					genericLogin.setFound(false);
					genericLogin.setType("employeeError01");
					genericLogin.setCustomer(null);
					genericLogin.setEmployee(null);
				}
			}else {
				genericLogin.setFound(false);
				genericLogin.setType("none");
				genericLogin.setCustomer(null);
				genericLogin.setEmployee(null);
			}
		}
		return genericLogin;
	}
	
	private static OnlineAccount checkOnlineCustomerCredentials(String username, String password) {
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
			UM_Prst0001.setString(1, username);
			UM_Prst0001.setString(2, password);
			UM_ResultSet0001 = UM_Prst0001.executeQuery();
			
			boolean m = false;
			boolean x = false;
			while(UM_ResultSet0001.next()) {
				System.out.println("Some records found on online_customer_credentials(online_customer_credentials)");
				System.out.println("Let's see whether they are exactly matching(online_customer_credentials)");
				usernameDB = UM_ResultSet0001.getString("username");
				passwordDB = UM_ResultSet0001.getString("password");
				m = true;
				
				if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
					//online_customer_credentials found
					System.out.println("Exactly matching record found on online_customer_credentials table(online_customer_credentials)");
					
					//OnlineAccount object creation for customer
					System.out.println("Extracting online_customer_credentials table(online_customer_credentials)");
					
					onlineAccount = new OnlineAccount();
					onlineAccount.setOnlinePersonId(UM_ResultSet0001.getString("onlineCustomerId"));
					onlineAccount.setPhysicalPersonId(UM_ResultSet0001.getString("customerId"));
					onlineAccount.setUsername(UM_ResultSet0001.getString("username"));
					x = true;
					break;
				} else {
					System.out.println("No record found to be EXACTLY MATCHING(online_customer_credentials)");
				}
			}
			
			if(m == true && x == false)
				System.out.println("Though there were record, not EXACTLY mathching(online_customer_credentials)");
			
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
		return onlineAccount;
	}
	
	public static Customer checkCustomerPhysicalDetails(OnlineAccount onlineAccount, CommonEntityManager commonEntityManager) {
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
		
		PreparedStatement UM_Prst0006 = null;
		ResultSet UM_ResultSet0006 = null;
		Customer customer = null;
		 
		try {
			//Joining person and customer tables and querying for specific id
			UM_Prst0006 = con.prepareStatement(UMQueries.queryUM_06);
			UM_Prst0006.setString(1, onlineAccount.getPhysicalPersonId());
			UM_ResultSet0006 = UM_Prst0006.executeQuery();
			
			//if a record exists for the retrieved online_customer_account
			if(UM_ResultSet0006.next()) {
				System.out.println("Record found on joined table for retrieved customerId from online_customer_credentials table");
				
				customer = new Customer();
				customer.setOnlineAccount(onlineAccount);
				//starting setting common person attributes
				customer.setPersonId(UM_ResultSet0006.getString("customerId"));
				customer.setName(UM_ResultSet0006.getString("firstName"), UM_ResultSet0006.getString("middleName"), 
						UM_ResultSet0006.getString("lastName"), UM_ResultSet0006.getString("otherNames"));
				customer.setAddress(UM_ResultSet0006.getString("addressStreet01"), UM_ResultSet0006.getString("addressStreet02"), 
						UM_ResultSet0006.getString("addressCity"), UM_ResultSet0006.getString("addressProvince"), UM_ResultSet0006.getInt("addressZipCode"));
				customer.setNic(UM_ResultSet0006.getString("nic"));
				customer.setDateOfBirth(UM_ResultSet0006.getDate("dateOfBirth"));
				customer.setPersonalEmail(UM_ResultSet0006.getString("personalEmail"));
				customer.setRegistrationDates(new RegistrationDates(UM_ResultSet0006.getDate("physicalRegistrationDate"), UM_ResultSet0006.getDate("onlineRegistrationDate")));
				customer.setGender(commonEntityManager.getGender(UM_ResultSet0006.getInt("genderId")));
				customer.setNationality(commonEntityManager.getNationality(UM_ResultSet0006.getInt("nationalityId")));
				customer.setBranch(commonEntityManager.getBranch(UM_ResultSet0006.getString("branchId")));
				customer.setHomeContact(UM_ResultSet0006.getString("homeContact"));
				customer.setMobileContact(UM_ResultSet0006.getString("mobileContact"));
				customer.setAccountNo(UM_ResultSet0006.getInt("accountNo"));
				
				//starting setting customer specific attributes
				
				//query for online_security_key table
				PreparedStatement UM_Prst0007 = null; 
				ResultSet UM_ResultSet0007 = null;
				UM_Prst0007 = con.prepareStatement(UMQueries.queryUM_04);
				UM_Prst0007.setInt(1, UM_ResultSet0006.getInt("onlineSecurityId"));
				UM_ResultSet0007 = UM_Prst0007.executeQuery();
				if(UM_ResultSet0007.next()) {
					//creating and binding online_security_key object to person
					customer.setOnlineSecurityKey(new OnlineSecurityKey(UM_ResultSet0007.getInt(1), UM_ResultSet0007.getString(2)));
				} else {
					customer = null;
					System.out.println("No online security credentials though there was details...");
				}
			} else {
				customer = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_ResultSet0006 != null)
					UM_ResultSet0006.close();
				
				if(UM_Prst0006 != null)
					UM_Prst0006.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		return customer;
	}

	private static OnlineAccount checkOnlineEmployeeCredentials(String username, String password) {
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
		
		PreparedStatement UM_Prst0002 = null;
		ResultSet UM_ResultSet0002 = null;
		String usernameDB = null;
		String passwordDB = null;
		OnlineAccount onlineAccount = null;
		
		//Checking online_employee_credentials table
		try {
			UM_Prst0002 = con.prepareStatement(UMQueries.queryUM_02);
			UM_Prst0002.setString(1, username);
			UM_Prst0002.setString(2, password);
			UM_ResultSet0002 = UM_Prst0002.executeQuery();
			
			boolean m = false;
			boolean x = false;
			while(UM_ResultSet0002.next()) {
				System.out.println("Some records found on online_employee_credentials(online_employee_credentials)");
				System.out.println("Let's see whether they are exactly matching(online_employee_credentials)");
				usernameDB = UM_ResultSet0002.getString("username");
				passwordDB = UM_ResultSet0002.getString("password");
				m = true;
				
				if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
					//online_employee_credentials found
					System.out.println("Exactly matching record found on online_employee_credentials table(online_employee_credentials)");
					//OnlineAccount object creation for customer
					System.out.println("Extracting online_customer_credentials table(online_employee_credentials)");
					
					onlineAccount = new OnlineAccount();
					onlineAccount.setOnlinePersonId(UM_ResultSet0002.getString("onlineEmployeeId"));
					onlineAccount.setPhysicalPersonId(UM_ResultSet0002.getString("employeeId"));
					onlineAccount.setUsername(UM_ResultSet0002.getString("username"));
					x = true;
					break;
				} else {
					System.out.println("No record found to be EXACTLY MATCHING(online_employee_credentials)");
				}
			}
			
			if(m == true && x == false)
				System.out.println("Though there were record, not EXACTLY mathching(online_employee_credentials)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return onlineAccount;
	}

	private static Employee checkEmployeePhysicalDetails(OnlineAccount onlineAccount, CommonEntityManager commonEntityManager) {
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
		
		Employee employee = null;
		PreparedStatement UM_Prst0003 = null;
		ResultSet UM_ResultSet0003 = null;
		
		try {
			//Joining person and employee tables and querying for specific id
			UM_Prst0003 = con.prepareStatement(UMQueries.queryUM_03);
			UM_Prst0003.setString(1, onlineAccount.getPhysicalPersonId());
			UM_ResultSet0003 = UM_Prst0003.executeQuery();
			
			//if a record exists for the retrieved online_employee_account
			if(UM_ResultSet0003.next()) {
				System.out.println("Record found on joined table for retrieved employeeId from online_employee_credentials table");
				
				employee = new Employee();
				employee.setOnlineAccount(onlineAccount);
				//starting setting common person attributes
				employee.setPersonId(UM_ResultSet0003.getString("employeeId"));
				employee.setName(UM_ResultSet0003.getString("firstName"), UM_ResultSet0003.getString("middleName"), 
						UM_ResultSet0003.getString("lastName"), UM_ResultSet0003.getString("otherNames"));
				employee.setAddress(UM_ResultSet0003.getString("addressStreet01"), UM_ResultSet0003.getString("addressStreet02"), 
						UM_ResultSet0003.getString("addressCity"), UM_ResultSet0003.getString("addressProvince"), UM_ResultSet0003.getInt("addressZipCode"));
				employee.setNic(UM_ResultSet0003.getString("nic"));
				employee.setDateOfBirth(UM_ResultSet0003.getDate("dateOfBirth"));
				employee.setPersonalEmail(UM_ResultSet0003.getString("personalEmail"));
				employee.setRegistrationDates(new RegistrationDates(UM_ResultSet0003.getDate("physicalRegistrationDate"), UM_ResultSet0003.getDate("onlineRegistrationDate")));
				employee.setGender(commonEntityManager.getGender(UM_ResultSet0003.getInt("genderId")));
				employee.setNationality(commonEntityManager.getNationality(UM_ResultSet0003.getInt("nationalityId")));
				employee.setBranch(commonEntityManager.getBranch(UM_ResultSet0003.getString("branchId")));
				employee.setHomeContact(UM_ResultSet0003.getString("homeContact"));
				employee.setMobileContact(UM_ResultSet0003.getString("mobileContact"));
				
				//starting setting employee specific attributes
				employee.setDepartment(commonEntityManager.getDepartment(UM_ResultSet0003.getString("departmentId")));
				employee.setCompanyEmail(UM_ResultSet0003.getString("companyEmail"));
				employee.setDesignation(commonEntityManager.getDesignation(UM_ResultSet0003.getInt("designationId")));
				employee.setEmployeeType(UM_ResultSet0003.getString("employeeType"));
				
				
				//query for online_security_key table
				PreparedStatement UM_Prst0004 = null; 
				ResultSet UM_ResultSet0004 = null;
				UM_Prst0004 = con.prepareStatement(UMQueries.queryUM_04);
				UM_Prst0004.setInt(1, UM_ResultSet0003.getInt("onlineSecurityId"));
				UM_ResultSet0004 = UM_Prst0004.executeQuery();
				if(UM_ResultSet0004.next()) {
					//creating and binding online_security_key object to person
					employee.setOnlineSecurityKey(new OnlineSecurityKey(UM_ResultSet0004.getInt(1), UM_ResultSet0004.getString(2)));
				} else {
					employee = null;
					System.out.println("could not find online security key.");
				}
			} else {
				employee = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
