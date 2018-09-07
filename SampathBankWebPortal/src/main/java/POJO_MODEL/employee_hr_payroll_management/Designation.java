package POJO_MODEL.employee_hr_payroll_management;

import java.util.ArrayList;
import java.util.Collection;

public class Designation {
	private int designationId;
	private String designation;
	
	//Back Reference
	private Collection<NormalEmployee> normalEmployeeList = new ArrayList<NormalEmployee> ();
	private Collection<Manager> managerList = new ArrayList<Manager> ();
	private Collection<Head> headList = new ArrayList<Head> ();
	private Collection<Admin> adminList = new ArrayList<Admin> ();
	
	public Designation(int designationId, String designation) {
		this.setDesignationId(designationId);
		this.setDesignation(designation);
	}

	public int getDesignationId() {
		return designationId;
	}
	
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
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
}
