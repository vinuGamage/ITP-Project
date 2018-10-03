package POJO_MODEL.employee_hr_payroll_management;

public class Salary {
	private String employeeId;
	// TAXABLE INCOME
	private double tMonthlySalary;
	private float tOvertimeHrs;
	private double tOvertimeRate;
	private double tCarAllowance;
	private double tBonus; // Percentage
	private double tax; // Percentage
	//NON-TAXABLE INCOME
	private float ntSubsistenceAllowanceDays;
	private double ntSubsistenceAllowanceRate;
	private double ntMedical;
	//DEDUCTIONS
	private double dEpf;
	private double dMedical;
	private double dLoanRepayment;
	private double dOtherDeductions;
	// Summaries
	private double totalOT;
	private double totalTaxableIncome;
	private double totalNonTaxableIncome;
	private double totalDeductions;
	private double netSalary;
	
	public Salary(String employeeId, double tMonthlySalary, float tOvertimeHrs, double tOvertimeRate,
			double tCarAllowance, double tBonus, double tax, float ntSubsistenceAllowanceDays,
			double ntSubsistenceAllowanceRate, double ntMedical, double dEpf, double dMedical, double dLoanRepayment,
			double dOtherDeductions) {
		this.employeeId = employeeId;
		this.tMonthlySalary = tMonthlySalary;
		this.tOvertimeHrs = tOvertimeHrs;
		this.tOvertimeRate = tOvertimeRate;
		this.tCarAllowance = tCarAllowance;
		this.tBonus = tBonus;
		this.tax = tax;
		this.ntSubsistenceAllowanceDays = ntSubsistenceAllowanceDays;
		this.ntSubsistenceAllowanceRate = ntSubsistenceAllowanceRate;
		this.ntMedical = ntMedical;
		this.dEpf = dEpf;
		this.dMedical = dMedical;
		this.dLoanRepayment = dLoanRepayment;
		this.dOtherDeductions = dOtherDeductions;
	}
	
	public void calculateTotalOT() {
		this.setTotalOT(this.gettOvertimeHrs() * this.gettOvertimeRate());
		System.out.println("OT: " + this.getTotalOT());
	}
	
	public void calculateTotalTaxableIncome() {
		this.setTotalTaxableIncome((this.gettMonthlySalary() * (100 + this.gettBonus())) / 100 + (this.gettOvertimeHrs() * this.gettOvertimeRate()) + 
				this.gettCarAllowance());
		System.out.println("Taxable Income: " + this.getTotalTaxableIncome());
	}
	
	public void calculateTotalNonTaxableIncome() {
		this.setTotalNonTaxableIncome((this.getNtSubsistenceAllowanceDays() * this.getNtSubsistenceAllowanceRate()) + this.getNtMedical());
		System.out.println("Non-Taxable Income: " + this.getTotalNonTaxableIncome());
	}
	
	public void calculateTotalDeductions() {
		this.setTotalDeductions(this.getdEpf() + this.getdMedical() + this.getdLoanRepayment() + this.getdOtherDeductions());
		System.out.println("Deductions: " + this.getTotalDeductions());
	}
	
	public void calculateNetSalary() {
		this.setNetSalary((this.getTotalTaxableIncome() * (100 - this.getTax())) / 100 + this.getTotalNonTaxableIncome() - this.getTotalDeductions());
		System.out.println("Net Salary: " + this.getNetSalary());
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public double gettMonthlySalary() {
		return tMonthlySalary;
	}
	public void settMonthlySalary(double tMonthlySalary) {
		this.tMonthlySalary = tMonthlySalary;
	}
	public float gettOvertimeHrs() {
		return tOvertimeHrs;
	}
	public void settOvertimeHrs(float tOvertimeHrs) {
		this.tOvertimeHrs = tOvertimeHrs;
	}
	public double gettOvertimeRate() {
		return tOvertimeRate;
	}
	public void settOvertimeRate(double tOvertimeRate) {
		this.tOvertimeRate = tOvertimeRate;
	}
	public double gettCarAllowance() {
		return tCarAllowance;
	}
	public void settCarAllowance(double tCarAllowance) {
		this.tCarAllowance = tCarAllowance;
	}
	public double gettBonus() {
		return tBonus;
	}
	public void settBonus(double tBonus) {
		this.tBonus = tBonus;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public float getNtSubsistenceAllowanceDays() {
		return ntSubsistenceAllowanceDays;
	}
	public void setNtSubsistenceAllowanceDays(float ntSubsistenceAllowanceDays) {
		this.ntSubsistenceAllowanceDays = ntSubsistenceAllowanceDays;
	}
	public double getNtSubsistenceAllowanceRate() {
		return ntSubsistenceAllowanceRate;
	}
	public void setNtSubsistenceAllowanceRate(double ntSubsistenceAllowanceRate) {
		this.ntSubsistenceAllowanceRate = ntSubsistenceAllowanceRate;
	}
	public double getNtMedical() {
		return ntMedical;
	}
	public void setNtMedical(double ntMedical) {
		this.ntMedical = ntMedical;
	}
	public double getdEpf() {
		return dEpf;
	}
	public void setdEpf(double dEpf) {
		this.dEpf = dEpf;
	}
	public double getdMedical() {
		return dMedical;
	}
	public void setdMedical(double dMedical) {
		this.dMedical = dMedical;
	}
	public double getdLoanRepayment() {
		return dLoanRepayment;
	}
	public void setdLoanRepayment(double dLoanRepayment) {
		this.dLoanRepayment = dLoanRepayment;
	}
	public double getdOtherDeductions() {
		return dOtherDeductions;
	}
	public void setdOtherDeductions(double dOtherDeductions) {
		this.dOtherDeductions = dOtherDeductions;
	}
	public double getTotalOT() {
		return totalOT;
	}
	public void setTotalOT(double totalOT) {
		this.totalOT = totalOT;
	}
	public double getTotalTaxableIncome() {
		return totalTaxableIncome;
	}
	public void setTotalTaxableIncome(double totalTaxableIncome) {
		this.totalTaxableIncome = totalTaxableIncome;
	}
	public double getTotalNonTaxableIncome() {
		return totalNonTaxableIncome;
	}
	public void setTotalNonTaxableIncome(double totalNonTaxableIncome) {
		this.totalNonTaxableIncome = totalNonTaxableIncome;
	}
	public double getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
}
