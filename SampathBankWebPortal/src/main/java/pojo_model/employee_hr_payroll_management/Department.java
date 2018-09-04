package pojo_model.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
	private String departmentId;
	private String branchId;
	private String departmentName;
	private Collection<Employee> employeeList = new ArrayList<Employee> ();
	private Collection<String> contactNumber = new ArrayList<String> ();

	public Department() {}
	
	public Department(String departmentId, String branchId, String departmentName) {
		this.setDepartmentId(departmentId);
		this.setBranchId(branchId);
		this.setDepartmentName(departmentName);
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Department(String departmentName) {
		this.setDepartmentName(departmentName);
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
}
