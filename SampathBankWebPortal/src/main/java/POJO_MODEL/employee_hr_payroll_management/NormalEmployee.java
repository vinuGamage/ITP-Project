package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

import POJO_MODEL.user_management.Address;
import POJO_MODEL.user_management.Name;
import POJO_MODEL.user_management.RegistrationDates;

public class NormalEmployee extends Employee {

	public NormalEmployee() {
		super();
	}

	public NormalEmployee(String personId, Name name, Address address, String nic, Date dateOfBirth,
			String personalEmail, RegistrationDates registrationDates, int genderId, int nationalityId, String branchId,
			int onlineSecurityId, int permissionLevel, String departmentId, String companyEmail, int designation,
			String employeeType) {
		super(personId, name, address, nic, dateOfBirth, personalEmail, registrationDates, genderId, nationalityId, branchId,
				onlineSecurityId, permissionLevel, departmentId, companyEmail, designation, employeeType);

	}
}
