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
import POJO_MODEL.employee_hr_payroll_management.UpdateRequestManagement;
import POJO_MODEL.user_management.Updation;

public class HRSalaryDAO {
	private static Connection con = null;
	
	public static boolean checkEmpSalary(String employeeId) {
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
}
