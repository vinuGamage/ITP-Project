package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

import POJO_MODEL.user_management.Address;
import POJO_MODEL.user_management.Name;
import POJO_MODEL.user_management.RegistrationDates;

public class NormalEmployee extends Employee {

	public NormalEmployee() {
		super();
	}
	
	public NormalEmployee(String personId, Name name, Address address, String nic, RegistrationDates registrationDates,
			Date dateOfBirth, String personalEmail, int contact, int registrationDatesId, int genderId,
			int nationalityId, String branchId, int onlineSecurityId, int permissionLevel, String departmentId,
			String companyEmail, int designationId, String employeeType) {
		super(personId, name, address, nic, registrationDates, dateOfBirth, personalEmail, contact, registrationDatesId,
				genderId, nationalityId, branchId, onlineSecurityId, permissionLevel, departmentId, companyEmail, designationId,
				employeeType);
	}
	
}
