package POJO_MODEL.user_management;

import java.util.ArrayList;
import java.util.Collection;

import POJO_MODEL.employee_hr_payroll_management.Admin;
import POJO_MODEL.employee_hr_payroll_management.Head;
import POJO_MODEL.employee_hr_payroll_management.Manager;
import POJO_MODEL.employee_hr_payroll_management.NormalEmployee;

public class Permission {
	private int permissionLevel;
	private String permissionType;
	
	//Back Reference
	private Collection<NormalEmployee> normalEmployeeList = new ArrayList<NormalEmployee> ();
	private Collection<Manager> managerList = new ArrayList<Manager> ();
	private Collection<Head> headList = new ArrayList<Head> ();
	private Collection<Admin> adminList = new ArrayList<Admin> ();
	
	public Permission() {}
	
	public Permission(int permissionLevel, String permissionType) {
		this.setPermissionLevel(permissionLevel);
		this.setPermissionType(permissionType);
	}
	
	public Permission(String permissionType) {
		this.setPermissionType(permissionType);
	}

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public int getPermissionLevel() {
		return this.permissionLevel;
	}

	public String getPermissionType() {
		return this.permissionType;
	}

	public Collection<NormalEmployee> getNormalEmployeeList() {
		return normalEmployeeList;
	}

	public void setNormalEmployeeList(Collection<NormalEmployee> normalEmployeeList) {
		this.normalEmployeeList = normalEmployeeList;
	}

	public Collection<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(Collection<Manager> managerList) {
		this.managerList = managerList;
	}

	public Collection<Head> getHeadList() {
		return headList;
	}

	public void setHeadList(Collection<Head> headList) {
		this.headList = headList;
	}

	public Collection<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(Collection<Admin> adminList) {
		this.adminList = adminList;
	}
}
