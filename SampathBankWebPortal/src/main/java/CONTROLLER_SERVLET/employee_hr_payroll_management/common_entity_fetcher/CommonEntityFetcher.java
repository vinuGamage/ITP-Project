package CONTROLLER_SERVLET.employee_hr_payroll_management.common_entity_fetcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo_model.employee_hr_payroll_management.managers.CommonEntityManager;

public class CommonEntityFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("username").equals("abc") && request.getParameter("password").equals("123")) {
			CommonEntityManager cem = new CommonEntityManager();
			
			HttpSession session = request.getSession();
			session.setAttribute("cem", cem);
			
			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HrRecruitmentOfficer_RecruitAnEmployee.jsp");
//			response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/trials/EHPM_HrRecruitmentOfficer_RecruitAnEmployee.jsp");
		}
	}
}