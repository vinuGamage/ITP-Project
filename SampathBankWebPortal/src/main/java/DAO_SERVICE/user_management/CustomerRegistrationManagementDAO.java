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
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.RegistrationDates;

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
}