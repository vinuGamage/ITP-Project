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
	private Date physicalRegistrationDate;
	private Date onlineRegistrationDate;
	private String emailPersonal;
	private int genderId; //Entity
	private String nic;
	private int nationalityId; //Entity
	private Date dateOfBirth;
	private String branchId;
	private String onlineSecurityId;
	
	public Person() {}

	public Person(String personId, Name name, Address address, Date physicalRegistrationDate, Date onlineRegistrationDate,
			String emailPersonal, int genderId, String nic, int nationalityId,
			Date dateOfBirth, String branchId, String onlineSecurityId) {
		this.setPersonId(personId);
		this.setName(name);
		this.setAddress(address);
		this.setRegistrationDates(registrationDates);
		this.emailPersonal = emailPersonal;
		this.contactNumberHome = contactNumberHome;
		this.genderId = genderId;
		this.nic = nic;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
		this.branchId = branchId;
		this.onlineSecurityId = onlineSecurityId;
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

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public String getContactNumberHome() {
		return contactNumberHome;
	}

	public int getGenderId() {
		return genderId;
	}

	public String getNic() {
		return nic;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getBranchId() {
		return branchId;
	}

	public String getOnlineSecurityId() {
		return onlineSecurityId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setRegistrationDates(RegistrationDates registrationDates) {
		this.registrationDates = registrationDates;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public void setContactNumberHome(String contactNumberHome) {
		this.contactNumberHome = contactNumberHome;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public void setOnlineSecurityId(String onlineSecurityId) {
		this.onlineSecurityId = onlineSecurityId;
	}
}