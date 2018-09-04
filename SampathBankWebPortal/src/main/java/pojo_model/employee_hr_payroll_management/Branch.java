package pojo_model.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

import pojo_model.user_management.Address;
import pojo_model.user_management.Person;

public class Branch {
	private String branchId;
	private Address branchAddress;
	private String branchEmail;
	private Collection<Person> person = new ArrayList<Person> ();
	private Collection<Department> department = new ArrayList<Department> ();
	private Collection<String> contactNumber = new ArrayList<String> ();

	public Branch() {}
	
	public Branch(String branchId, String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode, String branchEmail) {
		this.setBranchId(branchId);
		this.setBranchAddress(addStreet01, addStreet02, addCity, addProvince, zipCode);
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public void setBranchAddress(String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode) {
		this.setBranchAddress(new Address(addStreet01, addStreet02, addCity, addProvince, zipCode));
	}
	
	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	public String getBranchId() {
		return branchId;
	}
	
	public Address getBranchAddress() {
		return branchAddress;
	}
	
	public String getBranchEmail() {
		return branchEmail;
	}
}