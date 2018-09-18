package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

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

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.HRUpdateDetailsDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.UpdateRequestManagement;
import POJO_MODEL.user_management.Updation;

public class UpdateProfileDetailsHRSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upmanage = request.getParameter("upmanage");
		
		if(upmanage.equals("retrieveAll"))
			getAllUpdateRequests(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateShow = request.getParameter("updateShow");
		String updateApprove = request.getParameter("updateApprove");
		String updateReject = request.getParameter("updateReject");
		
		if(updateShow != null)
			showUpdateRequest(request, response);
		else if(updateApprove != null)
			approveUpdate(request, response);
		else if(updateReject != null)
			rejectUpdate(request, response);
	}
	
	public void getAllUpdateRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Collection<UpdateRequestManagement> list = HRUpdateDetailsDAO.getAllUpdationRequests();

		if(list != null) {
			for(UpdateRequestManagement urm: list) {
				urm.initiateDiffStuff();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_UpdateRequests.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('There are no update requests at this moment.');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}
	
	public void showUpdateRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<UpdateRequestManagement> list = (ArrayList<UpdateRequestManagement>)session.getAttribute("list");
		String employeetId = request.getParameter("employeetId");
		
		UpdateRequestManagement updateRM= null;
		for(UpdateRequestManagement urm: list) {
			if(urm.getUpdation().getPersonId().equals(employeetId)) {
				updateRM = urm;
				break;
			}
		}
		
		if(updateRM != null) {
			request.setAttribute("URM", updateRM);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_ViewSingleUpdateRequest.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("something wrong... this cannot be happening.");
		}
	}
	
	public void approveUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<UpdateRequestManagement> list = (ArrayList<UpdateRequestManagement>)session.getAttribute("list");
		String employeetId = request.getParameter("employeetId");
		
		UpdateRequestManagement updateRM= null;
		for(UpdateRequestManagement urm: list) {
			if(urm.getUpdation().getPersonId().equals(employeetId)) {
				updateRM = urm;
				break;
			}
		}
		
		if(updateRM != null) {
			if(HRUpdateDetailsDAO.updateEmployeeInfo(updateRM)) {
				session.removeAttribute("list");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Employee Details Successfully Updated.');");
				out.println("location='/SampathBankWebPortal/UpdateProfileDetailsHRSide?upmanage=retrieveAll';");
				out.println("</script>");
			} else {
				
			}
		} else {
			
		}
	}
	
	public void rejectUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<UpdateRequestManagement> list = (ArrayList<UpdateRequestManagement>)session.getAttribute("list");
		String employeetId = request.getParameter("employeetId");
		
		UpdateRequestManagement updateRM= null;
		for(UpdateRequestManagement urm: list) {
			if(urm.getUpdation().getPersonId().equals(employeetId)) {
				updateRM = urm;
				break;
			}
		}
		
		if(updateRM != null) {
			if(HRUpdateDetailsDAO.deleteFromUpdateRequest(updateRM.getUpdation().getPersonId())) {
				session.removeAttribute("list");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Rejected.');");
				out.println("location='/SampathBankWebPortal/UpdateProfileDetailsHRSide?upmanage=retrieveAll';");
				out.println("</script>");
			} else {
				
			}
		} else {
			
		}
	}
}
