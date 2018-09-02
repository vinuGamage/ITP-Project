package pojo_model.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
	private String departmentId;
	private Branch branch;
	private String departmentName;
	private Collection<Employee> employeeList = new ArrayList<Employee> ();
	private Collection<String> contactNumber = new ArrayList<String> ();

	public Department() {}
	
	public Department(String departmentId, Branch branch, String departmentName) {
		this.setDepartmentId(departmentId);
		this.setBranch(branch);
		this.setDepartmentName(departmentName);
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Department(String departmentName) {
		this.setDepartmentName(departmentName);
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
}
