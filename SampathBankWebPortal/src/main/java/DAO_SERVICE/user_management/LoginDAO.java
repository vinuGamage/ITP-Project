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
import POJO_MODEL.user_management.Contact;
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
		
		PreparedStatement UM_Prst0001 = null;
		ResultSet UM_ResultSet0001 = null;
		String usernameDB = null;
		String passwordDB = null;
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			//Checking online_customer_credentials table
			UM_Prst0001 = con.prepareStatement(UMQueries.queryUM_01);
			UM_Prst0001.setString(1, username);
			UM_Prst0001.setString(2, password);
			UM_ResultSet0001 = UM_Prst0001.executeQuery();
			
			boolean x = false;
			while(UM_ResultSet0001.next()) {
				System.out.println("Some records found on online_customer_credentials");
				System.out.println("Let's see whether they are exactly matching.");
				usernameDB = UM_ResultSet0001.getString("username");
				passwordDB = UM_ResultSet0001.getString("password");
				
				if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
					//online_customer_credentials found
					System.out.println("Exactly matching record found on online_customer_credentials table");
					x = true;
					
					//OnlineAccount object creation for customer
					System.out.println("Extracting online_customer_credentials table");
					OnlineAccount onlineAccount = new OnlineAccount();
					onlineAccount.setOnlinePersonId(UM_ResultSet0001.getString(1));
					onlineAccount.setPhysicalPersonId(UM_ResultSet0001.getString(2));
					onlineAccount.setUsername(UM_ResultSet0001.getString(3));
					
					PreparedStatement UM_Prst0006 = null;
					ResultSet UM_ResultSet0006 = null;
					
					//Joining person and customer tables and querying for specific id 
					UM_Prst0006 = con.prepareStatement(UMQueries.queryUM_06);
					UM_Prst0006.setString(1, onlineAccount.getPhysicalPersonId());
					UM_ResultSet0006 = UM_Prst0006.executeQuery();
					
					PreparedStatement UM_Prst0007 = null; 
					ResultSet UM_ResultSet0007 = null;
					//query for online_security_key table
					UM_Prst0007 = con.prepareStatement(UMQueries.queryUM_04);
					
					//if a record exists for the retrieved online_customer_account
					if(UM_ResultSet0006.next()) {
						System.out.println("Record found on joined table for retrieved customerId from online_customer_credentials table");
						UM_Prst0007.setInt(1, UM_ResultSet0006.getInt("onlineSecurityId"));
						//Retrieving from online_security_credentials
						UM_ResultSet0007 = UM_Prst0007.executeQuery();
						if(UM_ResultSet0007.next()) {
							Customer customer = new Customer();
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
							//creating and binding online_security_key object to person
							customer.setOnlineSecurityKey(new OnlineSecurityKey(UM_ResultSet0007.getInt(1), UM_ResultSet0007.getString(2)));
							customer.setPermission(commonEntityManager.getPermission(UM_ResultSet0006.getInt("permissionLevel")));
							PreparedStatement UM_Prst0008 = null; 
							ResultSet UM_ResultSet0008 = null;
							//query for contact table
							UM_Prst0008 = con.prepareStatement(UMQueries.queryUM_05);
							UM_Prst0008.setString(1, customer.getPersonId());
							UM_ResultSet0008 = UM_Prst0008.executeQuery();
							while(UM_ResultSet0008.next()) {
								customer.getContactList().add(new Contact(customer.getPersonId(), UM_ResultSet0008.getString("contactNumber"), UM_ResultSet0008.getString("type")));
							}
							//starting setting customer specific attributes
							
						genericLogin.setFound(true);
						genericLogin.setType("customer");
						genericLogin.setCustomer(customer);
						} else {
							
						}
					}
					else {
						genericLogin.setFound(false);
					}
					break;
				}
			}
			//online customer not found if x == false
			if(!x) {
				PreparedStatement UM_Prst0002 = null;
				ResultSet UM_ResultSet0002 = null;
				//checking online_employee_credentials
				UM_Prst0002 = con.prepareStatement(UMQueries.queryUM_02);
				UM_Prst0002.setString(1, username);
				UM_Prst0002.setString(2, password);
				UM_ResultSet0002 = UM_Prst0002.executeQuery();
				
				boolean y = false;
				while(UM_ResultSet0002.next()) {
					if(Validator.validateLoginCredentials(username, password, usernameDB, passwordDB)) {
						//online_employee_credentials found
						y = true;
						
						//OnlineAccount object creation
						OnlineAccount onlineAccount = new OnlineAccount();
						onlineAccount.setOnlinePersonId(UM_ResultSet0002.getString(1));
						onlineAccount.setPhysicalPersonId(UM_ResultSet0002.getString(2));
						onlineAccount.setUsername(UM_ResultSet0002.getString(3));
						
						PreparedStatement UM_Prst0003 = null;
						ResultSet UM_ResultSet0003 = null;
						
						//Joining person and employee tables and querying for specific id 
						UM_Prst0003 = con.prepareStatement(UMQueries.queryUM_03);
						UM_Prst0003.setString(1, onlineAccount.getPhysicalPersonId());
						UM_ResultSet0003 = UM_Prst0003.executeQuery();
						
						PreparedStatement UM_Prst0004 = null; 
						ResultSet UM_ResultSet0004 = null;
						//query for online_security_key table
						UM_Prst0004 = con.prepareStatement(UMQueries.queryUM_04);
						
						//if a record exists for the retrieved online_employee_account
						if(UM_ResultSet0003.next()) {
							String employeeType = UM_ResultSet0003.getString("employeeType");
							UM_Prst0004.setInt(1, UM_ResultSet0003.getInt("onlineSecurityId"));
							//Retrieving from online_security_credentials
							UM_ResultSet0004 = UM_Prst0004.executeQuery();
							
								Employee employee = new NormalEmployee();
								employee.setOnlineAccount(onlineAccount);
								//starting setting common person attributes
								employee.setPersonId(UM_ResultSet0003.getString("employeeId"));
								employee.setName(UM_ResultSet0003.getString("firstName"), UM_ResultSet0003.getString("middleName"), 
										UM_ResultSet0003.getString("lastName"), UM_ResultSet0003.getString("otherNames"));
								employee.setAddress(UM_ResultSet0003.getString("addressStreet01"), UM_ResultSet0003.getString("addressStreet02"), 
										UM_ResultSet0003.getString("addressCity"), UM_ResultSet0003.getString("addressProvince"), UM_ResultSet0003.getInt("addressZipCode"));
								employee.setNic(UM_ResultSet0003.getString("nic"));
								employee.setDateOfBirth(UM_ResultSet0003.getDate("dateOfBirth"));
								employee.setPersonalEmail(UM_ResultSet0003.getString("personlaEmail"));
								employee.setRegistrationDates(new RegistrationDates(UM_ResultSet0003.getDate("physicalRegistrationDate"), UM_ResultSet0003.getDate("onlineRegistrationDate")));
								employee.setGender(commonEntityManager.getGender(UM_ResultSet0003.getInt("genderId")));
								employee.setNationality(commonEntityManager.getNationality(UM_ResultSet0003.getInt("nationalityId")));
								employee.setBranch(commonEntityManager.getBranch(UM_ResultSet0003.getString(UM_ResultSet0003.getString("branchId"))));
								//creating and binding online_security_key object to person
								employee.setOnlineSecurityKey(new OnlineSecurityKey(UM_ResultSet0004.getInt(1), UM_ResultSet0004.getString(2)));
								employee.setPermission(commonEntityManager.getPermission(UM_ResultSet0003.getInt("permissionLevel")));
								PreparedStatement UM_Prst0005 = null; 
								ResultSet UM_ResultSet0005 = null;
								//query for contact table
								UM_Prst0005 = con.prepareStatement(UMQueries.queryUM_05);
								UM_Prst0005.setString(1, employee.getPersonId());
								UM_ResultSet0005 = UM_Prst0005.executeQuery();
								while(UM_ResultSet0005.next()) {
									employee.getContactList().add(new Contact(employee.getPersonId(), UM_ResultSet0005.getString("contactNumber"), UM_ResultSet0005.getString("type")));
								}
								//starting setting employee specific attributes
								employee.setDepartment(commonEntityManager.getDepartment(UM_ResultSet0003.getString("departmentId")));
								employee.setCompanyEmail(UM_ResultSet0003.getString("companyEmail"));
								employee.setDesignation(commonEntityManager.getDesignation(UM_ResultSet0003.getInt("designationId")));
								employee.setEmployeeType(employeeType);
								
								genericLogin.setFound(true);
								genericLogin.setType("employee");
								genericLogin.setEmployee(employee);
						}
						else {
							genericLogin.setFound(false);
						}
						break;
					}
				}
				//no matching credentials tuple found for either types
				if(!y) {
					
				}
			}
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/*if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();*/
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		
		return genericLogin;
	}
}
