package POJO_MODEL.user_management.validators;

public class Validator {
	public static boolean validateLoginCredentials(String username, String password, String usernameDB, String passwordDB) {
		if(username.equals(usernameDB) && password.equals(passwordDB)) {
			return true;
		}
		
		else
			return false;
	}
}
