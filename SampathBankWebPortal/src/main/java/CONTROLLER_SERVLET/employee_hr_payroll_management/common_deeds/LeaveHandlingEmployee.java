package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.LeaveManagementEmployeeDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.employee_hr_payroll_management.LeaveRequest;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;

public class LeaveHandlingEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xyz = request.getParameter("xyz");
		String leaveSubmit = request.getParameter("leaveSubmit");
		String leaveRejectSeconded = request.getParameter("leaveRejectSeconded");
		String leaveSubmitSeconded = request.getParameter("leaveSubmitSeconded");
		if(xyz != null && xyz.equals("retrieveBase")) {
			retrieveLeaveDetails(request, response);
		} else if(xyz != null && xyz.equals("retrieveHistory")) {
			retrieveLeaveHistory(request, response);
		} else if(leaveSubmit != null) {
			initialLeaveRequestSubmit(request, response);
		} else if(leaveRejectSeconded != null) {
			leaveRequestReject(request, response);
		} else if(leaveSubmitSeconded != null) {
			secondaryLeaveRequestSubmit(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void retrieveLeaveDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		LeaveDetails leaveDetails = LeaveManagementEmployeeDAO.getLeaveDetails(employee.getPersonId());
		
		if(leaveDetails != null) {
			request.setAttribute("leaveDetails", leaveDetails);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave.jsp");
			rd.forward(request, response);
		} else {
			
		}
	}
	
	public void initialLeaveRequestSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String leaveStart = request.getParameter("leaveStart");
		String leaveEnd = request.getParameter("leaveEnd");
		String leaveType = request.getParameter("leaveType");
		String leaveReviewSpeed = request.getParameter("leaveReviewSpeed");
		String leaveDescription = request.getParameter("leaveDescription");
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setEmployeeId(employee.getPersonId());
		leaveRequest.setLeaveType(leaveType);
		leaveRequest.setLeaveDescription(leaveDescription);
		leaveRequest.setLeaveRequestedDate(DateConverter.getCurrentSqlDate());
		leaveRequest.setLeaveStartDate(DateConverter.getSqlDateFromString(leaveStart));
		leaveRequest.setLeaveFinishDate(DateConverter.getSqlDateFromString(leaveEnd));
		leaveRequest.setLeaveReviewSpeed(leaveReviewSpeed);
		
		session.setAttribute("leaveRequest", leaveRequest);
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Apply_For_Leave.jsp");
	}
	
	public void leaveRequestReject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.removeAttribute("leaveRequest");
		
		retrieveLeaveDetails(request, response);
	}
	
	public void secondaryLeaveRequestSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		LeaveRequest leaveRequest = (LeaveRequest)session.getAttribute("leaveRequest");
		
		boolean bool = LeaveManagementEmployeeDAO.recordInitialLeaveRequest(leaveRequest);
		
		if(bool) {
			session.removeAttribute("leaveRequest");
			session.removeAttribute("leaveDetails");
			response.sendRedirect("/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveHistory");
		} else {
			System.out.println("NONO");
		}
	}
	
	public void retrieveLeaveHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		Collection<LeaveRequest> requestHistory = null;
		requestHistory = LeaveManagementEmployeeDAO.getLeaveHistory(employee.getPersonId());
		
		if(requestHistory == null)
			session.setAttribute("requestHistory", null);
		else
			session.setAttribute("requestHistory", requestHistory);
		
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Leave_History.jsp");
	}
}
