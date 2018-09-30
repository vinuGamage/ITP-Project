package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.user_management.EmailDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.user_management.Email;

public class EmailComposeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//Validation goes here
		if(true) {
			if(EmailDAO.checkForReceiver(receiver)) {
				System.out.println("I'm here01");
				HttpSession session = request.getSession();
				Employee employee = (Employee) session.getAttribute("employee");
				Email email = new Email(employee.getCompanyEmail(), receiver, subject, content);
				
				if(EmailDAO.storeComposeEmail(email)) {
					System.out.println("I'm here02");
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Company email was successfully sent!');");
					out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
					out.println("</script>");
				} else {
					System.out.println("I'm here03");
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('For some reason the email was not sent!');");
					out.println("location='/SampathBankWebPortal/jsp/user_management/UM_EmailCompose.jsp';");
					out.println("</script>");
				}
			} else {
				System.out.println("I'm here04");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Database does not contain the receivers company email. Please input a valid email!');");
				out.println("location='/SampathBankWebPortal/jsp/user_management/UM_EmailCompose.jsp';");
				out.println("</script>");
			}
		} else {
			
		}
		
	}

}
