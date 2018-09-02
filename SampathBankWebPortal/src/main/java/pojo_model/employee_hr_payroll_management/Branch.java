package pojo_model.employee_hr_payroll_management;

import pojo_model.user_management.Address;

public class Branch {
	private String branchId;
	private Address branchAddress;

	public Branch() {}
	
	public Branch(String branchId, String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode) {
		this.setBranchId(branchId);
		this.setBranchAddress(addStreet01, addStreet02, addCity, addProvince, zipCode);
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public void setBranchAddress(String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode) {
		this.branchAddress = new Address(addStreet01, addStreet02, addCity, addProvince, zipCode);
	}
	
	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public Address getBranchAddress() {
		return branchAddress;
	}	
}
