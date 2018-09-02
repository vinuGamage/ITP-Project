package pojo_model.user_management;

public class ContactNumber {
	private String number;
	private String type;
	
	public ContactNumber() {}
	
	public ContactNumber(String number, String type) {
		this.setNumber(number.trim());
		this.setType(type.trim());
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getType() {
		return this.type;
	}
}
