package POJO_MODEL.user_management;

public class Customer extends Person {
	public Customer() {
		super();
	}
	
	public void displayCustomer() {
		System.out.println("Customer Details : ");
		System.out.println("\tCustomerId : " + this.getPersonId());
		System.out.println("\tCustomer Name : ");
		this.getName().displayName();
		System.out.println("\tCustomer Address : ");
		this.getAddress().displayAddress();
		System.out.println("\tCustomer Birthday : " + this.getDateOfBirth());
		System.out.println("\tCustomer Personal Email : " + this.getPersonalEmail());
		System.out.println("\tCustomer Physical Registration Date : " + this.getRegistrationDates().getPhysicalRegistrationDate());
		System.out.println("\tCustomer Online Registration Date : " + this.getRegistrationDates().getOnlineRegistrationDate());
		System.out.println("\tCustomer Gender Details : ");
		this.getGender().displayGender();
		System.out.println("\tCustomer Nationality Details : ");
		this.getNationality().displayNationality();
		System.out.println("\tCustomer Branch Details : ");
		this.getBranch().displayBranch();
		System.out.println("\tCustomer Online Security Key Details : ");
		this.getOnlineSecurityKey().displayOnlineSecurityKey();
		System.out.println("\tCustomer Home Contact Number : " + this.getHomeContact());
		System.out.println("\tCustomer Mobile Contact Number : " + this.getMobileContact());
//		System.out.println("\tCustomer Permission Details : ");
//		this.getPermission().displayPermission();
		System.out.println("\tOnline Customer Account Details : ");
		this.getOnlineAccount().displayOnlineAccount();
	}
}
