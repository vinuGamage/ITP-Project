package POJO_MODEL.employee_hr_payroll_management;

import POJO_MODEL.user_management.Address;

public class Branch {
	private String branchId;
	private Address branchAddress;
	private String branchEmail;

	public Branch() {}

	public Branch(String branchId, Address branchAddress, String branchEmail) {
		this.branchId = branchId;
		this.branchAddress = branchAddress;
		this.branchEmail = branchEmail;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public String getBranchEmail() {
		return branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	
	//======================================================================================================================
	public void setBranchAddress(String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
			int addressZipCode) {
		this.setBranchAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
	}
}