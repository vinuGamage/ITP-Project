package POJO_MODEL.user_management;

public class Contact {
	private String personId;			//Entity Reference
	private String contactNumber;	//Attribute
	private String type;			//Attribute
	
	public Contact() {}
	
	public Contact(String personId, String contactNumber, String type) {
		this.setPersonId(personId);
		this.setContactNumber(contactNumber);
		this.setType(type);
	}
	
	public Contact(String contactNumber, String type) {
		this.setContactNumber(contactNumber);
		this.setType(type);
	}
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
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
