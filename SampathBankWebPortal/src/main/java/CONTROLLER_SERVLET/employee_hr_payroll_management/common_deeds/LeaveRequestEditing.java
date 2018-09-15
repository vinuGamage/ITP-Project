package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.common_deeds.LeaveManagementEmployeeDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.converters.StringsToNumbers;

/**
 * Servlet implementation class LeaveRequestEditing
 */
public class LeaveRequestEditing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String remove = request.getParameter("remove");
		
		if(remove != null) {
			deleteLeaveRequest(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void deleteLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String onlineSecKey = request.getParameter("onlineSecKey");
		
		if(employee.getOnlineSecurityKey().getOnlineSecurityKey().equals(onlineSecKey)) {
			String leaveRequestId = request.getParameter("leaveRequestId");
			int leaveRequestId01 = StringsToNumbers.getIntFromString(leaveRequestId);
			
			boolean bool = LeaveManagementEmployeeDAO.removeLeaveRequest(leaveRequestId01);
			
			if(bool) {
				session.removeAttribute("leaveHistory");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Leave Request Successfully Removed!');");
				out.println("location='/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveHistory';");
				out.println("</script>");
			} else {
				
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Online Security Key is Invalid!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Leave_History.jsp';");
			out.println("</script>");
		}
	}
}
