package pojo_model.employee_hr_payroll_management.generators;

import java.nio.charset.Charset;
import java.util.Random;

import dao_service.RetrieveDAO;

public class OnlineSecurityKeyGenerator {
	public String generateOnlineSecurityKey() {
	    byte[] arr = new byte[10]; 
	    new Random().nextBytes(arr);
	    String str = new String(arr, Charset.forName("UTF-8"));
	 
	    return str;
	}
}
