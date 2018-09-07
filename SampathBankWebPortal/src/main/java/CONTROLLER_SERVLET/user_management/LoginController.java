package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("abc") && password.equals("123")) {
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HrRecruitmentOfficer_RecruitAnEmployee.jsp");
			CommonEntityManager commonEntityManager = CommonEntityManager.getInstance();
			if(commonEntityManager.getGenderList() == null)
				System.out.println("aaaa");
			else
				System.out.println("bbbb");
		}
		
	}
}