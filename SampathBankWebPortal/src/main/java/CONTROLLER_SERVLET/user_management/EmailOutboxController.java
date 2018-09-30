package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.user_management.EmailDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.user_management.Email;

/**
 * Servlet implementation class EmailOutboxController
 */
public class EmailOutboxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee =  (Employee) session.getAttribute("employee");
		
		Collection<Email> outboxRetrieve = EmailDAO.outboxRetrieve(employee.getCompanyEmail());
		
		session.setAttribute("outboxRetrieve", outboxRetrieve);
		response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_EmailOutbox.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = request.getParameter("view");
		String delete = request.getParameter("delete");
		
		if(view != null)
			viewEmail(request, response);
		else if(delete != null)
			deleteEmail(request, response);
	}
	
	private void viewEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<Email> outboxRetrieve = (ArrayList<Email>) session.getAttribute("outboxRetrieve");
		
		int emailId = Integer.parseInt(request.getParameter("emailId"));
		
		Email em = null;
		for(Email email: outboxRetrieve) {
			if(email.getEmailId() == emailId) {
				em = email;
				break;
			}
		}
		
		request.setAttribute("email", em);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/user_management/UM_SingleEmail.jsp");
		rd.forward(request, response);
	}

	private void deleteEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<Email> outboxRetrieve = (ArrayList<Email>) session.getAttribute("outboxRetrieve");
		
		int emailId = Integer.parseInt(request.getParameter("emailId"));
		
		if(EmailDAO.deleteFromOutbox(emailId)) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email deleted from outbox!');");
			out.println("location='/SampathBankWebPortal/EmailOutboxController';");
			out.println("</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Email was not deleted from outbox!');");
			out.println("location='/SampathBankWebPortal/EmailOutboxController';");
			out.println("</script>");
		}
		
		
	}
}