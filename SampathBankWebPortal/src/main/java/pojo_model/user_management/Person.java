package pojo_model.user_management;

import java.sql.Date;

import pojo_model.employee_hr_payroll_management.Branch;
import pojo_model.employee_hr_payroll_management.converters.DateConverter;
import pojo_model.employee_hr_payroll_management.managers.CommonEntityManager;

//Entity
public abstract class Person {
	private String personId; //Auto Generated
	private Name name;
	private Address address;
	private RegistrationDates registrationDates; //Auto Assigned
	private Contact contact;
	private Gender gender; //Entity
	private String nic;
	private Nationality nationality; //Entity
	private Date dateOfBirth;
	private Role role; //Entity
	private Permission permission; //Entity
	private Branch branch; //Entity
	private OnlineSecurityKey onlineSecurityKey; //Entity //Auto Generated
	
	public Person() {}

	public Person(String personId, String firstName, String middleName, String lastName, String otherNames, String addStreet01, String addStreet02, String addCity,
			String addProvince, int zipCode, Date phyRegDate, Date onlineRegDate, String personalEmail, String contactNumberHome, String contactNumberMobile, Gender gender,
			String nic, Nationality nationality, Date dateOfBirth, Role role, Permission permission, Branch branch, OnlineSecurityKey onlineSecurityKey) {
		this.setPersonId(personId.trim());
		this.setName(firstName, middleName, lastName, otherNames);
		this.setAddress(addStreet01, addStreet02, addCity, addProvince, zipCode);
		this.setRegistrationDates(phyRegDate, onlineRegDate);
		this.setContact(personalEmail, contactNumberHome, contactNumberMobile);
		this.setGender(gender);
		this.setNic(nic.trim());
		this.setNationality(nationality);
		this.setDateOfBirth(dateOfBirth);
		this.setRole(role);
		this.setPermission(permission);
		this.setBranch(branch);
		this.setOnlineSecurityKey(onlineSecurityKey);
	}

	/*
	 * @Author Samarasekara S.A.M.I.D.
	 * 
	 * */
	public Person(String firstName, String middleName, String lastName, String otherNames, String addStreet01, String addStreet02, String addCity,
			String addProvince, int zipCode, String personalEmail, String contactNumberHome, String contactNumberMobile, String gender,
			String nic, String nationality, String dateOfBirth, String role, String branch) {
		this.setName(firstName, middleName, lastName, otherNames);
		this.setAddress(addStreet01, addStreet02, addCity, addProvince, zipCode);
		this.setContact(personalEmail, contactNumberHome, contactNumberMobile);
		this.setGender(gender.trim());
		this.setNic(nic.trim());
		this.setNationality(nationality.trim());
		this.setDateOfBirth(dateOfBirth.trim());
		this.setRole(role.trim());
		this.setBranch(branch);
	}
	
	public Person(String nic) {
		this.setNic(nic);
	}
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public void setName(String firstName, String middleName, String lastName, String otherNames) {
		this.name = new Name(firstName, middleName, lastName, otherNames); //Composition
	}

	public void setAddress(String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode) {
		this.address = new Address(addStreet01, addStreet02, addCity, addProvince, zipCode); //Composition
	}

	public void setRegistrationDates(Date phyRegDate, Date onlineRegDate) {
		this.registrationDates = new RegistrationDates(phyRegDate, onlineRegDate); //Composition
	}

	public void setContact(String personalEmail, String contactNumberHome, String contactNumberMobile) {
		this.contact = new Contact(personalEmail, contactNumberHome, contactNumberMobile); //Composition
	}

	public void setGender(String gender) {
		this.gender = new CommonEntityManager().getGender(gender);
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setNationality(String nationality) {
		this.nationality = new CommonEntityManager().getNationality(nationality);
	}
	
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = new DateConverter().getSqlDate(dateOfBirth);
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setRole(String role) {
		this.role = new CommonEntityManager().getRole(role);
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setBranch(String branch) {
		this.branch = new CommonEntityManager().getBranch(branch);
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void setOnlineSecurityKey(OnlineSecurityKey onlineSecurityKey) {
		this.onlineSecurityKey = onlineSecurityKey;
	}
	
	public String getPersonId() {
		return personId;
	}

	public Name getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public RegistrationDates getRegistrationDates() {
		return registrationDates;
	}

	public Contact getContact() {
		return contact;
	}

	public Gender getGender() {
		return gender;
	}

	public String getNic() {
		return nic;
	}

	public Nationality getNationality() {
		return nationality;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Role getRole() {
		return role;
	}

	public Permission getPermission() {
		return permission;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public OnlineSecurityKey getOnlineSecurityKey() {
		return onlineSecurityKey;
	}
}
