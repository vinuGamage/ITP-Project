package pojo_model.employee_hr_payroll_management;

import pojo_model.employee_hr_payroll_management.managers.CommonEntityManager;
import pojo_model.user_management.Person;

//Entity
public class Employee extends Person {
	private Branch branch; //Entity
	private Department department; //Entity
	private String designation;
	private String companyEmail; //Auto Generated
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String middleName, String lastName, String otherNames, String addStreet01, 
			String addStreet02, String addCity, String addProvince, int zipCode, String personalEmail, String contactNumberHome, 
			String contactNumberMobile, String gender, String nic, String nationality, String dateOfBirth, String role, String branch, 
			String department, String designation) {
		super(firstName, middleName, lastName, otherNames, addStreet01, addStreet02, addCity, addProvince, zipCode, personalEmail, 
				contactNumberHome, contactNumberMobile, gender, nic, nationality, dateOfBirth, role);
		this.setBranch(branch);
		this.setDepartment(department);
		this.setDesignation(designation);
	}

	public void setBranch(String branch) {
		this.branch = new CommonEntityManager().getBranch(branch);
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void setDepartment(String department) {
		this.department = new CommonEntityManager().getDepartment(department);
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	public Branch getBranch() {
		return branch;
	}

	public Department getDepartment() {
		return department;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
}
