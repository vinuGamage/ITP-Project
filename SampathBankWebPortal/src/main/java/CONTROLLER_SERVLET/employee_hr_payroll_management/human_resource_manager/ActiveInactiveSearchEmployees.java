package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public void allActiveEmployeesDisplay(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void allInactiveEmployeesDisplay(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
