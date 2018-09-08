package POJO_MODEL.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

import POJO_MODEL.user_management.Address;

public class Branch {
	private String branchId;
	private Address branchAddress;
	private String branchEmail;

	//Back Reference
	private Collection<NormalEmployee> normalEmployeeList = new ArrayList<NormalEmployee> ();
	private Collection<Manager> managerList = new ArrayList<Manager> ();
	private Collection<Head> headList = new ArrayList<Head> ();
	private Collection<Admin> adminList = new ArrayList<Admin> ();
	
	public Branch() {}

	public Branch(String branchId, Address branchAddress, String branchEmail) {
		this.branchId = branchId;
		this.branchAddress = branchAddress;
		this.branchEmail = branchEmail;
	}

	public Branch(String branchId, String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
			int addressZipCode, String branchEmail) {
		this.setBranchId(branchId);
		this.setBranchAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
		this.setBranchEmail(branchEmail);
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

	public Collection<NormalEmployee> getNormalEmployeeList() {
		return normalEmployeeList;
	}

	public void setNormalEmployeeList(Collection<NormalEmployee> normalEmployeeList) {
		this.normalEmployeeList = normalEmployeeList;
	}

	public Collection<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(Collection<Manager> managerList) {
		this.managerList = managerList;
	}

	public Collection<Head> getHeadList() {
		return headList;
	}

	public void setHeadList(Collection<Head> headList) {
		this.headList = headList;
	}

	public Collection<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(Collection<Admin> adminList) {
		this.adminList = adminList;
	}
	
	public void displayBranch() {
		System.out.println("============Branch Details : ============");
		System.out.println(this.getBranchId());
		this.getBranchAddress().displayAddress();
		System.out.println(this.getBranchEmail());
	}

	//======================================================================================================================
//	public void setBranchAddress(String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
//			int addressZipCode) {
//		this.setBranchAddress(new Address(addressStreet01, addressStreet02, addressCity, addressProvince, addressZipCode));
//	}
}