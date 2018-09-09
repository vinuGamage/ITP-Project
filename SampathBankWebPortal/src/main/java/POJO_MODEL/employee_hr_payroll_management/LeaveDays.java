package POJO_MODEL.employee_hr_payroll_management;

public class LeaveDays {
	private int leaveDaysId;
	private int noOfLeavesPerYear;
	
	public LeaveDays(int leaveDaysId, int noOfLeavesPerYear) {
		this.setLeaveDaysId(leaveDaysId);
		this.setNoOfLeavesPerYear(noOfLeavesPerYear);
	}
	
	public int getLeaveDaysId() {
		return leaveDaysId;
	}
	public void setLeaveDaysId(int leaveDaysId) {
		this.leaveDaysId = leaveDaysId;
	}
	public int getNoOfLeavesPerYear() {
		return noOfLeavesPerYear;
	}
	public void setNoOfLeavesPerYear(int noOfLeavesPerYear) {
		this.noOfLeavesPerYear = noOfLeavesPerYear;
	}
	
	public void displayLeaveDays() {
		System.out.println("============LeaveDays Details : ============");
		System.out.println(this.getLeaveDaysId());
		System.out.println(this.getNoOfLeavesPerYear());
	}
}
