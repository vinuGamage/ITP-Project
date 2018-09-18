package DAO_SERVICE.employee_hr_payroll_management.human_resource_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.UpdateRequestManagement;
import POJO_MODEL.user_management.Updation;

public class HRUpdateDetailsDAO {
	private static Connection con = null;
	private static Connection con1 = null;
	
	public static Collection<UpdateRequestManagement> getAllUpdationRequests() {
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
		Updation updation = null;
		Employee employee = null;
		UpdateRequestManagement URM = null;
		Collection<UpdateRequestManagement> list = new ArrayList<UpdateRequestManagement> ();
		boolean bool = true;
		
		int i = 0;
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0053);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			while(EHPM_ResultSet0001.next()) {
				updation = new Updation();
				updation.setPersonId(EHPM_ResultSet0001.getString("employeeId"));
				updation.setAddressStreet01(EHPM_ResultSet0001.getString("addressStreet01"));
				updation.setAddressStreet02(EHPM_ResultSet0001.getString("addressStreet02"));
				updation.setAddressCity(EHPM_ResultSet0001.getString("addressCity"));
				updation.setAddressProvince(EHPM_ResultSet0001.getString("addressProvince"));
				updation.setAddressZIP(EHPM_ResultSet0001.getInt("addressZipCode"));
				updation.setPersonalEmail(EHPM_ResultSet0001.getString("personalEmail"));
				updation.setHomeContact(EHPM_ResultSet0001.getString("homeContact"));
				updation.setMobileContact(EHPM_ResultSet0001.getString("mobileContact"));
				
				employee = getRelevantEmployee(updation.getPersonId());
				if(employee != null) {
					URM = new UpdateRequestManagement();
					URM.setUpdation(updation);
					URM.setEmployee(employee);
					
					list.add(URM);
					i++;
				} else
					bool = false;
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
		
		if(bool && i != 0)
			return list;
		else
			return null;
	}
	
	public static Employee getRelevantEmployee(String employeeId) {
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
			con1 = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		Employee employee = null;
		
		try {
			EHPM_Prst0001 = con1.prepareStatement(EHPMQueries.EHPMquery0054);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next()) {
				employee = new Employee();
				employee.setPersonId(employeeId);
				employee.setAddress(EHPM_ResultSet0001.getString("addressStreet01"), EHPM_ResultSet0001.getString("addressStreet02"), EHPM_ResultSet0001.getString("addressCity"), EHPM_ResultSet0001.getString("addressProvince"), EHPM_ResultSet0001.getInt("addressZipCode"));
				employee.setPersonalEmail(EHPM_ResultSet0001.getString("personalEmail"));
				employee.setHomeContact(EHPM_ResultSet0001.getString("homeContact"));
				employee.setMobileContact(EHPM_ResultSet0001.getString("mobileContact"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con1 != null)
					con1.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return employee;
	}

	public static boolean updateEmployeeInfo(UpdateRequestManagement URM) {
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
		int i = 0;
		boolean bool = false;
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0055);
			if(URM.getUpdation().getAddressStreet01() != null && !URM.getUpdation().getAddressStreet01().equals(URM.getEmployee().getAddress().getAddressStreet01()))
				EHPM_Prst0001.setString(1, URM.getUpdation().getAddressStreet01());
			else
				EHPM_Prst0001.setString(1, URM.getEmployee().getAddress().getAddressStreet01());
			
			if(URM.getUpdation().getAddressStreet02() != null && !URM.getUpdation().getAddressStreet02().equals(URM.getEmployee().getAddress().getAddressStreet02()))
				EHPM_Prst0001.setString(2, URM.getUpdation().getAddressStreet02());
			else
				EHPM_Prst0001.setString(2, URM.getEmployee().getAddress().getAddressStreet02());
			
			if(URM.getUpdation().getAddressCity() != null && !URM.getUpdation().getAddressCity().equals(URM.getEmployee().getAddress().getAddressCity()))
				EHPM_Prst0001.setString(3, URM.getUpdation().getAddressCity());
			else
				EHPM_Prst0001.setString(3, URM.getEmployee().getAddress().getAddressCity());
			
			if(URM.getUpdation().getAddressProvince() != null && !URM.getUpdation().getAddressProvince().equals(URM.getEmployee().getAddress().getAddressProvince()))
				EHPM_Prst0001.setString(4, URM.getUpdation().getAddressProvince());
			else
				EHPM_Prst0001.setString(4, URM.getEmployee().getAddress().getAddressProvince());
			
			if(URM.getUpdation().getAddressZIP() != 0 && URM.getUpdation().getAddressZIP() != URM.getEmployee().getAddress().getAddressZIPCode())
				EHPM_Prst0001.setInt(5, URM.getUpdation().getAddressZIP());
			else
				EHPM_Prst0001.setInt(5, URM.getEmployee().getAddress().getAddressZIPCode());

			if(URM.getUpdation().getPersonalEmail() != null && !URM.getUpdation().getPersonalEmail().equals(URM.getEmployee().getPersonalEmail()))
				EHPM_Prst0001.setString(6, URM.getUpdation().getPersonalEmail());
			else
				EHPM_Prst0001.setString(6, URM.getEmployee().getPersonalEmail());
			
			if(URM.getUpdation().getHomeContact() != null && !URM.getUpdation().getHomeContact().equals(URM.getEmployee().getHomeContact()))
				EHPM_Prst0001.setString(7, URM.getUpdation().getHomeContact());
			else
				EHPM_Prst0001.setString(7, URM.getEmployee().getHomeContact());
			
			if(URM.getUpdation().getMobileContact() != null && !URM.getUpdation().getMobileContact().equals(URM.getEmployee().getMobileContact()))
				EHPM_Prst0001.setString(8, URM.getUpdation().getMobileContact());
			else
				EHPM_Prst0001.setString(8,URM.getEmployee().getMobileContact());
			
			EHPM_Prst0001.setString(9, URM.getEmployee().getPersonId());
			
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0)
				bool = deleteFromUpdateRequest(URM.getEmployee().getPersonId());
			
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
		
		if(bool)
			return true;
		else
			return false;
	}

	public static boolean deleteFromUpdateRequest(String employeeId) {
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
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0056);
			EHPM_Prst0001.setString(1, employeeId);
			i = EHPM_Prst0001.executeUpdate();
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
		
		if(i == 0)
			return false;
		else
			return true;
	}
}