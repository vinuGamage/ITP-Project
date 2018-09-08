package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_SERVICE.user_management.LoginDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.GenericLogin;

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
		
		if(genericLogin.getFound()) {
			if(genericLogin.getType().equals("customer")) {
				Customer customer = genericLogin.getCustomer();
				customer.displayCustomer();
				out.print("CUSTOMER");
				
			} else if(genericLogin.getType().equals("employee")) {
				Employee employee = genericLogin.getEmployee();
				employee.displayEmployee();
				out.print("EMPLOYEE");
			} else {
				out.println("NOT FOUND1");
			}
		} else {
			out.println("NOT FOUND2");
		}
	}
}