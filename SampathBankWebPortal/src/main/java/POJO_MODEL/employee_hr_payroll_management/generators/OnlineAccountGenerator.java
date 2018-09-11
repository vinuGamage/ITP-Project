package POJO_MODEL.employee_hr_payroll_management.generators;

import java.nio.charset.Charset;
import java.util.Random;

import DAO_SERVICE.employee_hr_payroll_management.PrimaryKeyGeneratorDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.user_management.OnlineAccount;

public class OnlineAccountGenerator {
	public static OnlineAccount getOnlineAccount(Employee employee) {
		OnlineAccount onlineAcc = new OnlineAccount();
		onlineAcc.setPhysicalPersonId(employee.getPersonId());
		onlineAcc.setOnlinePersonId(PrimaryKeyGeneratorDAO.onlineEmployeePrimaryKeyGenerator());
		onlineAcc.setPassword(passwordGenerator());
		onlineAcc.setUsername(usernameGenerator(employee));
		
		return onlineAcc;
	}
	
	public static String passwordGenerator() {
		byte[] arr = new byte[7];
		new Random().nextBytes(arr);
		String str = new String(arr, Charset.forName("UTF-8"));
		
		return str;
	}
	
	public static String usernameGenerator(Employee employee) {
		return employee.getName().getFirstName().toUpperCase();
	}
}
