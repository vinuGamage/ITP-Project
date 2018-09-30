package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.user_management.LoginDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.inventory_management.loginUser;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.GenericLogin;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.OnlineSecurityKey;
import POJO_MODEL.user_management.RegistrationDates;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CommonEntityManager commonEntityManager = CommonEntityManager.getInstance();
		commonEntityManager.initializeDepartments();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
			
		GenericLogin<Boolean, String, Customer, Employee> genericLogin = LoginDAO.checkLoginCredentials(username, password, commonEntityManager);
		HttpSession session = request.getSession();
		
		
		if(genericLogin.getFound()) {
			if(genericLogin.getType().equals("customer")) {
				Customer customer = genericLogin.getCustomer();
				customer.displayCustomer();
				out.print("CUSTOMER");
				
			} else if(genericLogin.getType().equals("employee")) {
				Employee employee = genericLogin.getEmployee();
				session.setAttribute("employee", employee);
				session.setAttribute("commonEntityManager", commonEntityManager);
				employee.displayEmployee();
				
				if(employee.getEmployeeType().equals("inventory manager")) {
					loginUser lu = new loginUser(employee.getOnlineAccount().getUsername(), employee.getBranch().getBranchAddress().getAddressCity());
					session.setAttribute("IM_user", lu);
				} else if(employee.getEmployeeType().equals("head")) {
					loginUser lu = new loginUser(employee.getOnlineAccount().getUsername(), employee.getBranch().getBranchAddress().getAddressCity());
					session.setAttribute("IM_user", lu);
				}
				
				response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp");
			} else {
				PrintWriter out1 = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('NOT FOUND1');");
				out.println("</script>");
				response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_Login.jsp");
			}
		} else {
			PrintWriter out2 = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('NOT FOUND2');");
			out.println("</script>");
			response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_Login.jsp");
		}
	}
}