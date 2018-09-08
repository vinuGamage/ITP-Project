package POJO_MODEL.user_management;

import java.util.ArrayList;
import java.util.Collection;

import POJO_MODEL.employee_hr_payroll_management.Admin;
import POJO_MODEL.employee_hr_payroll_management.Head;
import POJO_MODEL.employee_hr_payroll_management.Manager;
import POJO_MODEL.employee_hr_payroll_management.NormalEmployee;

public class Gender {
	private int genderId;
	private String gender;
	
	//Back Reference
	private Collection<NormalEmployee> normalEmployeeList = new ArrayList<NormalEmployee> ();
	private Collection<Manager> managerList = new ArrayList<Manager> ();
	private Collection<Head> headList = new ArrayList<Head> ();
	private Collection<Admin> adminList = new ArrayList<Admin> ();
	
	public Gender() {}
	
	public Gender(int genderId, String gender) {
		this.setGenderId(genderId);
		this.setGender(gender);
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	public void displayGender() {
		System.out.println("============Gender : ============");
		System.out.println(this.getGenderId());
		System.out.println(this.getGender());
	}
}
