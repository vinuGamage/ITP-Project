package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.HRUpdateDetailsDAO;
import POJO_MODEL.employee_hr_payroll_management.UpdateRequestManagement;

public class UpdateProfileDetailsHRSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upmanage = request.getParameter("upmanage");
		
		if(upmanage.equals("retrieveAll"))
			getAllUpdateRequests(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public void getAllUpdateRequests(HttpServletRequest request, HttpServletResponse response) {
		
		UpdateRequestManagement URM = HRUpdateDetailsDAO.getAllUpdationRequests();
		
		if(URM == null) {
			
		} else {
			
		}
	}
}
