package POJO_MODEL.employee_hr_payroll_management;

import java.sql.Date;

public class LeaveRequest {
	private String employeeId;
	private int leaveRequestId;//
	private String leaveType;
	private String leaveDescription;
	private Date leaveRequestedDate;
	private Date leaveStartDate;
	private Date leaveFinishDate;
	private String leaveStatus;//
	private String leaveReviewedBy;//
	private String leaveReviewSpeed;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveDescription() {
		return leaveDescription;
	}
	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}
	public Date getLeaveRequestedDate() {
		return leaveRequestedDate;
	}
	public void setLeaveRequestedDate(Date leaveRequestedDate) {
		this.leaveRequestedDate = leaveRequestedDate;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveFinishDate() {
		return leaveFinishDate;
	}
	public void setLeaveFinishDate(Date leaveFinishDate) {
		this.leaveFinishDate = leaveFinishDate;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getLeaveReviewedBy() {
		return leaveReviewedBy;
	}
	public void setLeaveReviewedBy(String leaveReviewedBy) {
		this.leaveReviewedBy = leaveReviewedBy;
	}
	public String getLeaveReviewSpeed() {
		return leaveReviewSpeed;
	}
	public void setLeaveReviewSpeed(String leaveReviewSpeed) {
		this.leaveReviewSpeed = leaveReviewSpeed;
	}
}
