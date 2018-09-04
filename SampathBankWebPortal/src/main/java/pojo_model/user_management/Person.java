package pojo_model.user_management;

import java.sql.Date;

import pojo_model.employee_hr_payroll_management.Branch;
import pojo_model.employee_hr_payroll_management.converters.DateConverter;
import pojo_model.employee_hr_payroll_management.generators.PrimaryKeyGenerator;
import pojo_model.employee_hr_payroll_management.managers.CommonEntityManager;

//Entity
public abstract class Person {
	private String personId; //Auto
	private Name name;
	private Address address;
	private RegistrationDates registrationDates;
	private String personalEmail;
	private int genderId; //Entity
	private String nic;
	private int nationalityId; //Entity
	private Date dateOfBirth;
	private String branchId;
	private int onlineSecurityId; //auto
	private int roleId;
	private Contact contact;
	
	public Person() {}

	public Person(String personId, Name name, Address address, RegistrationDates registrationDates,
			String personalEmail, int genderId, String nic, int nationalityId,
			Date dateOfBirth, String branchId, int onlineSecurityId, int roleId, Contact contact) {
		this.setPersonId(personId);
		this.setName(name);
		this.setAddress(address);
		this.setRegistrationDates(registrationDates);
		this.setPersonalEmail(personalEmail);
		this.setGenderId(genderId);
		this.setNic(nic);
		this.setNationalityId(nationalityId);
		this.setDateOfBirth(dateOfBirth);
		this.setBranchId(branchId);
		this.setOnlineSecurityId(onlineSecurityId);
		this.setRoleId(roleId);
		this.setContact(contact);
	}

	public void setPersonId() {
		this.setPersonId(new PrimaryKeyGenerator().personIdGenerator());
	}//call
	
	public void setOnlineSecurityId() {
		
	}
	
	public void setName(String firstName, String middleName, String lastName, String otherNames) {
		this.setName(new Name(firstName, middleName, lastName, otherNames));
	}
	
	public void setAddress(String addressStreet01, String addressStreet02, String addressCity, String addressProvince,
			int addressZipCode) {
		this.setAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
	}
	
	public void setRegistrationDates(Date physicalRegistrationDate, Date onlineRegistrationDate) {
		this.setRegistrationDates(new RegistrationDates(physicalRegistrationDate, onlineRegistrationDate));
	}
	//

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

	public RegistrationDates getRegistrationDates() {
		return registrationDates;
	}

	public void setRegistrationDates(RegistrationDates registrationDates) {
		this.registrationDates = registrationDates;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public void setContact(String contactNumberHome, String contactNumberMobile) {
		this.setContact(new Contact(contactNumberHome, contactNumberMobile));
	}
}