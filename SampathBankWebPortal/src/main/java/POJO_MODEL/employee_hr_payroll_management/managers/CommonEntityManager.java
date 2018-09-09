package POJO_MODEL.employee_hr_payroll_management.managers;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Collection;

import DAO_SERVICE.employee_hr_payroll_management.CommonEntityAccessorDAO;
import POJO_MODEL.employee_hr_payroll_management.Branch;
import POJO_MODEL.employee_hr_payroll_management.Department;
import POJO_MODEL.employee_hr_payroll_management.Designation;
import POJO_MODEL.employee_hr_payroll_management.LeaveDays;
import POJO_MODEL.user_management.Gender;
import POJO_MODEL.user_management.Nationality;
import POJO_MODEL.user_management.Permission;

public class CommonEntityManager {
	private static CommonEntityManager commonEntityManager;
	private static Collection<Gender> genderList = new ArrayList<Gender> ();
	private static Collection<Nationality> nationalityList = new ArrayList<Nationality> ();
	private static Collection<Permission> permissionList = new ArrayList<Permission> ();
	private static Collection<Branch> branchList = new ArrayList<Branch> ();
	private static Collection<Department> departmentList = new ArrayList<Department> ();
	private static Collection<Designation> designationList = new ArrayList<Designation> ();
	private static Collection<LeaveDays> leaveDaysList = new ArrayList<LeaveDays>();
	
	private CommonEntityManager() {
		CommonEntityAccessorDAO CEA = new CommonEntityAccessorDAO();
		CEA.initializeCommonPojoClasses();
		genderList = CEA.getGenderList();
		nationalityList = CEA.getNationalityList();
		permissionList = CEA.getPermissionList();
		branchList = CEA.getBranchList();
		designationList = CEA.getDesignationList();
		leaveDaysList = CEA.getLeaveDaysList();
	}
	
	public void initializeDepartments() {
		CommonEntityAccessorDAO CEA = new CommonEntityAccessorDAO();
		CEA.initializeDepartments(this);
		departmentList = CEA.getDepartmentList();
	}
	
	public static CommonEntityManager getInstance() {
		if(commonEntityManager == null)
			commonEntityManager = new CommonEntityManager();
		
		return commonEntityManager;
	}
	
/*	public int getGenderId(String gender) {
		for(Gender genderObj : genderList) {
			if(gender.equalsIgnoreCase(genderObj.getGender()))
				return genderObj.getGenderId();
		}
		return 0;
	}
	
	public int getNationalityId(String nationality) {
		for(Nationality nationalityObj : nationalityList) {
			if(nationality.equalsIgnoreCase(nationalityObj.getNationality()))
				return nationalityObj.getNationalityId();
		}
		
		return 0;
	}*/
	
/*	public int getRoleId(String role) {
		for(Role roleObj : roleList) {
			if(role.equalsIgnoreCase(roleObj.getRole()))
				return roleObj.getRoleId();
		}
		
		return 0;
	}
	
	public String getRoleGroup(String role) {
		for(Role roleObj : roleList) {
			if(role.equalsIgnoreCase(roleObj.getRole()))
				return roleObj.getRoleGroup();
		}
		
		return null;
	}*/
	
/*	public String getBranchId(String branchCity) {
		for(Branch branchObj : branchList) {
			if(branchCity.equalsIgnoreCase(branchObj.getBranchAddress().getAddressCity()))
				return branchObj.getBranchId();
		}
		
		return null;
	}*/
	
/*	public String getDepartmentId(String department, String branchId) {
		for(Department deptObj : departmentList) {
			if(branchId.equals(deptObj.getBranchId()) && department.equalsIgnoreCase(deptObj.getDepartmentName()))
				return deptObj.getDepartmentId();
		}
		return null;
	}*/
	
	public Gender getGender(int genderId) {
		Gender gender = null;
		for(Gender gen: genderList) {
			if(gen.getGenderId() == genderId)
				gender = gen;
		}
		
		return gender;
	}
	
	public Nationality getNationality(int nationalityId) {
		Nationality nationality = null;
		for(Nationality nat: nationalityList) {
			if(nat.getNationalityId() == nationalityId)
				nationality = nat;
		}
		
		return nationality;
	}
	
	public Branch getBranch(String branchId) {
		Branch branch = null;
		for(Branch bran: branchList) {
			if(bran.getBranchId().equals(branchId))
				branch = bran;
		}
		
		return branch;
	}
	
	public Permission getPermission(int permissionId) {
		Permission permission = null;
		for(Permission per: permissionList) {
			if(per.getPermissionLevel() == permissionId)
				permission = per;
		}
		
		return permission;
	}
	
	public Department getDepartment(String departmentId) {
		Department department = null;
		for(Department dept: departmentList) {
			if(dept.getDepartmentId().equals(departmentId))
				department = dept;
		}
		return department;
	}
	
	public Designation getDesignation(int designationId) {
		Designation designation = null;
		for(Designation desig: designationList) {
			if(desig.getDesignationId() == designationId)
				designation = desig;
		}
		return designation;
	}
	
	public LeaveDays getLeaveDays(int leaveDaysId) {
		LeaveDays leaveDays = null;
		for(LeaveDays leave: leaveDaysList) {
			if(leave.getLeaveDaysId() == leaveDaysId)
				leaveDays = leave;
		}
		return leaveDays;
	}
	
	public Collection<Gender> getGenderList() {
		return genderList;
	}
	
	public Collection<Nationality> getNationalityList() {
		return nationalityList;
	}
	
	public Collection<Permission> getPermissionList() {
		return permissionList;
	}
	
	public Collection<Branch> getBranchList() {
		return branchList;
	}
	
	public Collection<Department> getDepartmentList() {
		return departmentList;
	}
	
	public Collection<Designation> getDesignationtList() {
		return designationList;
	}
}