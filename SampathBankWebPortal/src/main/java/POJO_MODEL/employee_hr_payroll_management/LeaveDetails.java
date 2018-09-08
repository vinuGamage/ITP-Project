package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

public class LeaveDetails {
	private int noOfLeavesPerYear;
	private int noOfLeavesLeft;
	private Date lastEffectiveLeaveDate;
	
	public int getNoOfLeavesPerYear() {
		return noOfLeavesPerYear;
	}
	public void setNoOfLeavesPerYear(int noOfLeavesPerYear) {
		this.noOfLeavesPerYear = noOfLeavesPerYear;
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
