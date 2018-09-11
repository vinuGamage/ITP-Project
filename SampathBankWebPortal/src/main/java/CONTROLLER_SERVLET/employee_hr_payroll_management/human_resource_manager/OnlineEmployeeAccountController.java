package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.PrimaryKeyGeneratorDAO;
import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.OnlineEmployeeAccountManagementDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.generators.OnlineAccountGenerator;
import POJO_MODEL.employee_hr_payroll_management.generators.OnlineSecurityKeyGenerator;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.OnlineSecurityKey;

/**
 * Servlet implementation class OnlineEmployeeAccountController
 */
public class OnlineEmployeeAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String abc = request.getParameter("abc");
		if(abc.equals("check")) {
			showAllNewEmployees(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		HttpSession session = request.getSession();
		Collection<Employee> newEmployeeList = (ArrayList<Employee>) session.getAttribute("newEmployeeList");
		
		Employee emp = new Employee();
		
		for(Employee empl:  newEmployeeList) {
			if(empl.getPersonId().equalsIgnoreCase(employeeId)) {
				emp = empl;
				break;
			}
		}
		
		if(emp != null) {
			OnlineAccount onlineEmp = OnlineAccountGenerator.getOnlineAccount(emp);
			OnlineSecurityKey onlineSec = new OnlineSecurityKey();
			onlineSec.setOnlineSecurityId(PrimaryKeyGeneratorDAO.onlineSecurityKeyGenerator());
			onlineSec.setOnlineSecurityKey(OnlineSecurityKeyGenerator.generateOnlineSecurityKey());
			
			emp.setOnlineSecurityKey(onlineSec);
			emp.setOnlineAccount(onlineEmp);
			
			boolean bool = OnlineEmployeeAccountManagementDAO.createEmployeeOnlineAccount(emp);

			System.out.println(bool);
			if(bool) {
				PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Employee Online Account Successfully Created!.');");
			   out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			   out.println("</script>");
			} else {
				response.sendRedirect("asd");
			}
		}
	}
	
	public void showAllNewEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Collection<Employee> newEmployeeList = OnlineEmployeeAccountManagementDAO.getAllNewEmployees();
		
		HttpSession session = request.getSession();
		session.setAttribute("newEmployeeList", newEmployeeList);
		
		response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_CreateOnlineEmployeeAccounts.jsp");
	}
}
