package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

import POJO_MODEL.user_management.Address;
import POJO_MODEL.user_management.Name;
import POJO_MODEL.user_management.Person;
import POJO_MODEL.user_management.RegistrationDates;

//Entity
public class Employee extends Person {
	private Department department;		//Entity
	private String companyEmail; 
	private Designation designation;	//Entity
	private String employeeType;
	
	public Employee() {
		super();
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}