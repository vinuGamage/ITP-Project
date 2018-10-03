package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.HRSalaryDAO;
import POJO_MODEL.employee_hr_payroll_management.Salary;

public class SalaryInitiation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String HRManagerSalaryInitiate = request.getParameter("HRManagerSalaryInitiate");
		String salarySeconded = request.getParameter("salarySeconded");
		
		if(HRManagerSalaryInitiate != null)
			initiateSalary(request, response);
		else if(salarySeconded != null)
			secondedSalary(request, response);
		
	}

	private void initiateSalary(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			Salary salary = new Salary(empId, Double.parseDouble(basicSalaryPerMonth), Double.parseDouble(overTimeHrs), Double.parseDouble(overTimeRate), Double.parseDouble(carAllowance), Double.parseDouble(bonus), Double.parseDouble(tax), Double.parseDouble(nonTaxSubAllowDays), Double.parseDouble(nonTaxSubAllowRate), Double.parseDouble(nonTaxMedical), Double.parseDouble(epf), Double.parseDouble(medical), Double.parseDouble(loanRepayment), Double.parseDouble(otherDeductions));
			salary.calculateTotalOT();
			salary.calculateTotalTaxableIncome();
			salary.calculateTotalNonTaxableIncome();
			salary.calculateTotalDeductions();
			salary.calculateNetSalary();
			
			HttpSession session = request.getSession();
			session.setAttribute("salary", salary);
			
			if(HRSalaryDAO.checkEmpSalary(empId)) {
				session.setAttribute("doo", "update");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('The employee you are requesting already has his/her salary, for this month, entered in the database, Submitting on the next page will update and overwrite the current record!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_SecondedSalary.jsp';");
				out.println("</script>");
			} else {
				session.setAttribute("doo", "insert");
				response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_SecondedSalary.jsp");
			}
		} else {
			
		}
	}
	
	private void secondedSalary(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String submit = request.getParameter("submit");
		String reject = request.getParameter("reject");
		
		HttpSession session = request.getSession();
		
		if(submit != null) {
			Salary salary = (Salary) session.getAttribute("salary");
			String doo = (String) session.getAttribute("doo");
			if(salary != null && doo.equals("update")) {
				
			} else if(salary != null && doo.equals("insert")) {
				
			} else {
				
			}
		} else if (reject != null) {
			session.removeAttribute("salary");
			session.removeAttribute("doo");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Rejected!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_InitiateSalary.jsp';");
			out.println("</script>");
		}
	}
}
