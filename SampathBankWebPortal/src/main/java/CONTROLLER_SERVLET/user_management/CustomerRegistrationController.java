package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.user_management.CustomerRegistrationDAO;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.user_management.generators.RegistrationPINGenerator;

public class CustomerRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitInitialRegistration = request.getParameter("submitInitialRegistration");
		String submitSecondaryegistration = request.getParameter("submitSecondaryegistration");
		String submitThirtaryegistration = request.getParameter("submitThirtaryegistration");
		
		if(submitInitialRegistration != null)
			initialRegistration(request, response);
		else if(submitSecondaryegistration != null)
			secondaryRegistration(request, response);
		else if(submitThirtaryegistration != null)
			thirtaryRegistration(request, response);
	}
	
	public void initialRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String regNic = request.getParameter("regNic");
		String regDOB = request.getParameter("regDOB");
		String regZIP = request.getParameter("regZIP");
		String regPersonalEmail = request.getParameter("regPersonalEmail");
		String regAccountNo = request.getParameter("regAccountNo");
		
		//Validations go here
		if(true) {
			Date regDOB01 = DateConverter.getSqlDateFromString(regDOB);
			int regZIP01 = Integer.parseInt(regZIP);
			int regAccountNo01 = Integer.parseInt(regAccountNo);
			
			String custId = CustomerRegistrationDAO.checkData(regNic, regDOB01, regZIP01, regPersonalEmail, regAccountNo01);
			
			if(custId != null) {
				if(CustomerRegistrationDAO.checkOnlineAccount(custId)) {
					if(CustomerRegistrationDAO.checkRegistrationRequest(custId)) {
						int regPin = RegistrationPINGenerator.generateRegPin();
						HttpSession session = request.getSession();
						if(CustomerRegistrationDAO.checkForTempOnlinePinData(custId)) {
							if(CustomerRegistrationDAO.insertOnlinePinData(custId, regPin)) {
//EMAILLLLLLLLLLLLLLLLLLLLLLLLLL
								EmailClient.sendMail(regPersonalEmail, "Sampath Bank Online Registration PIN!", "Your Registration Pin is : " +  regPin);
								session.setAttribute("custId", custId);
								
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Your email will receive the pin required for the next step, immediately!');");
								out.println("location='/SampathBankWebPortal/jsp/user_management/UM_CustomerRegistrationSecondary.jsp';");
								out.println("</script>");
							} else {
								System.out.println("some error 0001");
							}
						} else {
							if(CustomerRegistrationDAO.updateOnlinePinData(custId, regPin)) {
//EMAILLLLLLLLLLLLLLLLLLLLLLLLLL
								EmailClient.sendMail(regPersonalEmail, "Sampath Bank Online Registration PIN!", "Your Registration Pin is : " +  regPin);
								session.setAttribute("custId", custId);
								
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Your email will receive the pin required for the next step, immediately!');");
								out.println("location='/SampathBankWebPortal/jsp/user_management/UM_CustomerRegistrationSecondary.jsp';");
								out.println("</script>");
							} else {
								System.out.println("some error 0002");
							}
						}
					} else {
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('You have already made a request for a online account!');");
						out.println("location='/SampathBankWebPortal/jsp/user_management/UM_Login.jsp';");
						out.println("</script>");
					}
				} else {
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('You Already have an online account!');");
					out.println("location='/SampathBankWebPortal/jsp/user_management/UM_Login.jsp';");
					out.println("</script>");
				}
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('You Do Not have an Account with Us, Please meet with the nearest bank to open an account!');");
				out.println("location='/SampathBankWebPortal/UM_Homepage_Common.jsp';");
				out.println("</script>");
			}
			
			
		} else {
			
		}
	}

	public void secondaryRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String regOnlinePin = request.getParameter("regOnlinePin");
		
		//validation goes here
		if(true) {
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("custId");
			
			if(CustomerRegistrationDAO.validateOnlineRegPin(custId, Integer.parseInt(regOnlinePin))) {
				response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_CustomerRegistrationThirtary.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Entered PIN is not Correct!');");
				out.println("location='/SampathBankWebPortal/jsp/user_management/UM_CustomerRegistrationSecondary.jsp';");
				out.println("</script>");
			}
		} else {
			
		}
	}
	
	public void thirtaryRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String question01 = request.getParameter("question01");
		String answer01 = request.getParameter("answer01");
		String question02 = request.getParameter("question02");
		String answer02 = request.getParameter("answer02");
		
		//validation goes here
		if(true) {
			HttpSession session = request.getSession();
			String custId = (String)session.getAttribute("custId");
			
			if(CustomerRegistrationDAO.storeRequestForCustomerOnlineAccount(custId, question01, answer01, question02, answer02)) {
				if(CustomerRegistrationDAO.deleteFromTempOnlineRegPins(custId)) {
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Your request for an online account has been submitted! If you do not receive the credentials within 1 week, please kindly visit the nearest sampath bank!');");
					out.println("location='/SampathBankWebPortal/UM_Homepage_Common.jsp';");
					out.println("</script>");
				} else {
					System.out.println("some error 0004");
				}
			} else {
				System.out.println("some error 0003");
			}
		} else {
			
		}
	}
}