package pojo_model.employee_hr_payroll_management;

import java.sql.Date;

import pojo_model.employee_hr_payroll_management.converters.DateConverter;
import pojo_model.employee_hr_payroll_management.managers.CommonEntityManager;
import pojo_model.user_management.Address;
import pojo_model.user_management.Contact;
import pojo_model.user_management.Name;
import pojo_model.user_management.Person;

//Entity
public class Employee extends Person {
	private String departmentId; //Entity
	private String designation;
	private String companyEmail; //Auto
	private String type;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String middleName, String lastName, String otherNames, String addressStreet01,
			String addressStreet02, String addressCity, String addressProvince, String addressZipCode, String physicalRegistrationDate,
			String personalEmail, String gender, String nic, String nationality, String dateOfBirth,
			String branchCity, String role, String homeContact, String mobileContact, String department, String designation,
			CommonEntityManager cem) {
		super();
		super.setName(new Name(firstName, middleName, lastName, otherNames));
		super.setAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, Integer.parseInt(addressZipCode)));
		super.setRegistrationDates(DateConverter.getSqlDate(physicalRegistrationDate), DateConverter.getSqlCurrentTime());
		super.setPersonalEmail(personalEmail);
		super.setGenderId(cem.getGenderId(gender));
		super.setNic(nic);
		super.setNationalityId(cem.getNationalityId(nationality));
		super.setDateOfBirth(DateConverter.getSqlDate(dateOfBirth));
		super.setBranchId(cem.getBranchId(branchCity));
		super.setRoleId(cem.getRoleId(role));
		super.setContact(new Contact(homeContact, mobileContact));
		this.setDepartmentId(cem.getDepartmentId(department, super.getBranchId()));
		this.setDesignation(designation);
		this.setType(cem.getRoleGroup(role));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
}
