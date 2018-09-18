package POJO_MODEL.user_management.generators;

public class RegistrationPINGenerator {
	public static int generateRegPin() {
		int pin = (int) (Math.random() * ((99999 - 11111) + 1)) + 11111;
		
		return pin;
	}
}
