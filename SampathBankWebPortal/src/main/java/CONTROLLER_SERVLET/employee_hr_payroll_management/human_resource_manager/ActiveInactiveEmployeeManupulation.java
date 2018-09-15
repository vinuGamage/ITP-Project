package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

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

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.ActiveInactiveSearchEmployeesDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.InactiveEmployee;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;

/**
 * Servlet implementation class ActiveInactiveEmployeeManupulation
 */
public class ActiveInactiveEmployeeManupulation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anotherDeed = request.getParameter("anotherDeed");
		
		if(anotherDeed.equals("activeView")) {
			viewSingleActiveEmployee(request, response);
		} else if(anotherDeed.equals("inactiveView")) {
			viewSingleInactiveEmployee(request, response);
		} else if(anotherDeed.equals("removeOnlineAccount")) {
			removeOnlineAccount(request, response);
		} else if(anotherDeed.equals("inactivate")) {
			inactivateEmployee(request, response);
		}
	}
	
	public void viewSingleActiveEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<Employee> activeEmployeeList = (ArrayList<Employee>) session.getAttribute("activeEmployeeList");
		String employeeId = request.getParameter("employeeId");
		
		Employee activeEmp = null;
		for(Employee emp: activeEmployeeList) {
			if(emp.getPersonId().equals(employeeId)) {
				activeEmp = emp;
				break;
			}
		}
		
		session.setAttribute("activeEmp", activeEmp);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_hr_payroll_management/EHPM_HRManager_ActiveSingleEmployeeView.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_ActiveSingleEmployeeView.jsp");
	}
	
	public void viewSingleInactiveEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<InactiveEmployee> inactiveEmployeeList = (ArrayList<InactiveEmployee>) session.getAttribute("inactiveEmployeeList");
		String inEmployeeId = request.getParameter("inEmployeeId");
		
		InactiveEmployee inEmp = null;
		for(InactiveEmployee inemployee: inactiveEmployeeList) {
			if(inemployee.getPersonId().equals(inEmployeeId)) {
				inEmp = inemployee;
				break;
			}
		}
		
		session.setAttribute("inactiveEmp", inEmp);
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_InactiveSingleEmployeeView.jsp");
	}
	
	public void removeOnlineAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String onlineSecKey = request.getParameter("onlineSecKey");
		
		if(onlineSecKey.equals(employee.getOnlineSecurityKey().getOnlineSecurityKey())) {
			Employee activeEmp = (Employee) session.getAttribute("activeEmp");
			boolean bool = ActiveInactiveSearchEmployeesDAO.removeEmployeeOnlineAccount(activeEmp);
			
			if(bool) {
				session.removeAttribute("activeEmp");
				response.sendRedirect("/SampathBankWebPortal/ActiveInactiveSearchEmployees?deed=allActive");
			} else {
				
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Online Security Key is Invalid!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}
	
	public void inactivateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String onlineSecKey = request.getParameter("onlineSecKey");
		
		if(onlineSecKey.equals(employee.getOnlineSecurityKey().getOnlineSecurityKey())) {
			Employee activeEmp = (Employee) session.getAttribute("activeEmp");
			String reason = request.getParameter("reason");
			boolean bool = ActiveInactiveSearchEmployeesDAO.removeEmployeeOnlineAccount(activeEmp);
			
			if(bool) {
				boolean bool1 = ActiveInactiveSearchEmployeesDAO.inactivateEmployee(activeEmp, reason);
				
				if(bool1) {
/*					String subject = "Inactivation of Employee: " + activeEmp.getName().getFullName();
					String content = "As the Human Resource Manager of Sampath Bank, I am sorry to inform you that you are no longer an employee at Sampath Bank.\n"
							+ "Reason for inactivation: " + reason + ".\n"
							+ "We are thankfull for your services!";
					EmailClient.sendMail(activeEmp.getPersonalEmail(), subject, content);*/
					
					session.removeAttribute("activeEmp");
					response.sendRedirect("/SampathBankWebPortal/ActiveInactiveSearchEmployees?deed=allActive");
				} else {
					System.out.println("111");
				}
			} else {
				System.out.println("222");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Online Security Key is Invalid!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}
}
