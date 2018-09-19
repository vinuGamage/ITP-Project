package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.PrimaryKeyGeneratorDAO;
import DAO_SERVICE.user_management.CustomerRegistrationManagementDAO;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.employee_hr_payroll_management.generators.KeyFix;
import POJO_MODEL.employee_hr_payroll_management.generators.OnlineAccountGenerator;
import POJO_MODEL.employee_hr_payroll_management.generators.OnlineSecurityKeyGenerator;
import POJO_MODEL.user_management.Customer;
import POJO_MODEL.user_management.OnlineAccount;
import POJO_MODEL.user_management.OnlineSecurityKey;
import POJO_MODEL.user_management.SecurityVariables;

import java.util.Collection;
import java.util.ArrayList;

public class CustomerRegistrationManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String var =  request.getParameter("var");
    	
    	if(var.equals("getAllRequests"))
    		displayAllRequests(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String displayRequest = request.getParameter("displayRequest");
		String approveRequest = request.getParameter("approveRequest");
		String rejectRequest = request.getParameter("rejectRequest");
		
		if(displayRequest != null)
			displaySingleRequestDetails(request, response);
		else if(approveRequest != null)
			approveSingleRequest(request, response);
		else if(rejectRequest != null) {
			rejectSingleRequest(request, response);
		}
	}

	public void displayAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Collection<Customer> requestList = CustomerRegistrationManagementDAO.getAllRequests();
		
		if(requestList != null) {
			HttpSession session = request.getSession();
			session.setAttribute("requestList", requestList);
			
			response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_CustomerManager.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('There are no Online Customer Registration requests!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
			out.println("</script>");
		}
	}

	public void displaySingleRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<Customer> requestList = 	(ArrayList<Customer>) session.getAttribute("requestList");
		
		if(requestList != null) {
			String requestId = request.getParameter("requestId");
			
			Customer cust = null;
			for(Customer c: requestList) {
				if(c.getPersonId().equals(requestId)) {
					cust = c;
					break;
				}
			}
			if(cust != null) {
				request.setAttribute("customer", cust);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/user_management/UM_CustomerManager_DisplayCustomerRegistrationRequest.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("error.");
			}
		} else {
			
		}
	}
	
	public void approveSingleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<Customer> requestList = 	(ArrayList<Customer>) session.getAttribute("requestList");
		
		if(requestList != null) {
			String requestId = request.getParameter("requestId");
			
			Customer cust = null;
			for(Customer c: requestList) {
				if(c.getPersonId().equals(requestId)) {
					cust = c;
					break;
				}
			}
			
			if(cust != null) {
				OnlineSecurityKey on = new OnlineSecurityKey();
				on.setOnlineSecurityId(PrimaryKeyGeneratorDAO.onlineSecurityKeyGenerator());
				on.setOnlineSecurityKey(OnlineSecurityKeyGenerator.generateOnlineSecurityKey());
				cust.setOnlineSecurityKey(on);

				String onlineCustomerId = CustomerRegistrationManagementDAO.getOnlineCustomerCredentialsPrimaryKey();
				boolean a = CustomerRegistrationManagementDAO.updateOnlineCustomerCredentialsPrimaryKey(KeyFix.Char10Increment(onlineCustomerId));
				
				if(a) {
					String username = cust.getName().getFirstName().toUpperCase();
					String password = OnlineAccountGenerator.passwordGenerator();
					SecurityVariables sv = CustomerRegistrationManagementDAO.getSecurityVariables(cust);
					
					if(sv != null) {
						boolean s = CustomerRegistrationManagementDAO.insertIntoOnlineSecurityKeyTable(cust);
						if(s) {
							boolean d = CustomerRegistrationManagementDAO.insertIntoOnlineCustomerCredentials(onlineCustomerId, cust, username, password, sv);
							if(d) {
								boolean f = CustomerRegistrationManagementDAO.updateCustomerOnPersonTable(cust);
								if(f) {
									boolean g = CustomerRegistrationManagementDAO.deleteFromCustomerRegistrationRequests(cust);
									if(g) {
										System.out.println("successs");
										String content = 	"Your request for an online account has been approved.\n" + 
															"\tUsername: " + username + "\n" + 
															"\tPassword: " + password + "\n" +
															"\tOnline Security Key: " + cust.getOnlineSecurityKey().getOnlineSecurityKey();
										EmailClient.sendMail(cust.getPersonalEmail(), "Credentials For Online Account on Sampath Bank", content);
										
										PrintWriter out = response.getWriter();
										out.println("<script type=\"text/javascript\">");
										out.println("alert('Successfully Approved!');");
										out.println("location='/SampathBankWebPortal/CustomerRegistrationManagementController?var=getAllRequests';");
										out.println("</script>");
									} else {
										System.out.println("Unsuccessfull");
									}
								} else {
									System.out.println("error");
								}
							} else {
								System.out.println("error");
							}
						} else {
							System.out.println("error");
						}
					} else {
						System.out.println("error");
					}
				 } else {
					 System.out.println("error");
				 }
			} else {
				System.out.println("error.");
			}
		}
	}
	
	public void rejectSingleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Collection<Customer> requestList = 	(ArrayList<Customer>) session.getAttribute("requestList");
		
		if(requestList != null) {
			String requestId = request.getParameter("requestId");
			
			Customer cust = null;
			for(Customer c: requestList) {
				if(c.getPersonId().equals(requestId)) {
					cust = c;
					break;
				}
			}
			
			if(cust != null) {
				boolean g = CustomerRegistrationManagementDAO.deleteFromCustomerRegistrationRequests(cust);
				if(g) {
					System.out.println("successs");
					String content = 	"Your request for an online account has been rejected.\n" + 
										"\tPlease contact your associated branch for more details.\n" + 
										"\t\tAssociated Branch: " + cust.getBranch().getBranchAddress().getFullAddress();
					EmailClient.sendMail(cust.getPersonalEmail(), "Regarding You Request for an Online Account", content);
					
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Successfully Rejected!');");
					out.println("location='/SampathBankWebPortal/CustomerRegistrationManagementController?var=getAllRequests';");
					out.println("</script>");
				} else {
					System.out.println("Unsuccessfull");
				}
			} else {
				System.out.println("error");
			}
		} else {
			System.out.println("ad");
		}
	}
}
