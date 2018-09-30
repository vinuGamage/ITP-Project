package DAO_SERVICE.user_management;

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
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.RegistrationDates;

public class CustomerSearchDAO {
	private static Connection con = null;
	
	public static Collection<Customer> customerSearching(String search) {
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//Conneciton Managing End
		
		CommonEntityManager CEM = CommonEntityManager.getInstance();
		PreparedStatement UM_Prst0001 = null;
		ResultSet UM_ResultSet0001 = null;
		Collection<Customer> custList = new ArrayList<Customer> ();
		Customer customer = null;
		int i = 0;
		
		try {
			UM_Prst0001 = con.prepareStatement(UMQueries.queryUM_24);
			UM_Prst0001.setString(1, "%"+search+"%");//personId
			UM_Prst0001.setString(2, "%"+search+"%");//firstName
			UM_Prst0001.setString(3, "%"+search+"%");//middleName
			UM_Prst0001.setString(4, "%"+search+"%");//lastName
			UM_Prst0001.setString(5, "%"+search+"%");//otherNames
			UM_Prst0001.setString(6, "%"+search+"%");//addressStreet01
			UM_Prst0001.setString(7, "%"+search+"%");//addressStreet02
			UM_Prst0001.setString(8, "%"+search+"%");//addressCity
			UM_Prst0001.setString(9, "%"+search+"%");//addressProvince
			UM_Prst0001.setString(10, "%"+search+"%");//addressZipCode
			UM_Prst0001.setString(11, "%"+search+"%");//nic
			UM_Prst0001.setString(12, "%"+search+"%");//personalEmail
			UM_Prst0001.setString(13, "%"+search+"%");//branchId
			UM_Prst0001.setString(14, "%"+search+"%");//homeContact
			UM_Prst0001.setString(15, "%"+search+"%");//mobileContact
			
			UM_ResultSet0001 = UM_Prst0001.executeQuery();
			
			while(UM_ResultSet0001.next()) {
				customer = new Customer();
				
				customer.setPersonId(UM_ResultSet0001.getString("personId"));
				customer.setName(UM_ResultSet0001.getString("firstName"), UM_ResultSet0001.getString("middleName"), UM_ResultSet0001.getString("lastName"), UM_ResultSet0001.getString("otherNames"));
				customer.setAddress(UM_ResultSet0001.getString("addressStreet01"), UM_ResultSet0001.getString("addressStreet02"), UM_ResultSet0001.getString("addressCity"), UM_ResultSet0001.getString("addressProvince"), UM_ResultSet0001.getInt("addressZipCode"));
				customer.setNic(UM_ResultSet0001.getString("nic"));
				customer.setDateOfBirth(UM_ResultSet0001.getDate("dateOfBirth"));
				customer.setPersonalEmail(UM_ResultSet0001.getString("personalEmail"));
				customer.setRegistrationDates(new RegistrationDates(UM_ResultSet0001.getDate("physicalRegistrationDate"), UM_ResultSet0001.getDate("onlineRegistrationDate")));
				customer.setGender(CEM.getGender(UM_ResultSet0001.getInt("genderId")));
				customer.setNationality(CEM.getNationality(UM_ResultSet0001.getInt("nationalityId")));
				customer.setBranch(CEM.getBranch(UM_ResultSet0001.getString("branchId")));
				customer.setHomeContact(UM_ResultSet0001.getString("homeContact"));
				customer.setMobileContact(UM_ResultSet0001.getString("mobileContact"));
				
				custList.add(customer);
				i++;
			}
			
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
		
		if(i == 0)
			custList = null;
		
	
		return custList;
	}
}
