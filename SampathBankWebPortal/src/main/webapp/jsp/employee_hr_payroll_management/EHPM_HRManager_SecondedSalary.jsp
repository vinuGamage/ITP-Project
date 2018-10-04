<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="POJO_MODEL.employee_hr_payroll_management.Employee, POJO_MODEL.employee_hr_payroll_management.Salary"%>
<%@ page import="java.util.*, java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/SampathBankWebPortal/resources/css&js&jquery/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="/SampathBankWebPortal/resources/css&js&jquery/customized.css" type="text/css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <title>Employee Salary Secondary</title>
		<%
			Employee employee = (Employee) session.getAttribute("employee");
		
			if(employee == null || !employee.getDesignation().getDesignation().equals("human resource manager"))
				response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_Login.jsp");
			
			Salary salary = (Salary) session.getAttribute("salary");
			if(salary == null)
				response.sendRedirect("/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_InitiateSalary.jsp");
			
			DecimalFormat df = new DecimalFormat("#.00");
		%>

    </head>

    <body>
        <nav class="navbar fixed-top navbar-expand-md navbar-dark fixed-stuff">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp" title="Go to Employee Homepage">EmpHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_ViewProfile.jsp" title="View Profile">MyProfile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SampathBankWebPortal/EmailInboxController" title="View Company Messages">MyInbox</a>
                    </li>
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp" title="Go to Employee Homepage">SampathEmpWeb</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item" title="Login">
                        <a class="nav-link" href="/SampathBankWebPortal/Logout"><span class="fa fa-sign-in"></span> Sign Out</a>
                    </li>
                </ul>
            </div>
        </nav>

        <header class="page-header" id="header01">
            <div class="header-mid">
                <a href="#" title="Go to Sampath Web Site">
                    <div class="container-fluid img-div">
                        <img src="/SampathBankWebPortal/resources/images/sampathbanklogo/SampathBankLogo01.png" alt="" class="logo">
                    </div>
                </a>
                <div style=" float: right">
                    <div class="container-fluid img_profile_div">
                        <img src="/SampathBankWebPortal/resources/images/ProfilePlaceholder.png" alt="" class="pro-pic">
                    </div>
                    <div class="container-fluid" style="float: right; clear: both;" >
                        <a href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_ViewProfile.jsp">Mr. <%=employee.getName().getFirstName()%><br/>
                        <%=employee.getName().getLastName() %></a>
                    </div>
                </div>
            </div>

            <div class="container-fluid" style="margin-top:10px;">
                <ul class="nav nav-pills nav-fill nav-justified nav-header">
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_RecruitAnEmployee.jsp" style="color:white">Recruit an Employee</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/OnlineEmployeeAccountController?abc=check" style="color:white">Create Employee Online Account</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/SampathBankWebPortal/ActiveInactiveSearchEmployees?deed=allActive" style="color:white">Active Employees</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/ActiveInactiveSearchEmployees?deed=inActive" style="color:white">Inactive Employees</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_SearchForEmployees.jsp" style="color:white">Search for Employees</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/SampathBankWebPortal/HRLeaveRequestManagement?lmanage=getAllLeaveRequests" style="color:white">Leave Request Management</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/UpdateProfileDetailsHRSide?upmanage=retrieveAll" style="color:white">Update Details Request Management</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_InitiateSalary.jsp" style="color:white">Salary Management</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Leave Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Leave Request Inquiry</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveBase" style="color:white">Apply for Leave</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/SampathBankWebPortal/LeaveHandlingEmployee?xyz=retrieveHistory" style="color:white">Leave History</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Salary Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Salary Inquiry</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_CalculateSalary.jsp" style="color:white">Calculate Salary</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Employee_Salary_Pay_Slip_PDF.jsp" style="color:white">Pay Slip</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Documentation Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Documents & Reports</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_HRManager_AllEmployeeDetailsDocumentation.jsp" style="color:white">All Employee Details</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Mail Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Mailing System</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/EmailInboxController" style="color:white">Inbox</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/EmailOutboxController" style="color:white">Outbox</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/user_management/UM_EmailCompose.jsp" style="color:white">New Message</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Profile Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Profile Related</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_ViewProfile.jsp" style="color:white">Profile Details</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_UpdateProfile.jsp" style="color:white">Update Profile</a>
                        </div>
                    </li>
                </ul>
            </div>
        </header>

<!--
    BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY BODY
-->
		<nav aria-label="breadcrumb" class="breadcrumb-stuff">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="/SampathBankWebPortal/jsp/employee_hr_payroll_management/EHPM_Common_Employee_Homepage.jsp">EmpHome</a></li>
		    <li class="breadcrumb-item">Employee Duties</li>
		    <li class="breadcrumb-item active">Salary Management</li>
		    <li class="breadcrumb-item active" aria-current="page"><%=salary.getEmployeeId() %></li>
		  </ol>
		</nav>

        <div class="container-fluid" style="margin-bottom: 100px; height: 1000px;">
<!-- 
	FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
 -->
 
 		<h3 style="font-weight: bold;">Salary Initiation of Emp: <%=salary.getEmployeeId() %></h3>
					<div style="float: left; margin-right: 15px; margin-left: 22px;">
                        <div style="width: 700px; float: left; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; margin-bottom: 5px;">
                            <h5>TAXABLE INCOME</h5>
                            <table class="table table-borderless">
                            	<tbody>
                            		<tr>
                            			<th scope="row" style="width: 500px;">Monthly Salary: </th>
                            			<td><%=salary.gettMonthlySalary()%></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Overtime Hours: </th>
                            			<td><%=salary.gettOvertimeHrs() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Overtime Rate: </th>
                            			<td><%=salary.gettOvertimeRate() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Car Allowance: </th>
                            			<td><%=salary.gettCarAllowance() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Bonus: </th>
                            			<td><%=salary.gettBonus() %></td>
                            		</tr>
                            	</tbody>
                            </table>
                        </div>

                        <div style="backwidth: 700px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both; margin-bottom: 5px;">
                            <h5>NON-TAXABLE INCOME</h5>
                            <table class="table table-borderless">
                            	<tbody>
                            		<tr>
                            			<th scope="row" style="width: 500px;">Subsistence Allowance Days: </th>
                            			<td><%=salary.getNtSubsistenceAllowanceDays() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Subsistence Allowance Rate: </th>
                            			<td><%=salary.getNtSubsistenceAllowanceRate() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Medical: </th>
                            			<td><%=salary.getNtMedical() %></td>
                            		</tr>
                            	</tbody>
                            </table>
                        </div>
                        
                        <div style="backwidth: 700px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both">
                            <h5>DEDUCTIONS</h5>
                            <table class="table table-borderless">
                            	<tbody>
                            		<tr>
                            			<th scope="row" style="width: 500px;">EPF: </th>
                            			<td><%=salary.getdEpf() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Medical: </th>
                            			<td><%=salary.getdMedical() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Loan Repayments: </th>
                            			<td><%=salary.getdLoanRepayment() %></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Other Deductions: </th>
                            			<td><%=salary.getdOtherDeductions() %></td>
                            		</tr>
                            	</tbody>
                            </table>
                        </div>
                    </div>

                    <div style="float: left;">
						<div style="background-color: lightgrey; width: 700px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both; margin-bottom: 5px;">
                            <table class="table table-borderless">
                            	<tbody>
                            		<tr>
                            			<th scope="row" style="width: 500px;">Overtime Total: </th>
                            			<td><b><%=df.format(salary.getTotalOT()) %></b></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Total Taxable Income: </th>
                            			<td><b><%=df.format(salary.getTotalTaxableIncome()) %></b></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Total Non-Taxable Income: </th>
                            			<td><b><%=df.format(salary.getTotalNonTaxableIncome()) %></b></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Total Deductions: </th>
                            			<td><b><%=df.format(salary.getTotalDeductions()) %></b></td>
                            		</tr>
                            		<tr>
                            			<th scope="row">Tax upon Taxable Income: </th>
                            			<td><b><%=df.format(salary.getTax()) %></b></td>
                            		</tr>
                            	</tbody>
                            </table>
                        </div>
                        
                        <div style="width: 700px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both; margin-bottom: 5px;">
                            <table class="table table-borderless">
                            	<tbody>
	                   				<tr>
	                   					<th scope="row" style="width: 500px;">Net Salary: </th>
	                   					<td><b><%=df.format(salary.getNetSalary()) %></b></td>
	                  				</tr>
                            	</tbody>
                            </table>
                        </div>
                        <form action="/SampathBankWebPortal/SalaryInitiation" method="post">
		                	<input type="hidden" name="salarySeconded">
		 					<input type="submit" name="reject" value="Reject" style="background-color: white; border-radius: 10px; color: black; border-color: #FD4F00; border-width: 2px; border-style: solid; font-size: 22px; margin-right:10px;">
		 					<input type="submit" name="submit" value="Submit" style="background-color: white; border-radius: 10px; color: black; border-color: #FD4F00; border-width: 2px; border-style: solid; font-size: 22px; margin-right:20px;">
                		</form>
            		</div>
        </div>

        <!-- Footer -->
        <footer class="page-footer font-small blue pt-4 footer-all">
            <div class="container-fluid text-center text-md-left">
                <div class="row">
                    <div class="col-6 mt-md-0 mt-3 footer-all-stuff footer-legal-form-stuff" title="Our Legal Form">
                        <h5 class="text-uppercase">Legal Form</h5>
                        <p style="text-align: justify">A Public Limited Liability Company incorporated in Sri Lanka on 10th March 1986 under the Companies Act No 17 of 1982 and listed in the Colombo Stock Exchange. A licensed Commercial Bank under the Banking Act No 30 of 1988. Re-registered on 28th April 2008 under the Companies Act No 7 of 2007.</p>
                    </div>

                    <hr class="clearfix w-100 d-md-none pb-3">

                    <div class="col mb-md-0 mb-3 footer-all-stuff footer-other-stuff" title="Know About the Company">
                        <h5 class="text-uppercase">Company</h5>

                        <ul class="list-unstyled">
                            <li>
                                <a href="#!" style="color:white">Home</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">About Us</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Contact Us</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Privacy Policy</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col mb-md-0 mb-3 footer-all-stuff footer-other-stuff">
                        <h5 class="text-uppercase">Profile Related</h5>

                        <ul class="list-unstyled">
                            <li>
                                <a href="#!" style="color:white">View Profile</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Update Profile</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Update History</a>
                            </li>
                        </ul>

                    </div>

                    <div class="col mb-md-0 mb-3 footer-all-stuff footer-last-stuff" title="Act as a Customer">
                        <h5 class="text-uppercase">Customer Related</h5>

                        <ul class="list-unstyled">
                            <li>
                                <a href="#!" style="color:white">Transaction</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Loan Calculator</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Lease Calculator</a>
                            </li>
                            <li>
                                <a href="#!" style="color:white">Complaint</a>
                            </li>
                        </ul>

                    </div>
                </div>

                <!-- Copyright -->
                <div class="footer-copyright text-left py-1 footer_copyright" title="Disclaimer">© All Rights Reserved @2018 |
                    <a href="#" title="Owners/ Group"> ITP-2018-MLB-G3-10.</a> |
                    <a href="#" title="Privacy Policy"> Privacy Policy.</a>
                </div>
                <!-- Copyright -->
            </div>
            <!-- Footer Links -->

        </footer>
        <!-- Footer -->
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="/SampathBankWebPortal/resources/css&js&jquery/jquery-3.3.1.slim.min.js"></script>
        <script src="/SampathBankWebPortal/resources/css&js&jquery/popper.min.js"></script>
        <script src="/SampathBankWebPortal/resources/css&js&jquery/bootstrap.min.js"></script>
        <script src="/SampathBankWebPortal/resources/css&js&jquery/customized.js"></script>
    </body>
</html>