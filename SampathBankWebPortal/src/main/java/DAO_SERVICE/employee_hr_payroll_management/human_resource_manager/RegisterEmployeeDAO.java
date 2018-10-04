package DAO_SERVICE.employee_hr_payroll_management.human_resource_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.employee_hr_payroll_management.PrimaryKeyGeneratorDAO;
import DAO_SERVICE.queries.EHPMQueries;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.employee_hr_payroll_management.generators.CompanyEmailGenerator;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;

public class RegisterEmployeeDAO {
	private static Connection con = null;
	
	public static boolean regitserEmployee(Employee employee) {
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
		PreparedStatement EHPM_Prst0002 = null;
		PreparedStatement EHPM_Prst0003 = null;
		PreparedStatement EHPM_Prst0004 = null;
		String companyEmail = null;
		int i = 0;
		String id = null;
		int j = 0;
		int k = 0;

		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0024);
			EHPM_Prst0001.setString(2, employee.getName().getFirstName());
			EHPM_Prst0001.setString(3, employee.getName().getMiddleName());
			EHPM_Prst0001.setString(4, employee.getName().getLastName());
			EHPM_Prst0001.setString(5, employee.getName().getOtherNames());
			EHPM_Prst0001.setString(6, employee.getAddress().getAddressStreet01());
			EHPM_Prst0001.setString(7, employee.getAddress().getAddressStreet02());
			EHPM_Prst0001.setString(8, employee.getAddress().getAddressCity());
			EHPM_Prst0001.setString(9, employee.getAddress().getAddressProvince());
			EHPM_Prst0001.setInt(10, employee.getAddress().getAddressZIPCode());
			EHPM_Prst0001.setString(11, employee.getNic());
			EHPM_Prst0001.setDate(12, employee.getDateOfBirth());
			EHPM_Prst0001.setString(13, employee.getPersonalEmail());
			EHPM_Prst0001.setDate(14, employee.getRegistrationDates().getPhysicalRegistrationDate());
			EHPM_Prst0001.setInt(15, employee.getGender().getGenderId());
			EHPM_Prst0001.setInt(16, employee.getNationality().getNationalityId());
			EHPM_Prst0001.setString(17, employee.getBranch().getBranchId());
			EHPM_Prst0001.setString(18, employee.getHomeContact());
			EHPM_Prst0001.setString(19, employee.getMobileContact());
			id = PrimaryKeyGeneratorDAO.EmployeePrimaryKeyGenerator();
			EHPM_Prst0001.setString(1, id);
			i = EHPM_Prst0001.executeUpdate();
			
			if(i != 0) {
				EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0025);
				EHPM_Prst0002.setString(1, id);
				EHPM_Prst0002.setString(2, employee.getDepartment().getDepartmentId());
				companyEmail = CompanyEmailGenerator.generateCompanyEmail(employee);
				EHPM_Prst0002.setString(3, companyEmail);
				EHPM_Prst0002.setInt(4, employee.getDesignation().getDesignationId());
				EHPM_Prst0002.setString(5, employee.getEmployeeType());
				j = EHPM_Prst0002.executeUpdate();
				
				if(j != 0) {
					EHPM_Prst0004 = con.prepareStatement(EHPMQueries.EHPMquery0027);
					CommonEntityManager CEM = CommonEntityManager.getInstance();
					EHPM_Prst0004.setString(1, id);
					EHPM_Prst0004.setInt(2, CEM.getLeaveDays(employee.getDesignation().getLeaveDaysId()).getNoOfLeavesPerYear());
					EHPM_Prst0004.setDate(3, DateConverter.getCurrentSqlDate());
					k = EHPM_Prst0004.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(EHPM_Prst0002 != null)
					EHPM_Prst0002.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
		
		if(k == 0)
			return false;
		else {
			String subject = "Recruitment of New Employee: " + employee.getName().getFullName();
			String content = "As the Human Resource Manager of Sampath Bank, I welcome you to our company.\n"
					+ "\tYour Name: " + employee.getName().getFullName() + ".\n"
					+ "\tEmployee ID: " + id + ".\n"
					+ "\tCompany Email: " + companyEmail + ".\n\n"
					+ "If you do not receive your online account credentials within two days of receiving this email, please contact me.";
			EmailClient.sendMail(employee.getPersonalEmail(), subject, content);
			return true;
		}
	}
}
