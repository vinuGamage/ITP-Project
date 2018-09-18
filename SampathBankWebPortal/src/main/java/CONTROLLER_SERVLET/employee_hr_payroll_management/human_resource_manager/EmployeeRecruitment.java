package CONTROLLER_SERVLET.employee_hr_payroll_management.human_resource_manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.RegisterEmployeeDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.employee_hr_payroll_management.Validator.Validator;
import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;
import POJO_MODEL.employee_hr_payroll_management.exceptions.EmployeeRegistrationException;
import POJO_MODEL.employee_hr_payroll_management.managers.CommonEntityManager;

public class EmployeeRecruitment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empFirstName = request.getParameter("empFirstName");//
		String empMiddleName = request.getParameter("empMiddletName");//
		String empLastName = request.getParameter("empLastName");//
		String empOtherNames = request.getParameter("empOtherNames");//
		String empGender = request.getParameter("empGender");
		String empAddLine01 = request.getParameter("empAddLine01");//
		String empAddLine02 = request.getParameter("empAddLine02");//
		String empAddCity = request.getParameter("empAddCity");//
		String empAddProvince = request.getParameter("empAddProvince");//
		String empAddZip = request.getParameter("empAddZip");//
		String empHomeContact = request.getParameter("empHomeContact");
		String empMobileContact = request.getParameter("empMobileContact");
		String empPersonalEmail = request.getParameter("empPersonalEmail");//
		String empNic = request.getParameter("empNic");//
		String empNationality = request.getParameter("empNationality");//
		String empDob = request.getParameter("empDob");//
		String empBranch = request.getParameter("empBranch");
		String empDepartment = request.getParameter("empDepartment");
		String empDesignation = request.getParameter("empDesignation");
		String empPhyRegDate = request.getParameter("empPhyRegDate");//
		
		CommonEntityManager CEM = CommonEntityManager.getInstance();
		
		//Testing......
		boolean validated = false;
		try {
			validated = new Validator().validateEmployeeRegistration(empFirstName, empMiddleName, empLastName, empOtherNames, empGender, empAddLine01, 
					empAddLine02, empAddCity, empAddProvince, empAddZip, empHomeContact, empMobileContact, empPersonalEmail, empNic, empNationality, empDob, empBranch, 
					empDepartment, empDesignation, empPhyRegDate);
			
			System.out.println(validated);
			
			Employee regEmp = new Employee();
			
			regEmp.setName(empFirstName, empMiddleName, empLastName, empOtherNames);
			regEmp.setAddress(empAddLine01, empAddLine02, empAddCity, empAddProvince, Integer.parseInt(empAddZip));
			regEmp.setNic(empNic);
			regEmp.setDateOfBirth(DateConverter.getSqlDateFromString(empDob));
			regEmp.setPersonalEmail(empPersonalEmail);
			regEmp.setPhysicalRegistrationDate(DateConverter.getSqlDateFromString(empPhyRegDate));
			regEmp.setGender(CEM.getGender(empGender));
			regEmp.setNationality(CEM.getNationality(empNationality));
			regEmp.setBranch(CEM.getBranchByCity(empBranch));
			regEmp.setHomeContact(empHomeContact);
			regEmp.setMobileContact(empMobileContact);
			regEmp.setDepartment(CEM.getDepartmentByDepartmentNameAndBranch(empDepartment, regEmp.getBranch()));
			regEmp.setDesignation(CEM.getDesignationByName(empDesignation));
			
			if(regEmp.getDesignation().getDesignation().equalsIgnoreCase("normal employee"))
				regEmp.setEmployeeType("normal employee");
			else if(regEmp.getDesignation().getDesignation().equalsIgnoreCase("human resource manager"))
				regEmp.setEmployeeType("manager");
			else if(regEmp.getDesignation().getDesignation().equalsIgnoreCase("admin"))
				regEmp.setEmployeeType("admin");
			else if(regEmp.getDesignation().getDesignation().equalsIgnoreCase("user manager"))
				regEmp.setEmployeeType("normal employee");
			
			boolean bool = RegisterEmployeeDAO.regitserEmployee(regEmp);
			
			System.out.println(bool);
			if(bool) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Employee Successfully Recruited.');");
				out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp';");
				out.println("</script>");
			} else {
				response.sendRedirect("asd");
			}
		} catch (EmployeeRegistrationException e) {
			System.out.println(e.getDescription());
			PrintWriter out = response.getWriter();
			String error = e.getDescription();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('" + error + "');");
			   out.println("location='/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_RecruitAnEmployee.jsp';");
			   out.println("</script>");
		}
	}
}
