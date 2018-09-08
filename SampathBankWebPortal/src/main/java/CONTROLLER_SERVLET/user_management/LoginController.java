package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.user_management.LoginDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;
import POJO_MODEL.user_management.Contact;
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

		if(username.equals("abc") && password.equals("123")) {
			Employee employee = new Employee();
			
			employee.setPersonId("EMPL000001");
			employee.setName("Isuru", "Dananjaya", "Samarasekara", "S.A.M.");
			employee.setAddress("83/2", "Piliyandala Road", "Maharagama", "Western", 10280);
			employee.setNic("961370213v");
			employee.setDateOfBirth(DateConverter.getSqlDateFromString("1996-05-16"));
			employee.setRegistrationDates(new RegistrationDates(DateConverter.getSqlDateFromString("2018-09-07"), DateConverter.getSqlDateFromString("2018-09-07")));
			employee.setGender(commonEntityManager.getGender(1));
			employee.setNationality(commonEntityManager.getNationality(1));
			employee.setBranch(commonEntityManager.getBranch("BRAN000001"));
			employee.setOnlineSecurityKey(new OnlineSecurityKey(2, "abcd4567f8"));
			employee.setPermission(commonEntityManager.getPermission(3));
			employee.setOnlineAccount(new OnlineAccount("EMON000001", "EMPL000001", "abc"));
			employee.getContactList().add(new Contact("EMPL000001", "0112844830", "home"));
			employee.getContactList().add(new Contact("EMPL000001", "0772841580", "mobile"));
			employee.setDepartment(commonEntityManager.getDepartment("DEPT000001"));
			employee.setCompanyEmail("isuruCompany@company.com");
			employee.setDesignation(commonEntityManager.getDesignation(1));
			employee.setEmployeeType("normal employee");
			employee.displayEmployee();
			
			HttpSession session = request.getSession();
			session.setAttribute("employee", employee);
		}
		
		
//		GenericLogin<Boolean, String, Customer, Employee> genericLogin = LoginDAO.checkLoginCredentials(username, password, commonEntityManager);
//		
//		if(genericLogin.getFound()) {
//			if(genericLogin.getType().equals("customer")) {
//				Customer customer = genericLogin.getCustomer();
//				customer.displayCustomer();
//				out.print("CUSTOMER");
//				
//			} else if(genericLogin.getType().equals("employee")) {
//				Employee employee = genericLogin.getEmployee();
//				employee.displayEmployee();
//				out.print("EMPLOYEE");
//			} else {
//				out.println("NOT FOUND1");
//			}
//		} else {
//			out.println("NOT FOUND2");
//		}
	}
}