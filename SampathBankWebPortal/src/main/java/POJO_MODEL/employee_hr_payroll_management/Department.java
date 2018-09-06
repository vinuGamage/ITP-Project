package POJO_MODEL.employee_hr_payroll_management;

public class Department {
	private String branchId;
	private String departmentId;
	private String departmentName;
	
	public Department() {}
	
	public Department(String branchId, String departmentId, String departmentName) {
		this.setBranchId(branchId);
		this.setDepartmentId(departmentId);
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
