package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

import POJO_MODEL.user_management.Person;

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
	
	public void displayEmployee() {
		System.out.println("Employee Details : ");
		System.out.println("\tEmployeeId : " + this.getPersonId());
		System.out.println("\tEmployee Name : ");
		this.getName().displayName();
		System.out.println("\tEmployee Address : ");
		this.getAddress().displayAddress();
		System.out.println("\tEmployee Birthday : " + this.getDateOfBirth());
		System.out.println("\tEmployee Personal Email : " + this.getPersonalEmail());
		System.out.println("\tEmployee Physical Registration Date : " + this.getRegistrationDates().getPhysicalRegistrationDate());
		System.out.println("\tEmployee Online Registration Date : " + this.getRegistrationDates().getOnlineRegistrationDate());
		System.out.println("\tEmployee Gender Details : ");
		this.getGender().displayGender();
		System.out.println("\tEmployee Nationality Details : ");
		this.getNationality().displayNationality();
		System.out.println("\tEmployee Branch Details : ");
		this.getBranch().displayBranch();
		System.out.println("\tEmployee Online Security Key Details : ");
		this.getOnlineSecurityKey().displayOnlineSecurityKey();
//		System.out.println("\tEmployee Permission Details : ");
//		this.getPermission().displayPermission();
		System.out.println("\tOnline Employee Account Details : ");
		this.getOnlineAccount().displayOnlineAccount();
		System.out.println("\t\t\t====Employee Specific Details=====");
		this.getDepartment().displayDepartment();
		System.out.println("\tEmployee Company Email : " + this.getCompanyEmail());
		this.getDesignation().displayDesignation();;
		System.out.println("\tEmployee Type : " + this.getEmployeeType());
		this.getDesignation().getLeaveDaysForDesignation().displayLeaveDays();
	}
}