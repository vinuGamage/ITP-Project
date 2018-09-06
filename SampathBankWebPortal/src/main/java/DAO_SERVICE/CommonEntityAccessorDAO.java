package dao_service;

/*
 * @author Samarasekara S.A.M.I.D.
 * @function Employee and HR Payroll Management
 * @param
 * @return
 */

// imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;
import dao_service.common_service.ConnectionPoolManager;
import pojo_model.employee_hr_payroll_management.Branch;
import pojo_model.employee_hr_payroll_management.Department;
import pojo_model.user_management.Gender;
import pojo_model.user_management.Nationality;
import pojo_model.user_management.Permission;
import pojo_model.user_management.Role;

public class CommonEntityAccessorDAO {
		static Connection con = null;
		
		private static final String EHPM_query0001_01 = "SELECT * FROM gender;";
		private static final String EHPM_query0001_02 = "SELECT genderId FROM gender WHERE gender = ?;";
		private static final String EHPM_query0002_01 = "SELECT * FROM nationality;";
		private static final String EHPM_query0002_02 = "SELECT nationalityId FROM nationality WHERE nationality = ?;";
		private static final String EHPM_query0003_01 = "SELECT * FROM role;";
		private static final String EHPM_query0003_02 = "SELECT roleId FROM role WHERE role = ?;";
		private static final String EHPM_query0004_01 = "SELECT * FROM permission;";
		private static final String EHPM_query0004_02 = "SELECT permissionLevel FROM permission WHERE permissionType = ?;";
		private static final String EHPM_query0005_01 = "SELECT * FROM branch;";
//		private static final String EHPM_query0005_02 = "SELECT * FROM branch;";
		private static final String EHPM_query0006_01 = "SELECT * FROM department;";
		
		private static Collection<Gender> genderList = new ArrayList<Gender> ();
		private static Collection<Nationality> nationalityList = new ArrayList<Nationality> ();
		private static Collection<Role> roleList = new ArrayList<Role> ();
		private static Collection<Permission> permissionList = new ArrayList<Permission> ();
		private static Collection<Branch> branchList = new ArrayList<Branch> ();
		private static Collection<Department> departmentList = new ArrayList<Department> ();
		
		public static void initializeCommonPojoClasses() {
			initializeGenders();
			initializeNationalities();
			initializeRoles();
			initializePermissions();
			initializeBranches();
			initializeDepartments();
		}
		
		private static void initializeGenders() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0001 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0001 = null;
			//Required Class Object
			Gender gender = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0001 = con.prepareStatement(EHPM_query0001_01);
				EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0001.next()) {
					i++;
					gender = new Gender(EHPM_ResultSet0001.getInt(1), EHPM_ResultSet0001.getString(2));
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
		
		private static void insertGenderList(Gender gender) {
			genderList.add(gender);
		}

		private static void initializeNationalities() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0002 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0002 = null;
			//Required Class Object
			Nationality nationality = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0002 = con.prepareStatement(EHPM_query0002_01);
				EHPM_ResultSet0002 = EHPM_Prst0002.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0002.next()) {
					i++;
					nationality = new Nationality(EHPM_ResultSet0002.getInt(1), EHPM_ResultSet0002.getString(2));
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
		
		private static void insertNationalityList(Nationality nationality) {
			nationalityList.add(nationality);
		}
		
		private static void initializeRoles() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0003 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0003 = null;
			//Required Class Object
			Role role = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0003 = con.prepareStatement(EHPM_query0003_01);
				EHPM_ResultSet0003 = EHPM_Prst0003.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0003.next()) {
					i++;
					role = new Role(EHPM_ResultSet0003.getInt(1), EHPM_ResultSet0003.getString(2), EHPM_ResultSet0003.getString(3), EHPM_ResultSet0003.getInt(4));
					System.out.println(EHPM_ResultSet0003.getInt(1) + ", " + EHPM_ResultSet0003.getString(2) + ", " + EHPM_ResultSet0003.getString(3) + ", " + EHPM_ResultSet0003.getInt(4));
					insertRoleList(role);
				}
				if(i == 0)
					roleList = null;
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
		
		private static void insertRoleList(Role role) {
			roleList.add(role);
		}
		
		private static void initializePermissions() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0004 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0004 = null;
			//Required Class Object
			Permission permission = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0004 = con.prepareStatement(EHPM_query0004_01);
				EHPM_ResultSet0004 = EHPM_Prst0004.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0004.next()) {
					i++;
					permission = new Permission(EHPM_ResultSet0004.getInt(1), EHPM_ResultSet0004.getString(2));
					System.out.println(EHPM_ResultSet0004.getInt(1) + ", " + EHPM_ResultSet0004.getString(2));
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
		
		private static void insertPermissionList(Permission permission) {
			permissionList.add(permission);
		}
		
		private static void initializeBranches() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0005 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0005 = null;
			//Required Class Object
			Branch branch = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0005 = con.prepareStatement(EHPM_query0005_01);
				EHPM_ResultSet0005 = EHPM_Prst0005.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0005.next()) {
					i++;
					branch = new Branch(EHPM_ResultSet0005.getString(1), EHPM_ResultSet0005.getString(2), EHPM_ResultSet0005.getString(3), 
							EHPM_ResultSet0005.getString(4), EHPM_ResultSet0005.getString(5), EHPM_ResultSet0005.getInt(6), 
							EHPM_ResultSet0005.getString(7));
					System.out.println(EHPM_ResultSet0005.getString(1) + ", " + EHPM_ResultSet0005.getString(4));
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
		
		private static void insertBranchList(Branch branch) {
			branchList.add(branch);
		}
		
		private static void initializeDepartments() {
			ConnectionPoolManager cpmObj = new ConnectionPoolManager();

			//Prepared Statement initializations
			PreparedStatement EHPM_Prst0006 = null;
			 //Result Set initializations
			ResultSet EHPM_ResultSet0006 = null;
			//Required Class Object
			Department department = null;
			
			try {
				DataSource dataSource = cpmObj.initializePool();
				cpmObj.printDatabaseStatus();
				
				con = dataSource.getConnection();
				cpmObj.printDatabaseStatus();
				
				EHPM_Prst0006 = con.prepareStatement(EHPM_query0006_01);
				EHPM_ResultSet0006 = EHPM_Prst0006.executeQuery();
				
				int i = 0;
				while(EHPM_ResultSet0006.next()) {
					i++;
					department = new Department(EHPM_ResultSet0006.getString(1), EHPM_ResultSet0006.getString(2), EHPM_ResultSet0006.getString(3));
					System.out.println(EHPM_ResultSet0006.getString(1) + ", " + EHPM_ResultSet0006.getString(2) + ", " + EHPM_ResultSet0006.getString(3));
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
		
		private static void insertDepartmentList(Department department) {
			departmentList.add(department);
		}
		
		public static Collection<Gender> getGenderList() {
			return genderList;
		}
		
		public static Collection<Nationality> getNationalityList() {
			return nationalityList;
		}
		
		public static Collection<Role> getRoleList() {
			return roleList;
		}
		
		public static Collection<Permission> getPermissionList() {
			return permissionList;
		}
		
		public static Collection<Branch> getBranchList() {
			return branchList;
		}
		
		public static Collection<Department> getDepartmentList() {
			return departmentList;
		}
}
