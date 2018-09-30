package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.SearchForEmployeeDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;

public class SearchForEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String show = request.getParameter("show");
		
		if(search != null) {
			//validation goes here
			if(true) {
				Collection<Employee> employeeSearchList01 = SearchForEmployeeDAO.getEmployeesForSearch(search);
				
				HttpSession session = request.getSession();
				session.setAttribute("employeeSearchList01", employeeSearchList01);
				request.setAttribute("value", "notNull");
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_HRManager_SearchForEmployees.jsp");
				rd.forward(request, response);
			} else {
				
			}
		} else if (show != null)
			showSingleEmpDetails(request, response);
	}
	
	private void showSingleEmpDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<Employee> employeeSearchList01 = (ArrayList<Employee>) session.getAttribute("employeeSearchList01");
		String employeeId = request.getParameter("employeeId");
		
		Employee emp = null;
		for(Employee employee: employeeSearchList01) {
			if(employee.getPersonId().equals(employeeId))
				emp = employee;
		}
		
		request.setAttribute("searchEmp", emp);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_HRManager_SingleEmployeeViewForSearch.jsp");
		rd.forward(request, response);
	}
}
