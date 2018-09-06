package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

import POJO_MODEL.user_management.Address;
import POJO_MODEL.user_management.Name;
import POJO_MODEL.user_management.Person;
import POJO_MODEL.user_management.RegistrationDates;

//Entity
public abstract class Employee extends Person {
	private String departmentId;	//Entity
	private String companyEmail; 
	private int designationId;		//Entity
	private String employeeType;
	
	public Employee() {
		super();
	}
	
	public Employee(String personId, Name name, Address address, String nic, RegistrationDates registrationDates,
			Date dateOfBirth, String personalEmail, int contact, int registrationDatesId, int genderId,
			int nationalityId, String branchId, int onlineSecurityId, int permissionLevel, String departmentId, 
			String companyEmail,int designationId, String employeeType) {
		super(personId, name, address, nic, registrationDates, dateOfBirth, personalEmail, contact, registrationDatesId,
				genderId, nationalityId, branchId, onlineSecurityId, permissionLevel);
		
		this.setDepartmentId(departmentId);
		this.setCompanyEmail(companyEmail);
		this.setDesignationId(designationId);
		this.setEmployeeType(employeeType);
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}
