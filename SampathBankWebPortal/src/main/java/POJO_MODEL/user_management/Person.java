package POJO_MODEL.user_management;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import POJO_MODEL.employee_hr_payroll_management.Branch;

//Entity
public abstract class Person {
	private String personId;						//Auto
	private Name name;								//Embedded
	private Address address;						//Embedded
	private String nic;								//Attribute
	private Date dateOfBirth;						//Attribute
	private String personalEmail;					//Attribute
	private RegistrationDates registrationDates;	//Embedded
	private Gender gender;							//Entity Reference
	private Nationality nationality;				//Entity Reference
	private Branch branch;							//Entity Reference
	private OnlineSecurityKey onlineSecurityKey;	//Entity Reference
	private OnlineAccount onlineAccount;
	private String homeContact;
	private String mobileContact;
	
	
	public Person() {}
	
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

	public RegistrationDates getRegistrationDates() {
		return registrationDates;
	}

	public void setRegistrationDates(RegistrationDates registrationDates) {
		this.registrationDates = registrationDates;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public OnlineSecurityKey getOnlineSecurityKey() {
		return onlineSecurityKey;
	}

	public void setOnlineSecurityKey(OnlineSecurityKey onlineSecurityKey) {
		this.onlineSecurityKey = onlineSecurityKey;
	}

	public OnlineAccount getOnlineAccount() {
		return onlineAccount;
	}

	public void setOnlineAccount(OnlineAccount onlineAccount) {
		this.onlineAccount = onlineAccount;
	}

	public String getHomeContact() {
		return homeContact;
	}

	public void setHomeContact(String homeContact) {
		this.homeContact = homeContact;
	}

	public String getMobileContact() {
		return mobileContact;
	}

	public void setMobileContact(String mobileContact) {
		this.mobileContact = mobileContact;
	}

	//======================================EHPM_Management===================================================================
	public void setName(String firstName, String middleName, String lastName, String otherNames) {
		this.setName(new Name(firstName, middleName, lastName, otherNames));
	}
	
	public void setAddress(String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
			int addressZipCode) {
		this.setAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
	}
	
	public void setPhysicalRegistrationDate(Date phyRegDate) {
		this.setRegistrationDates(new RegistrationDates(phyRegDate));
	}
}