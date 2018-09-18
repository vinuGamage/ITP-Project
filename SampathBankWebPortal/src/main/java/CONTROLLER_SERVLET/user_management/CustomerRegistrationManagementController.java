package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_SERVICE.user_management.CustomerRegistrationManagementDAO;
import POJO_MODEL.user_management.Customer;

import java.util.Collection;

public class CustomerRegistrationManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String var =  request.getParameter("var");
    	
    	if(var.equals("getAllRequests"))
    		displayAllRequests(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void displayAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Collection<Customer> requestList = CustomerRegistrationManagementDAO.getAllRequests();
		
		if(requestList != null) {
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('There are no Online Customer Registration requests!');");
			out.println("location='/SampathBankWebPortal/jsp/user_management/UM_CustomerRegistrationSecondary.jsp';");
			out.println("</script>");
		}
	}
}
