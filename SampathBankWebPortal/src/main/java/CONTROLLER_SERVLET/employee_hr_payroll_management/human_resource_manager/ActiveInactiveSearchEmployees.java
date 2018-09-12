package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.ActiveInactiveSearchEmployeesDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;

public class ActiveInactiveSearchEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deed = request.getParameter("deed");
		
		if(deed.equals("allActive")) {
			allActiveEmployeesDisplay(request, response);
		} else if(deed.equals("inActive")) {
			allInactiveEmployeesDisplay(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void allActiveEmployeesDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<Employee> activeEmployeeList = ActiveInactiveSearchEmployeesDAO.getAllActiveEmployees();
		
		if(activeEmployeeList != null)
			session.setAttribute("activeEmployeeList", activeEmployeeList);
		else
			session.setAttribute("activeEmployeeList", null);
		
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_ActiveEmployeesView.jsp");
	}
	
	public void allInactiveEmployeesDisplay(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
