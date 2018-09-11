package DAO_SERVICE.employee_hr_payroll_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.SQLException;
import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import DAO_SERVICE.common_service.ConnectionPoolManager;
import POJO_MODEL.employee_hr_payroll_management.Branch;
import POJO_MODEL.employee_hr_payroll_management.Department;
import POJO_MODEL.employee_hr_payroll_management.Designation;
import POJO_MODEL.employee_hr_payroll_management.LeaveDays;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Gender;
import POJO_MODEL.user_management.Nationality;
//import POJO_MODEL.user_management.Permission;

public class CommonEntityAccessorDAO {
	private static Connection con = null;
	
	private Collection<Gender> genderList = new ArrayList<Gender> ();
	private Collection<Nationality> nationalityList = new ArrayList<Nationality> ();
//	private Collection<Permission> permissionList = new ArrayList<Permission> ();
	private Collection<Branch> branchList = new ArrayList<Branch> ();
	private Collection<Department> departmentList = new ArrayList<Department> ();
	private Collection<Designation> designationList = new ArrayList<Designation> ();
	private Collection<LeaveDays> leaveDaysList = new ArrayList<LeaveDays> ();
	
	public void initializeCommonPojoClasses() {
		System.out.println("=============COMMON ENTITY ACCESSOR DAO=============");
		initializeGenders();
		initializeNationalities();
//		initializePermissions();
		initializeBranches();
		initializeDesignations();
		initializeLeaveDays();
	}
	
	private void initializeGenders() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		Gender gender = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0011);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0001.next()) {
				i++;
				gender = new Gender(EHPM_ResultSet0001.getInt(1), EHPM_ResultSet0001.getString(2));
				System.out.println("=============ALL GENDERS=============");
				System.out.println(EHPM_ResultSet0001.getInt(1) + ", " + EHPM_ResultSet0001.getString(2));
				insertGenderList(gender);
			}
			if(i == 0)
				genderList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
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
		cpmObj.printDatabaseStatus();
	}
	
	private void insertGenderList(Gender gender) {
		genderList.add(gender);
	}
	
	public Collection<Gender> getGenderList() {
		return this.genderList;
	}
	
	private void initializeNationalities() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0002 = null;
		ResultSet EHPM_ResultSet0002 = null;
		Nationality nationality = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0002 = con.prepareStatement(EHPMQueries.EHPMquery0012);
			EHPM_ResultSet0002 = EHPM_Prst0002.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0002.next()) {
				i++;
				nationality = new Nationality(EHPM_ResultSet0002.getInt(1), EHPM_ResultSet0002.getString(2));
				System.out.println("=============ALL Nationalities=============");
				System.out.println(EHPM_ResultSet0002.getInt(1) + ", " + EHPM_ResultSet0002.getString(2));
				insertNationalityList(nationality);
			}
			if(i == 0)
				nationalityList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0002 != null)
					EHPM_ResultSet0002.close();
				
				if(EHPM_Prst0002 != null)
					EHPM_Prst0002.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertNationalityList(Nationality nationality) {
		nationalityList.add(nationality);
	}
	
	public Collection<Nationality> getNationalityList() {
		return this.nationalityList;
	}
	
/*	private void initializePermissions() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0003 = null;
		ResultSet EHPM_ResultSet0003 = null;
		Permission permission = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0003 = con.prepareStatement(EHPMQueries.EHPMquery0013);
			EHPM_ResultSet0003 = EHPM_Prst0003.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0003.next()) {
				i++;
				permission = new Permission(EHPM_ResultSet0003.getInt(1), EHPM_ResultSet0003.getString(2));
				System.out.println("=============ALL PERMISSIONS=============");
				System.out.println(EHPM_ResultSet0003.getInt(1) + ", " + EHPM_ResultSet0003.getString(2));
				insertPermissionList(permission);
			}
			if(i == 0)
				permissionList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0003 != null)
					EHPM_ResultSet0003.close();
				
				if(EHPM_Prst0003 != null)
					EHPM_Prst0003.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertPermissionList(Permission permission) {
		permissionList.add(permission);
	}
	
	public Collection<Permission> getPermissionList() {
		return this.permissionList;
	}*/
	
	private void initializeBranches() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0004 = null;
		ResultSet EHPM_ResultSet0004 = null;
		Branch branch = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0004 = con.prepareStatement(EHPMQueries.EHPMquery0014);
			EHPM_ResultSet0004 = EHPM_Prst0004.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0004.next()) {
				i++;
				branch = new Branch(EHPM_ResultSet0004.getString(1), EHPM_ResultSet0004.getString(2), EHPM_ResultSet0004.getString(3),
						EHPM_ResultSet0004.getString(4), EHPM_ResultSet0004.getString(5), EHPM_ResultSet0004.getInt(6), EHPM_ResultSet0004.getString(7));
				System.out.println("=============ALL BRANCHES=============");
				System.out.println(EHPM_ResultSet0004.getString(1) + ", " + EHPM_ResultSet0004.getString(2) + ", " + EHPM_ResultSet0004.getString(3) + ", " + 
						EHPM_ResultSet0004.getString(4) + ", " + EHPM_ResultSet0004.getString(5) + ", " + EHPM_ResultSet0004.getInt(6) + ", " + EHPM_ResultSet0004.getString(7));
				insertBranchList(branch);
			}
			if(i == 0)
				branchList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0004 != null)
					EHPM_ResultSet0004.close();
				
				if(EHPM_Prst0004 != null)
					EHPM_Prst0004.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertBranchList(Branch branch) {
		branchList.add(branch);
	}
	
	public Collection<Branch> getBranchList() {
		return this.branchList;
	}
	
	public void initializeDepartments(CommonEntityManager commonEntityManager) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0005 = null;
		ResultSet EHPM_ResultSet0005 = null;
		Department department = null;
//		String branchId_department = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0005 = con.prepareStatement(EHPMQueries.EHPMquery0015);
			EHPM_ResultSet0005 = EHPM_Prst0005.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0005.next()) {
				i++;
				
				department = new Department(commonEntityManager.getBranch(EHPM_ResultSet0005.getString("branchId")), EHPM_ResultSet0005.getString("departmentId"), 
						EHPM_ResultSet0005.getString("departmentName"));
				System.out.println("=============ALL DEPARTMENTS=============");
				System.out.println(EHPM_ResultSet0005.getString("branchId") + ", " + EHPM_ResultSet0005.getString("departmentId") + ", " + EHPM_ResultSet0005.getString("departmentName"));
				insertDepartmentList(department);
			}
			if(i == 0)
				departmentList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0005 != null)
					EHPM_ResultSet0005.close();
				
				if(EHPM_Prst0005 != null)
					EHPM_Prst0005.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertDepartmentList(Department department) {
		departmentList.add(department);
	}
	
	public Collection<Department> getDepartmentList() {
		return this.departmentList;
	}

	private void initializeDesignations() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0006 = null;
		ResultSet EHPM_ResultSet0006 = null;
		Designation designation = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0006 = con.prepareStatement(EHPMQueries.EHPMquery0016);
			EHPM_ResultSet0006 = EHPM_Prst0006.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0006.next()) {
				i++;
				designation = new Designation(EHPM_ResultSet0006.getInt("designationId"), EHPM_ResultSet0006.getString("designation"), EHPM_ResultSet0006.getInt("leaveDaysId"));
				System.out.println("=============ALL DESIGNATIONS=============");
				System.out.println(EHPM_ResultSet0006.getInt("designationId") + ", " + EHPM_ResultSet0006.getString("designation") + ", " + EHPM_ResultSet0006.getString("leaveDaysId"));
				insertDesignationList(designation);
			}
			if(i == 0)
				designationList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0006 != null)
					EHPM_ResultSet0006.close();
				
				if(EHPM_Prst0006 != null)
					EHPM_Prst0006.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertDesignationList(Designation designation) {
		designationList.add(designation);
	}
	
	public Collection<Designation> getDesignationList() {
		return this.designationList;
	}

	private void initializeLeaveDays() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();

		PreparedStatement EHPM_Prst0007 = null;
		ResultSet EHPM_ResultSet0007 = null;
		LeaveDays leaveDays = null;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPM_Prst0007 = con.prepareStatement(EHPMQueries.EHPMquery0017);
			EHPM_ResultSet0007 = EHPM_Prst0007.executeQuery();
			
			int i = 0;
			while(EHPM_ResultSet0007.next()) {
				i++;
				leaveDays = new LeaveDays(EHPM_ResultSet0007.getInt("leaveDaysId"), EHPM_ResultSet0007.getInt("noOfLeavesPerYear"));
				System.out.println("=============ALL LeaveDays=============");
				System.out.println(EHPM_ResultSet0007.getInt("leaveDaysId") + ", " + EHPM_ResultSet0007.getInt("noOfLeavesPerYear"));
				insertLeaveDaysList(leaveDays);
			}
			if(i == 0)
				leaveDaysList = null;
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0007 != null)
					EHPM_ResultSet0007.close();
				
				if(EHPM_Prst0007 != null)
					EHPM_Prst0007.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		cpmObj.printDatabaseStatus();
	}
	
	private void insertLeaveDaysList(LeaveDays leaveDays) {
		leaveDaysList.add(leaveDays);
	}
	
	public Collection<LeaveDays> getLeaveDaysList() {
		return this.leaveDaysList;
	}
}
