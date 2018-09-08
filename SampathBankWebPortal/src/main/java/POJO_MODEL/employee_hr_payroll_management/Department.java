package POJO_MODEL.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
	private Branch branch;
	private String departmentId;
	private String departmentName;
	
	//Back Reference
	private Collection<NormalEmployee> normalEmployeeList = new ArrayList<NormalEmployee> ();
	private Collection<Manager> managerList = new ArrayList<Manager> ();
	private Collection<Head> headList = new ArrayList<Head> ();
	private Collection<Admin> adminList = new ArrayList<Admin> ();
	
	public Department() {}
	
	public Department(Branch branch, String departmentId, String departmentName) {
		this.setBranch(branch);
		this.setDepartmentId(departmentId);
		this.setDepartmentName(departmentName);
	}
	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Department(String departmentName) {
		this.setDepartmentName(departmentName);
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
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
	
	public void displayDepartment() {
		System.out.println("============Department Details : ============");
		System.out.println(this.getBranch().getBranchId());
		System.out.println(this.getDepartmentId());
		System.out.println(this.getDepartmentName());
	}
}
