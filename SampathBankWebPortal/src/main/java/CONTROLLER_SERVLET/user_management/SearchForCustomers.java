package CONTROLLER_SERVLET.user_management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_SERVICE.employee_hr_payroll_management.human_resource_manager.SearchForEmployeeDAO;
import DAO_SERVICE.user_management.CustomerSearchDAO;
import POJO_MODEL.employee_hr_payroll_management.Employee;
import POJO_MODEL.user_management.Customer;

public class SearchForCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String display = request.getParameter("display");
		
		if(search != null) {
			//validation goes here
			if(true) {
				Collection<Customer> custList = CustomerSearchDAO.customerSearching(search);
				
				HttpSession session = request.getSession();
				session.setAttribute("custList", custList);
				request.setAttribute("var", "here");
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/user_management/UM_CustomerManager_SearchForCustomer.jsp");
				rd.forward(request, response);
			} else {
				
			}
		} else if (display != null)
			displayCustomer(request, response);
	}
	
	private void displayCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Collection<Customer> custList = (ArrayList<Customer>) session.getAttribute("custList");
		String custId = request.getParameter("custId");
		
		Customer cus = null;
		for(Customer customer: custList) {
			if(customer.getPersonId().equals(custId)) {
				cus = customer;
				break;
			}
		}
		
		request.setAttribute("cus", cus);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/user_management/UM_CustomerManager_SearchSingleCustomerView.jsp");
		rd.forward(request, response);
	}
}
