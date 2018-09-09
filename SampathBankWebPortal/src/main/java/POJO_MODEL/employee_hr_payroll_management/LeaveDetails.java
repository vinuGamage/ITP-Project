package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

public class LeaveDetails {
	private String employeeId;
	private int noOfLeavesLeft;
	private Date lastEffectiveLeaveDate;
	
	public LeaveDetails(String employeeId, int noOfLeavesLeft, Date lastEffectiveLeaveDate) {
		this.employeeId = employeeId;
		this.noOfLeavesLeft = noOfLeavesLeft;
		this.lastEffectiveLeaveDate = lastEffectiveLeaveDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getNoOfLeavesLeft() {
		return noOfLeavesLeft;
	}
	public void setNoOfLeavesLeft(int noOfLeavesLeft) {
		this.noOfLeavesLeft = noOfLeavesLeft;
	}
	public Date getLastEffectiveLeaveDate() {
		return lastEffectiveLeaveDate;
	}
	public void setLastEffectiveLeaveDate(Date lastEffectiveLeaveDate) {
		this.lastEffectiveLeaveDate = lastEffectiveLeaveDate;
	}
	
	
}
