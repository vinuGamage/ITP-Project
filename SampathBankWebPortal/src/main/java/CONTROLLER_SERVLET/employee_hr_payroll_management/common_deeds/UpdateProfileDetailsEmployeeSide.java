package CONTROLLER_SERVLET.employee_hr_payroll_management.common_deeds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.common_deeds.UpdateProfileDetailsDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.user_management.Updation;

public class UpdateProfileDetailsEmployeeSide extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updatePassword = request.getParameter("updatePassword");
		String updateAddress = request.getParameter("updateAddress");
		String updatePersonalEmail = request.getParameter("updatePersonalEmail");
		String updateHomeContact = request.getParameter("updateHomeContact");
		String updateMobileContact = request.getParameter("updateMobileContact");
		
		if(updatePassword != null)
			updatePassword(request, response);
		else if(updateAddress != null)
			updateAddress(request, response);
		else if(updatePersonalEmail != null)
			updatePersonalEmail(request, response);
		else if(updateHomeContact != null)
			updateHomeContact(request, response);
		else if(updateMobileContact != null)
			updateMobileContact(request, response);
			
	}
	
	public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String updatedOldPassword = request.getParameter("updatedOldPassword");
		Employee employee = (Employee) session.getAttribute("employee");
		
		if(UpdateProfileDetailsDAO.checkOldPassword(employee.getPersonId(), updatedOldPassword)) {
			String updatedNewPassword = request.getParameter("updatedNewPassword");
			String updatedConfirmNewPassword = request.getParameter("updatedConfirmNewPassword");
			
			if(updatedOldPassword.equals(updatedNewPassword)) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('OldPassword and the New Password are identical! Please change.');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			} else if(updatedNewPassword.equals(updatedConfirmNewPassword)) {
				if(UpdateProfileDetailsDAO.updatePassword(employee.getPersonId(), updatedNewPassword)) {
					session.removeAttribute("employee");
					
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Updated Password Successfully! You will be redirect to the login page!');");
					out.println("location='/SampathBankWebPortal/jsp/user_management/UM_Login.jsp';");
					out.println("</script>");
				} else {
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('For some reason the updating of password failed!!');");
					out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
					out.println("</script>");
				}
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('New Password and the Confirmed Password does not match!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter the old password correctly!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
			out.println("</script>");
		}
	}
	
	public void updateAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String updateAddStreet01 = request.getParameter("updateAddStreet01");
		String updateAddStreet02 = request.getParameter("updateAddStreet02");
		String updateAddCity = request.getParameter("updateAddCity");
		String updateAddProvince = request.getParameter("updateAddProvince");
		String updateAddZip = request.getParameter("updateAddZip");
		
		int i = 0;
		Updation update = new Updation();
		
		if(!employee.getAddress().getAddressStreet01().equals(updateAddStreet01))
			update.setAddressStreet01(updateAddStreet01);
		else
			i++;
		
		if(employee.getAddress().getAddressStreet02() == null || employee.getAddress().getAddressStreet02().trim().length() == 0) {
			if(updateAddStreet02 != null && updateAddStreet02.trim().length() != 0)
				update.setAddressStreet02(updateAddStreet02);
			else
				i++;
		} else {
			if(!employee.getAddress().getAddressStreet02().equals(updateAddStreet02))
				update.setAddressStreet02(updateAddStreet02);
			else
				i++;
		}
		
		if(!employee.getAddress().getAddressCity().equals(updateAddCity))
			update.setAddressCity(updateAddCity);
		else
			i++;
		
		if(!employee.getAddress().getAddressProvince().equals(updateAddProvince))
			update.setAddressProvince(updateAddProvince);
		else
			i++;
		
		if(employee.getAddress().getAddressZIPCode() != Integer.parseInt(updateAddZip))
			update.setAddressZIP(Integer.parseInt(updateAddZip));
		else
			i++;
		
		if(i > 4) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Change atleast one field to successfully update!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
			out.println("</script>");
		} else {
			update.setPersonId(employee.getPersonId());
			
			if(UpdateProfileDetailsDAO.updateAddressRequest(update)) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Address saved successfully!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Address Failed for some reason!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			}
		}
	}

	public void updatePersonalEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String updatedPersonalEmail = request.getParameter("updatedPersonalEmail");
		
		int i = 0;
		Updation update = new Updation();
		
		if(!employee.getPersonalEmail().equals(updatedPersonalEmail)) {
			update.setPersonId(employee.getPersonId());
			update.setPersonalEmail(updatedPersonalEmail);
			
			if(UpdateProfileDetailsDAO.updatePersonalEmailRequest(update)) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Personal Email saved successfully!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Personal Email Failed for some reason!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Personal Email is not changed. Please enter a different Personal Email to send an update request to management!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
			out.println("</script>");
		}
	}

	public void updateHomeContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String updatedHomeContact = request.getParameter("updatedHomeContact");
		
		int i = 0;
		Updation update = new Updation();
		
		if(!employee.getHomeContact().equals(updatedHomeContact)) {
			update.setPersonId(employee.getPersonId());
			update.setHomeContact(updatedHomeContact);
			
			if(UpdateProfileDetailsDAO.updateHomeCotactRequest(update)) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Home Contact Number saved successfully!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Home Contact Number Failed for some reason!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Home Contact Number is not changed. Please enter a different Home Contact Number to send an update request to management!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
			out.println("</script>");
		}
	}

	public void updateMobileContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		String updatedMobileContact = request.getParameter("updatedMobileContact");
		
		int i = 0;
		Updation update = new Updation();
		
		if(!employee.getMobileContact().equals(updatedMobileContact)) {
			update.setPersonId(employee.getPersonId());
			update.setMobileContact(updatedMobileContact);
			
			if(UpdateProfileDetailsDAO.updateMobileCotactRequest(update)) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Mobile Contact Number saved successfully!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update Request for Mobile Contact Number Failed for some reason!');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
				out.println("</script>");
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Mobile Contact Number is not changed. Please enter a different Mobile Contact Number to send an update request to management!');");
			out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp';");
			out.println("</script>");
		}
	}
}
