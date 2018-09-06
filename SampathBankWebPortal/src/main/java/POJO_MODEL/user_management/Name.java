package POJO_MODEL.user_management;

public class Name {
	private String firstName;	//Attribute
	private String middleName;	//Attribute
	private String lastName;	//Attribute
	private String otherNames;	//Attribute
	
	public Name() {}
	
	public Name(String firstName, String middleName, String lastName, String otherNames) {
		this.setFirstName(firstName.trim());
		
		if(middleName == null || middleName.trim().length() == 0)
			this.setMiddleName(null);
		else
			this.setMiddleName(middleName.trim());
		
		this.setLastName(lastName.trim());
		
		if(otherNames == null || otherNames.trim().length() == 0)
			this.setOtherNames(null);
		else
			this.setOtherNames(otherNames.trim());
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getOtherNames() {
		return this.otherNames;
	}	
}
