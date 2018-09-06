/*package pojo_model.employee_hr_payroll_management.managers;

import java.util.ArrayList;
import java.util.Collection;

import dao_service.CommonEntityAccessorDAO;
import pojo_model.employee_hr_payroll_management.Branch;
import pojo_model.employee_hr_payroll_management.Department;
import pojo_model.user_management.Gender;
import pojo_model.user_management.Nationality;
import pojo_model.user_management.Permission;
import pojo_model.user_management.Role;

public class CommonEntityManager {
	private static Collection<Gender> genderList = new ArrayList<Gender> ();
	private static Collection<Nationality> nationalityList = new ArrayList<Nationality> ();
	private static Collection<Role> roleList = new ArrayList<Role> ();
	private static Collection<Permission> permissionList = new ArrayList<Permission> ();
	private static Collection<Branch> branchList = new ArrayList<Branch> ();
	private static Collection<Department> departmentList = new ArrayList<Department> ();
	
	public CommonEntityManager() {
		CommonEntityAccessorDAO.initializeCommonPojoClasses();
		genderList = CommonEntityAccessorDAO.getGenderList();
		nationalityList = CommonEntityAccessorDAO.getNationalityList();
		roleList = CommonEntityAccessorDAO.getRoleList();
		permissionList = CommonEntityAccessorDAO.getPermissionList();
		branchList = CommonEntityAccessorDAO.getBranchList();
		departmentList = CommonEntityAccessorDAO.getDepartmentList();
		for(Nationality nationality : getNationalityList())
			System.out.println(nationality.getNationality());
	}
	
	public int getGenderId(String gender) {
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
	}
	
	public int getRoleId(String role) {
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
	}
	
	public String getBranchId(String branchCity) {
		for(Branch branchObj : branchList) {
			if(branchCity.equalsIgnoreCase(branchObj.getBranchAddress().getAddressCity()))
				return branchObj.getBranchId();
		}
		
		return null;
	}
	
	public String getDepartmentId(String department, String branchId) {
		for(Department deptObj : departmentList) {
			if(branchId.equals(deptObj.getBranchId()) && department.equalsIgnoreCase(deptObj.getDepartmentName()))
				return deptObj.getDepartmentId();
		}
		return null;
	}
	
	public Collection<Gender> getGenderList() {
		return genderList;
	}
	
	public Collection<Nationality> getNationalityList() {
		return nationalityList;
	}
	
	public Collection<Role> getRoleList() {
		return roleList;
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
}*/