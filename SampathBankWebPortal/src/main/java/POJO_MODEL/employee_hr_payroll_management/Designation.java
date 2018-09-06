package POJO_MODEL.employee_hr_payroll_management;

public class Designation {
	private int designationId;
	private String designation;
	
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
}
