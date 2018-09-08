package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import POJO_MODEL.employee_hr_payroll_management.Employee;

public class LeaveHandlingEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xyz = request.getParameter("xyz");
		if(xyz.equals("retrieveBase")) {
			retrieveLeaveDetails(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void retrieveLeaveDetails(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		
	}

}
