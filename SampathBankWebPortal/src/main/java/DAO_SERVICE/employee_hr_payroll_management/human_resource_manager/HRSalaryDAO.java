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
import POJO_MODEL.employee_hr_payroll_management.Salary;
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
		boolean bool = false;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0058);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next()) {
				bool = true;
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
		
		return bool;
	}
	
	public static boolean InsertEmpSalary(Salary salary, String employeeId) {
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
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0059);
			EHPM_Prst0001.setString(1, salary.getEmployeeId());
			EHPM_Prst0001.setDouble(2, salary.gettMonthlySalary());
			EHPM_Prst0001.setDouble(3, salary.gettOvertimeHrs());
			EHPM_Prst0001.setDouble(4, salary.gettOvertimeRate());
			EHPM_Prst0001.setDouble(5, salary.gettCarAllowance());
			EHPM_Prst0001.setDouble(6, salary.gettBonus());
			EHPM_Prst0001.setDouble(7, salary.getTax());
			EHPM_Prst0001.setDouble(8, salary.getNtSubsistenceAllowanceDays());
			EHPM_Prst0001.setDouble(9, salary.getNtSubsistenceAllowanceRate());
			EHPM_Prst0001.setDouble(10, salary.getNtMedical());
			EHPM_Prst0001.setDouble(11, salary.getdEpf());
			EHPM_Prst0001.setDouble(12, salary.getdMedical());
			EHPM_Prst0001.setDouble(13, salary.getdLoanRepayment());
			EHPM_Prst0001.setDouble(14, salary.getdOtherDeductions());
			EHPM_Prst0001.setDouble(15, salary.getTotalOT());
			EHPM_Prst0001.setDouble(16, salary.getTotalTaxableIncome());
			EHPM_Prst0001.setDouble(17, salary.getTotalNonTaxableIncome());
			EHPM_Prst0001.setDouble(18, salary.getTotalDeductions());
			EHPM_Prst0001.setDouble(19, salary.getNetSalary());
			EHPM_Prst0001.setString(20, employeeId);
			EHPM_Prst0001.setDate(21, salary.getDate());
			i = EHPM_Prst0001.executeUpdate();
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
		
		if(i == 0)
			return false;
		else
			return true;
	}
	
	public static boolean UpdateEmpSalary(Salary salary, String employeeId) {
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
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0060);
			EHPM_Prst0001.setDouble(1, salary.gettMonthlySalary());
			EHPM_Prst0001.setDouble(2, salary.gettOvertimeHrs());
			EHPM_Prst0001.setDouble(3, salary.gettOvertimeRate());
			EHPM_Prst0001.setDouble(4, salary.gettCarAllowance());
			EHPM_Prst0001.setDouble(5, salary.gettBonus());
			EHPM_Prst0001.setDouble(6, salary.getTax());
			EHPM_Prst0001.setDouble(7, salary.getNtSubsistenceAllowanceDays());
			EHPM_Prst0001.setDouble(8, salary.getNtSubsistenceAllowanceRate());
			EHPM_Prst0001.setDouble(9, salary.getNtMedical());
			EHPM_Prst0001.setDouble(10, salary.getdEpf());
			EHPM_Prst0001.setDouble(11, salary.getdMedical());
			EHPM_Prst0001.setDouble(12, salary.getdLoanRepayment());
			EHPM_Prst0001.setDouble(13, salary.getdOtherDeductions());
			EHPM_Prst0001.setDouble(14, salary.getTotalOT());
			EHPM_Prst0001.setDouble(15, salary.getTotalTaxableIncome());
			EHPM_Prst0001.setDouble(16, salary.getTotalNonTaxableIncome());
			EHPM_Prst0001.setDouble(17, salary.getTotalDeductions());
			EHPM_Prst0001.setDouble(18, salary.getNetSalary());
			EHPM_Prst0001.setString(19, employeeId);
			EHPM_Prst0001.setDate(20, salary.getDate());
			EHPM_Prst0001.setString(21, salary.getEmployeeId());
			
			i = EHPM_Prst0001.executeUpdate();
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
		
		if(i == 0)
			return false;
		else
			return true;
	}
}
