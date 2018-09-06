package POJO_MODEL.user_management;

import java.sql.Date;

//Entity
public abstract class Person {
	private String personId;						//Auto
	private Name name;								//Embedded
	private Address address;						//Embedded
	private String nic;								//Attribute
	private Date dateOfBirth;						//Attribute
	private String personalEmail;					//Attribute
	private int registrationDatesId;				//Entity Reference
	private int genderId;							//Entity Reference
	private int nationalityId;						//Entity Reference
	private String branchId;						//Entity Reference
	private int onlineSecurityId;					//Entity Reference
	private int permissionLevel;					//Entity Reference
	
	public Person() {}

	public Person(String personId, Name name, Address address, String nic, RegistrationDates registrationDates,
			Date dateOfBirth, String personalEmail, int contact, int registrationDatesId,  int genderId, int nationalityId, 
			String branchId, int onlineSecurityId, int permissionLevel) {

	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public int getRegistrationDatesId() {
		return registrationDatesId;
	}

	public void setRegistrationDatesId(int registrationDatesId) {
		this.registrationDatesId = registrationDatesId;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public int getOnlineSecurityId() {
		return onlineSecurityId;
	}

	public void setOnlineSecurityId(int onlineSecurityId) {
		this.onlineSecurityId = onlineSecurityId;
	}
	
	public int getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	//======================================================================================================================
	public void setName(String firstName, String middleName, String lastName, String otherNames) {
		this.setName(new Name(firstName, middleName, lastName, otherNames));
	}
	
	public void setAddress(String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
			int addressZipCode) {
		this.setAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
	}
}