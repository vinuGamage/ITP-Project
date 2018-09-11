package POJO_MODEL.employee_hr_payroll_management.generators;

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
	    char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
	            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
	            'w', 'x', 'y', 'z' };
	        
	        char[] c=new char[10];
	        Random random=new Random();
	        for (int i = 0; i < 10; i++) {
	          c[i]=ch[random.nextInt(ch.length)];
	        }
	        
	        return new String(c);
	}
	
	public static String usernameGenerator(Employee employee) {
		return employee.getName().getFirstName().toUpperCase();
	}
}
