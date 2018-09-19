package DAO_SERVICE.user_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.OnlineSecurityKey;
import POJO_MODEL.user_management.RegistrationDates;
import POJO_MODEL.user_management.SecurityVariables;

public class CustomerRegistrationManagementDAO {
	private static Connection con = null;
	
	public static Collection<Customer> getAllRequests() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		CommonEntityManager cem = CommonEntityManager.getInstance();
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		Customer customer = null;
		int i = 0;
		Collection<Customer> requestList = new ArrayList<Customer> ();
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_16);
			UM_RS = UM_Pr.executeQuery();
			
			while(UM_RS.next()) {
				customer = new Customer();
				
				customer.setPersonId(UM_RS.getString("personId"));
				customer.setName(UM_RS.getString("firstName"), UM_RS.getString("middleName"), UM_RS.getString("lastName"), UM_RS.getString("otherNames"));
				customer.setAddress(UM_RS.getString("addressStreet01"), UM_RS.getString("addressStreet02"), UM_RS.getString("addressCity"), UM_RS.getString("addressProvince"), UM_RS.getInt("addressZipCode"));
				customer.setNic(UM_RS.getString("nic"));
				customer.setDateOfBirth(UM_RS.getDate("dateOfBirth"));
				customer.setPersonalEmail(UM_RS.getString("personalEmail"));
				customer.setRegistrationDates(new RegistrationDates(UM_RS.getDate("physicalRegistrationDate")));
				customer.setGender(cem.getGender(UM_RS.getInt("genderId")));
				customer.setNationality(cem.getNationality(UM_RS.getInt("nationalityId")));
				customer.setBranch(cem.getBranch(UM_RS.getString("branchId")));
				customer.setHomeContact(UM_RS.getString("homeContact"));
				customer.setMobileContact(UM_RS.getString("mobileContact"));
				i++;
				
				requestList.add(customer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(i == 0)
			return null;
		else
			return requestList;
	}
	
	public static boolean insertIntoOnlineSecurityKeyTable(Customer cust) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		String key = null;
		int q = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_19);
			UM_Pr.setInt(1, cust.getOnlineSecurityKey().getOnlineSecurityId());
			UM_Pr.setString(2, cust.getOnlineSecurityKey().getOnlineSecurityKey());
			q = UM_Pr.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(q == 0)
			return false;
		else
			return true;
	}

	public static String getOnlineCustomerCredentialsPrimaryKey() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		String key = null;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_17);
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				key = UM_RS.getString("nextOnlineCustomerId");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return key;
	}
	
	public static boolean updateOnlineCustomerCredentialsPrimaryKey(String Key) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		String key = null;
		int q = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_18);
			UM_Pr.setString(1, Key);
			q = UM_Pr.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(q == 0)
			return false;
		else
			return true;
	}

	public static SecurityVariables getSecurityVariables(Customer cust) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		SecurityVariables sv = null;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_20);
			UM_Pr.setString(1, cust.getPersonId());
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				sv = new SecurityVariables();
				sv.setQuestion01(UM_RS.getString("question01"));
				sv.setAnswer01(UM_RS.getString("answer01"));
				sv.setQuestion02(UM_RS.getString("question02"));
				sv.setAnswer02(UM_RS.getString("answer02"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return sv;
	}

	public static boolean insertIntoOnlineCustomerCredentials(String onlineCustomerId, Customer cust, String username, String password, SecurityVariables sv) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		String key = null;
		int q = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_21);
			UM_Pr.setString(1, onlineCustomerId);
			UM_Pr.setString(2, cust.getPersonId());
			UM_Pr.setString(3, username);
			UM_Pr.setString(4, password);
			UM_Pr.setString(5, sv.getQuestion01());
			UM_Pr.setString(6, sv.getAnswer01());
			UM_Pr.setString(7, sv.getQuestion02());
			UM_Pr.setString(8, sv.getAnswer02());
			q = UM_Pr.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(q == 0)
			return false;
		else
			return true;
	}

	public static boolean updateCustomerOnPersonTable(Customer cust) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int q = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_22);
			UM_Pr.setDate(1, DateConverter.getCurrentSqlDate());
			UM_Pr.setInt(2, cust.getOnlineSecurityKey().getOnlineSecurityId());
			UM_Pr.setString(3, cust.getPersonId());
			q = UM_Pr.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(q == 0)
			return false;
		else
			return true;
	}

	public static boolean deleteFromCustomerRegistrationRequests(Customer cust) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int q = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_23);
			UM_Pr.setString(1, cust.getPersonId());
			q = UM_Pr.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(q == 0)
			return false;
		else
			return true;
	}
}