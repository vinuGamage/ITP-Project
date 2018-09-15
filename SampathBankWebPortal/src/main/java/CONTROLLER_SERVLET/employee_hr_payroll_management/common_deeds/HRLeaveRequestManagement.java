package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.HRLeaveRequestManagementDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;

public class HRLeaveRequestManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lmanage = request.getParameter("lmanage");

		
		if(lmanage.equals("getAllLeaveRequests"))
			getAllLeaveRequestForManagement(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leaveShowBtn = request.getParameter("leaveShowBtn");
		String leaveGrantBtn = request.getParameter("leaveGrantBtn");
		String leaveRejectBtn = request.getParameter("leaveRejectBtn");
		
		if(leaveShowBtn != null)
			showSingleLeaveForManagement(request, response);
		else if(leaveGrantBtn != null)
			GrantLeaveForManagement(request, response);
		else if(leaveRejectBtn != null)
			RejectLeaveForManagement(request, response);
	}

	public void getAllLeaveRequestForManagement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("managementLeaveRequestList");
		Collection<LeaveRequest> managementLeaveRequestList = HRLeaveRequestManagementDAO.getAllLeaveRequestsForManagement();
		
		if(managementLeaveRequestList != null) {
			System.out.println("aaaaaa");
			session.setAttribute("managementLeaveRequestList", managementLeaveRequestList);
			
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_LeaveRequestManagement_LeaveRequestList.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('There are currently, No submitted leave requests to manage.');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}
	
	public void showSingleLeaveForManagement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Collection<LeaveRequest> managementLeaveRequestList = (ArrayList<LeaveRequest>) session.getAttribute("managementLeaveRequestList");
		int leaveRequestId = Integer.parseInt(request.getParameter("leaveRequestId"));
		LeaveRequest leaveR = null;
		
		for(LeaveRequest lr: managementLeaveRequestList) {
			if(lr.getLeaveRequestId() == leaveRequestId) {
				leaveR = lr;
				break;
			}
		}
		
		if(leaveR != null) {
			request.setAttribute("leaveR", leaveR);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee_hr_payroll_management/EHPM_HRManager_ViewLeave.jsp");
			rd.forward(request, response);
		} else {
			
		}
	}
	
	public void GrantLeaveForManagement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int leaveRequestId = Integer.parseInt(request.getParameter("leaveRequestId"));
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		Collection<LeaveRequest> managementLeaveRequestList = (ArrayList<LeaveRequest>) session.getAttribute("managementLeaveRequestList");
		LeaveRequest leaveR = null;
		
		for(LeaveRequest lr: managementLeaveRequestList) {
			if(lr.getLeaveRequestId() == leaveRequestId) {
				leaveR = lr;
				break;
			}
		}
			
		boolean bool = HRLeaveRequestManagementDAO.grantLeave(leaveR, employee.getPersonId());
		
		if(bool) {
			session.removeAttribute("managementLeaveRequestList");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Leave Granted Successfully!');");
			out.println("location='/SampathBankWebPortal/HRLeaveRequestManagement?lmanage=getAllLeaveRequests';");
			out.println("</script>");
		} else {
			
		}
	}
	
	public void RejectLeaveForManagement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int leaveRequestId = Integer.parseInt(request.getParameter("leaveRequestId"));
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		boolean bool = HRLeaveRequestManagementDAO.rejectLeave(leaveRequestId, employee.getPersonId());
		
		if(bool) {
			session.removeAttribute("managementLeaveRequestList");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Leave Rejected Successfully!');");
			out.println("location='/SampathBankWebPortal/HRLeaveRequestManagement?lmanage=getAllLeaveRequests';");
			out.println("</script>");
		} else {
			
		}
	}
}