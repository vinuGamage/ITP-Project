package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO_MODEL.employee_hr_payroll_management.Salary;

public class SalaryInitiation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String HRManagerSalaryInitiate = request.getParameter("HRManagerSalaryInitiate");
		
		if(HRManagerSalaryInitiate != null)
			initiateSalary(request, response);
		
	}

	private void initiateSalary(HttpServletRequest request, HttpServletResponse response) {
		String empId = request.getParameter("empId");
		String basicSalaryPerMonth = request.getParameter("basicSalaryPerMonth");
		String overTimeHrs = request.getParameter("overTimeHrs");
		String overTimeRate = request.getParameter("overTimeRate");
		String carAllowance = request.getParameter("carAllowance");
		String bonus = request.getParameter("bonus");
		String tax = request.getParameter("tax");
		String nonTaxSubAllowDays = request.getParameter("nonTaxSubAllowDays");
		String nonTaxSubAllowRate = request.getParameter("nonTaxSubAllowRate");
		String nonTaxMedical = request.getParameter("nonTaxMedical");
		String epf = request.getParameter("epf");
		String medical = request.getParameter("medical");
		String loanRepayment = request.getParameter("loanRepayment");
		String otherDeductions = request.getParameter("otherDeductions");
		
		// Validation goes here
		if(true) {
			Salary salary = new Salary(empId, Double.parseDouble(basicSalaryPerMonth),Float.parseFloat(overTimeHrs), Double.parseDouble(overTimeRate), Double.parseDouble(carAllowance), Double.parseDouble(bonus), Double.parseDouble(tax), Float.parseFloat(nonTaxSubAllowDays), Double.parseDouble(nonTaxSubAllowRate), Double.parseDouble(nonTaxMedical), Double.parseDouble(epf), Double.parseDouble(medical), Double.parseDouble(loanRepayment), Double.parseDouble(otherDeductions));
			salary.calculateTotalOT();
			salary.calculateTotalTaxableIncome();
			salary.calculateTotalNonTaxableIncome();
			salary.calculateTotalDeductions();
			salary.calculateNetSalary();
			
			
		} else {
			
		}
	}
}
