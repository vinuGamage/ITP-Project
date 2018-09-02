package pojo_model.employee_hr_payroll_management;

public class Department {
	private Branch branch;
	private String departmentName;

	public Department() {}
	
	public Department(Branch branch, String departmentName) {
		this.setBranch(branch);
		this.setDepartmentName(departmentName);
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
	
	public Branch getBranch() {
		return branch;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
}
