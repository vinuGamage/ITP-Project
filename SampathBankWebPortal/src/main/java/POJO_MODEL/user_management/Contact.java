package POJO_MODEL.user_management;

public class Contact {
	private int personId;			//Entity Reference
	private String contactNumber;	//Attribute
	private String type;			//Attribute
	
	public Contact() {}
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
