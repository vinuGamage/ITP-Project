package POJO_MODEL.employee_hr_payroll_management.managers;

import java.util.ArrayList;
import java.util.Collection;

import DAO_SERVICE.employee_hr_payroll_management.CommonEntityAccessorDAO;
import POJO_MODEL.employee_hr_payroll_management.Branch;
import POJO_MODEL.employee_hr_payroll_management.Department;
import POJO_MODEL.employee_hr_payroll_management.Designation;
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
	
	private CommonEntityManager() {
		CommonEntityAccessorDAO CEA = new CommonEntityAccessorDAO();
		CEA.initializeCommonPojoClasses(this);
		genderList = CEA.getGenderList();
		nationalityList = CEA.getNationalityList();
		permissionList = CEA.getPermissionList();
		branchList = CEA.getBranchList();
		
		if(branchList != null)
			departmentList = CEA.getDepartmentList();
		
		designationList = CEA.getDesignationList();
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
	
	public Branch getBranch(String branchId) {
		Branch branch1 = null;
		for(Branch branch2: branchList) {
			if(branch2.getBranchId().equals(branchId))
				branch1 = branch2;
		}
		
		return branch1;
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