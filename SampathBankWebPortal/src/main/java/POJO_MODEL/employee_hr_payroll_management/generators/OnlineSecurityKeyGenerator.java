package POJO_MODEL.employee_hr_payroll_management.generators;

import java.nio.charset.Charset;
import java.util.Random;

public class OnlineSecurityKeyGenerator {
	public static String generateOnlineSecurityKey() {
	    byte[] arr = new byte[10]; 
	    new Random().nextBytes(arr);
	    String str = new String(arr, Charset.forName("UTF-8"));
	 
	    return str;
	}
}
