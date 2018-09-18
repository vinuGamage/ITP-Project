package POJO_MODEL.employee_hr_payroll_management;

import POJO_MODEL.user_management.Updation;

public class UpdateRequestManagement {
	private Employee employee;
	private Updation updation;
	private String diffStuff;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Updation getUpdation() {
		return updation;
	}
	public void setUpdation(Updation updation) {
		this.updation = updation;
	}
	
	public void setDiffStuff(String diffStuff) {
		this.diffStuff = diffStuff;
	}
	public String getDiffStuff() {
		return diffStuff;
	}
	
	public void initiateDiffStuff() {
		if(updation.getAddressStreet01() != null && updation.getAddressStreet01().trim().length() != 0)
			this.concatenateStuffTogether("Address Street01");
		if(updation.getAddressStreet02() != null && updation.getAddressStreet02().trim().length() != 0)
			this.concatenateStuffTogether("Address Street02");
		if(updation.getAddressCity() != null && updation.getAddressCity().trim().length() != 0)
			this.concatenateStuffTogether("City");
		if(updation.getAddressProvince() != null && updation.getAddressProvince().trim().length() != 0)
			this.concatenateStuffTogether("Province");
		if(updation.getAddressZIP() != 0)
			this.concatenateStuffTogether("ZIP Code");
		if(updation.getPersonalEmail() != null && updation.getPersonalEmail().trim().length() != 0)
			this.concatenateStuffTogether("Personal Email");
		if(updation.getHomeContact() != null && updation.getHomeContact().trim().length() != 0)
			this.concatenateStuffTogether("Home Contact Number");
		if(updation.getMobileContact() != null && updation.getMobileContact().trim().length() != 0)
			this.concatenateStuffTogether("Mobile Contact Number");
	}
	
	public void concatenateStuffTogether(String stuff) {
		if(this.getDiffStuff() == null || this.getDiffStuff().trim().length() == 0) {
			this.setDiffStuff(stuff);
		} else {
			this.setDiffStuff(this.getDiffStuff() + ", " + stuff);
		}
	}
}
