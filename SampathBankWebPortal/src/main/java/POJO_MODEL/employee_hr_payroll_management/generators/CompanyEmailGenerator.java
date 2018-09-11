package POJO_MODEL.employee_hr_payroll_management.generators;

import POJO_MODEL.employee_hr_payroll_management.Employee;

public class CompanyEmailGenerator {
	public static String generateCompanyEmail(Employee employee) {
		String prefix01 = employee.getName().getLastName();
		String prefix02 = employee.getNic().substring(0, 2);
		String suffix = "@Company.com";
		
		return (prefix01 + prefix02 + suffix);
	}
}
