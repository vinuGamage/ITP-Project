package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.common_deeds.LeaveManagementEmployeeDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.converters.StringsToNumbers;

public class LeaveHandlingEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xyz = request.getParameter("xyz");
		
		String leaveSubmit = request.getParameter("leaveSubmit");
		String leaveRejectSeconded = request.getParameter("leaveRejectSeconded");
		String leaveSubmitSeconded = request.getParameter("leaveSubmitSeconded");
		String viewLeaveReq = request.getParameter("viewLeaveReq");
		
		if(xyz != null && xyz.equals("retrieveBase")) {
			retrieveLeaveDetails(request, response);
		} else if(xyz != null && xyz.equals("retrieveHistory")) {
			retrieveLeaveHistory(request, response);
		} else if(leaveSubmit != null) {
			initialLeaveRequestSubmit(request, response);
		} else if(leaveRejectSeconded != null) {
			leaveRequestReject(request, response);
		} else if(viewLeaveReq != null) {
			showLeaveReq(request, response);
		}
		/*else if(leaveSubmitSeconded != null) {
			secondaryLeaveRequestSubmit(request, response);
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String onlineSecKey = request.getParameter("onlineSecKey");
		
		if(onlineSecKey.equals(employee.getOnlineSecurityKey().getOnlineSecurityKey())) {
			secondaryLeaveRequestSubmit(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Online Security Key is Invalid!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave_Confirmation.jsp';");
			out.println("</script>");
		}
	}
	
	public void retrieveLeaveDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		if(LeaveManagementEmployeeDAO.getWhetherSubmitted(employee.getPersonId())) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You have a pending leave request, hence, you cannot apply for another.');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
		
		else {
			LeaveDetails leaveDetails = LeaveManagementEmployeeDAO.getLeaveDetails(employee.getPersonId());
			
			if(leaveDetails != null) {
				session.setAttribute("leaveDetails", leaveDetails);
				
				response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('For some reason, your leave details were not found.');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
				out.println("</script>");
			}
		}
	}
	
	public void initialLeaveRequestSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String leaveDuration = request.getParameter("leaveDuration");

		HttpSession session = request.getSession();
		LeaveDetails leaveDetails = (LeaveDetails) session.getAttribute("leaveDetails");
		
		if(StringsToNumbers.getIntFromString(leaveDuration) > leaveDetails.getNoOfLeavesLeft()) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please input a valid duration which is less than leaves left.');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave.jsp';");
			out.println("</script>");
		} else {
			String leaveStart = request.getParameter("leaveStart");
			String leaveType = request.getParameter("leaveType");
			String leaveReviewSpeed = request.getParameter("leaveReviewSpeed");
			String leaveDescription = request.getParameter("leaveDescription");
			
			Employee employee = (Employee) session.getAttribute("employee");
			session.removeAttribute("leaveDetails");
			
			LeaveRequest leaveRequest = new LeaveRequest();
			leaveRequest.setEmployeeId(employee.getPersonId());
			leaveRequest.setLeaveType(leaveType);
			leaveRequest.setLeaveDescription(leaveDescription);
			leaveRequest.setLeaveRequestedDate(DateConverter.getCurrentSqlDate());
			leaveRequest.setLeaveStartDate(DateConverter.getSqlDateFromString(leaveStart));
			leaveRequest.setLeaveDuration(StringsToNumbers.getIntFromString(leaveDuration));
			leaveRequest.setLeaveReviewSpeed(leaveReviewSpeed);
			
			session.setAttribute("leaveRequest", leaveRequest);
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave_Confirmation.jsp");
		}
	}
	
	public void leaveRequestReject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("leaveDetails");//
		session.removeAttribute("leaveRequest");
		
		retrieveLeaveDetails(request, response);
	}
	
	public void secondaryLeaveRequestSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		LeaveRequest leaveRequest = (LeaveRequest)session.getAttribute("leaveRequest");
		
		boolean bool = LeaveManagementEmployeeDAO.recordInitialLeaveRequest(leaveRequest);
		
		session.removeAttribute("leaveRequest");
		session.removeAttribute("leaveDetails");
		if(bool) {
			response.sendRedirect("/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveHistory");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('For some unknown reason, leave submitting failed.');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}
	
	public void retrieveLeaveHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		Collection<LeaveRequest> leaveHistory = null;
		leaveHistory = LeaveManagementEmployeeDAO.getLeaveHistory(employee.getPersonId());
		
		if(leaveHistory == null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You have not yet requested for any leaves.');");
			out.println("location='/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveBase';");
			out.println("</script>");
		}
		else {
			session.setAttribute("leaveHistory", leaveHistory);
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Leave_History.jsp");
		}
	}

	public void showLeaveReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<LeaveRequest> leaveHistory = (ArrayList<LeaveRequest>) session.getAttribute("leaveHistory");
		String leaveRequestId = request.getParameter("leaveRequestId");
		LeaveRequest leaveReq = null;
		
		for(LeaveRequest lr: leaveHistory) {
			if(lr.getLeaveRequestId() == StringsToNumbers.getIntFromString(leaveRequestId)) {
				leaveReq = lr;
				break;
			}
		}
		
		request.setAttribute("leaveReq", leaveReq);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_ViewLeave.jsp");
		rd.forward(request, response);
	}
}
