package controller_servlet.employee_hr_payroll_management.common_entity_fetcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_service.RetrieveDAO;

public class CommonEntityFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("username").equals("abc") && request.getParameter("password").equals("123"))
			RetrieveDAO.initializeCommonPojoClasses();
	}

}
