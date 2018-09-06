package POJO_MODEL.user_management;

public class Contact {
	private int personId;			//Entity Reference
	private String contactNumber;	//Attribute
	private String type;			//Attribute
	
	public Contact() {}

	public Contact(int personId, String contactNumber, String type) {
		this.setPersonId(personId);
		this.setContactNumber(contactNumber);
		this.setType(type);
	}
	
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
