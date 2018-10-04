<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="POJO_MODEL.employee_hr_payroll_management.Employee"%>
<%@ page import="java.util.*" %>
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
        <title>Salary Calculator</title>
		<%
			Employee employee = (Employee) session.getAttribute("employee");
		
			if(employee == null)
				response.sendRedirect("/SampathBankWebPortal/jsp/user_management/UM_Login.jsp");
		%>
		<script type="text/javascript">
		  function autoFill() {
			  var date = new Date();
			  var currentDate = date.toISOString().slice(0,10);
		  }
		  
		  function updateTotalOT() {
			  var otHrs = document.getElementById('SalaryFormOvertime').value;
			  var otRt = document.getElementById('SalaryFormOvertimeRate').value;
			  
			  var totOt = parseFloat(otHrs) * parseFloat(otRt);
			  
			  if(isNaN(totOt)) {
				  alert('Only enter numerics for Overtime variables!');
			  } else {
				  document.getElementById('SalaryFormTotOT').value = totOt.toFixed(2);
			  }
		  }
		  
		  function updateTotTaxableInc(){
			  var monthly = parseFloat(document.getElementById('SalaryFormBasicSalaryPerMonth').value);
			  var otHrs = parseFloat(document.getElementById('SalaryFormOvertime').value);
			  var otRate = parseFloat(document.getElementById('SalaryFormOvertimeRate').value);
			  var carAllowance = parseFloat(document.getElementById('SalaryFormCarAllowance').value);
			  var bonus = parseFloat(document.getElementById('SalaryFormBonus').value);
			  
			  var totalTaxableInc = monthly + (otHrs * otRate) + carAllowance + (monthly * bonus / 100);
			  
			  if(isNaN(totalTaxableInc)) {
				  alert('Some field in "TAXABLE INCOME" set is wrong!');
			  } else {
				  document.getElementById('SalaryFormTotTaxableIncome').value = totalTaxableInc.toFixed(2);
			  }
		  }
		  
		  function updateTotNonTaxaInx() {
			  var days = parseFloat(document.getElementById('SalaryFormNonTaxSubAllowDays').value);
			  var rate = parseFloat(document.getElementById('SalaryFormNonTaxSubAllowRate').value);
			  var medical = parseFloat(document.getElementById('SalaryFormNonTaxMedical').value);
			  
			  var totalNonTaxableInc = (rate * days) + medical;
			  
			  if(isNaN(totalNonTaxableInc)) {
				  alert('Some field in "NON TAXABLE INCOME" set is wrong!');
			  } else {
				  document.getElementById('SalaryFormTotNonTaxableIncome').value = totalNonTaxableInc.toFixed(2);
			  }
		  }
		  
		  function updateTotDeductions() {
			  var epf = parseFloat(document.getElementById('SalaryFormEPF').value);
			  var medical = parseFloat(document.getElementById('SalaryFormMedical').value);
			  var loanRepay = parseFloat(document.getElementById('SalaryFormLoanRepayment').value);
			  var otherDeduct = parseFloat(document.getElementById('SalaryFormOtherDeductions').value);
			  
			  var totDeducts = epf + medical + loanRepay + otherDeduct;
			  
			  if(isNaN(totDeducts)) {
				  alert('Some field in "DEDUCTIONS" set is wrong!');
			  } else {
				  document.getElementById('SalaryFormTotDeductions').value = totDeducts.toFixed(2);
				  updateNetSalary();
			  }
		  }
		  
		  function updateNetSalary() {
			  var totTaxableInc = parseFloat(document.getElementById('SalaryFormTotTaxableIncome').value);
			  var taxR = parseFloat(document.getElementById('SalaryFormTax').value);
			  var nonTotTaxableInc = parseFloat(document.getElementById('SalaryFormTotNonTaxableIncome').value);
			  var totDeductions = parseFloat(document.getElementById('SalaryFormTotDeductions').value);
			  
			  var netSalary = ((totTaxableInc * (100 - taxR)) / 100 ) + nonTotTaxableInc - totDeductions;

			  document.getElementById('SalaryFormNetSalary').value = netSalary.toFixed(2);
		  }
		</script>
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
                        <a class="nav-link" href="#"><span class="fa fa-sign-in"></span> Sign Out</a>
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
                <%if(employee.getDesignation().getDesignation().equals("human resource manager")) {%>
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
                    <%} else if(employee.getDesignation().getDesignation().equals("admin")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                    	<a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                    	<div class="dropdown-menu nav-dropdown">
	                        <a class="dropdown-item" href="#" style="color:white">admin job 01</a>
	                        <div class="dropdown-divider"></div>
	                        <a class="dropdown-item" href="#" style="color:white">admin job 02</a>
	                        <div class="dropdown-divider"></div>
	                        <a class="dropdown-item" href="#" style="color:white">admin job 03</a>
	                        <div class="dropdown-divider"></div>
	                        <a class="dropdown-item" href="#" style="color:white">admin job 04</a>
	                        <div class="dropdown-divider"></div>
	                        <a class="dropdown-item" href="#" style="color:white">admin job 05</a>
                    	</div>
                	</li>
                    <%} else if(employee.getDesignation().getDesignation().equals("normal employee")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="#" style="color:white">normal employee job 01</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">normal employee job 02</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">normal employee job 03</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">normal employee job 04</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">normal employee job 05</a>
                        </div>
                    </li>
                   	<%} else if(employee.getDesignation().getDesignation().equals("user manager")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/CustomerRegistrationManagementController?var=getAllRequests" style="color:white">Online Customer Account Management</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/SampathBankWebPortal/jsp/user_management/UM_CustomerManager_SearchForCustomer.jsp" style="color:white">Search For Customers</a>
                        </div>
                    </li>
                    <%} else if(employee.getDesignation().getDesignation().equals("head")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveBranchItemServlet" style="color:white">Request Item from Warehouse</a>
                        </div>
                    </li>
                    <%} else if(employee.getDesignation().getDesignation().equals("inventory manager")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveItemServlet" style="color:white">Item List</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveHistoryServlet" style="color:white">History</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveRequestServlet" style="color:white">Show Branch Request</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/IM_ShowWarehouse-Branch.jsp" style="color:white">Warehouse - Branch</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/IM_GenerateReports.jsp" style="color:white">Generate Reports</a>
                        </div>
                    </li>
                    <%} else if(employee.getDesignation().getDesignation().equals("transaction manager")) {%>
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="/SampathBankWebPortal/showAllTransactDetailsServlet" style="color:white">Display  Transaction</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/approveTransactservlet" style="color:white">Approve Transactions</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/TM_empGenerateReports.jsp" style="color:white">Generate Reports</a>
                        </div>
                    </li>
                    <%} %>
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
                            <a class="dropdown-item" href="#" style="color:white">Calculate Salary</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">Pay Slip</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Skills Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Skills Management</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="#" style="color:white">Action</a>
                            <a class="dropdown-item" href="#" style="color:white">Another action</a>
                            <a class="dropdown-item" href="#" style="color:white">Something else here</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">Separated link</a>
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
		    <li class="breadcrumb-item">Salary Inquiry</li>
		    <li class="breadcrumb-item active" aria-current="page">SCalculate Salary</li>
		  </ol>
		</nav>

        <div class="container-fluid" style="margin-bottom: 100px; height: 1100px;">
            <br><h3>Salary Calculator</h3>
            <div class="container" style="margin-top: 50px">
            
<!-- 
	FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
 -->
                <form action="#" method="#">
                    <div style="float: left; margin-right: 5px;">
                        <div style="width: 550px; float: left; padding: 7px; border-width: 1px; border-style: solid; border-color: #FD4F00; margin-bottom: 5px; background-color: lightgrey;">
                            <h5>Employee ID</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px;">
                                <div class="col">
                                	<input type="text" class="form-control" id="SalaryFormID" name="empId" value="<%=employee.getPersonId() %>" disabled>
                                </div>
                            </div>
                        </div>

                        <div style="width: 550px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both">
                            <h5>TAXABLE INCOME</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormBasicSalaryPerMonth">Monthly Based Fixed: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormBasicSalaryPerMonth" name="basicSalaryPerMonth" title="####">
                                </div>
                            </div>
                            <div style="border-width: 1px; border-style: solid; border-color: #FD4F00;">
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
	                                <label class="col-5 col-form-label" for="SalaryFormBasicSalaryPerMonth">Overtime Hrs: *</label>
	                                <div class="col-5">
	                                    <input type="text" class="form-control" id="SalaryFormOvertime" name="overTimeHrs" title="####">
	                                </div>
	                            </div>
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
	                                <label class="col-5 col-form-label" for="SalaryFormBasicSalaryPerMonth">Overtime R: *</label>
	                                <div class="col-5">
	                                    Rs. <input type="text" class="form-control" id="SalaryFormOvertimeRate" name="overTimeRate" title="####" onchange="updateTotalOT();">
	                                </div>
	                            </div>
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px; background-color: lightgrey;">
	                                <label class="col-5 col-form-label" for="SalaryFormTotOT">Total OT: </label>
	                                <div class="col-5">
	                                    Rs. <input type="text" class="form-control" id="SalaryFormTotOT" title="####" disabled>
	                                </div>
	                            </div>
	                        </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormBasicSalaryPerMonth">Car Allowance: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormCarAllowance" name="carAllowance" title="####">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormBasicSalaryPerMonth">Bonus: *</label>
                                <div class="col-5">
                                    % <input type="text" class="form-control" id="SalaryFormBonus" name="bonus" title="####" onchange="updateTotTaxableInc();">
                                </div>
                            </div>
                            <div style="border-width: 1px; border-style: solid; border-color: #FD4F00;">
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
	                                <label class="col-5 col-form-label" for="SalaryFormTax">Tax: *</label>
	                                <div class="col-5">
	                                    % <input type="text" class="form-control" id="SalaryFormTax" name="tax" title="####">
	                                </div>
	                            </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px; background-color: lightgrey;">
                                <label class="col-5 col-form-label" for="SalaryFormTotTaxableIncome">Total Taxable Income: </label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormTotTaxableIncome" title="####" disabled>
                                </div>
	                        </div>
                        </div>
                    </div>

                    <div style="float: left;">
                        <div style="width: 550px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; margin-bottom: 5px;">
                            <h5>NON-TAXABLE INCOME</h5>
                            <div style="border-width: 1px; border-style: solid; border-color: #FD4F00;">
                            <label class="col col-form-label">Non taxable subsistence allowance</label>
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
	                                <label class="col-5 col-form-label" for="SalaryFormNonTaxSubAllowDays">No of days: *</label>
	                                <div class="col-5">
	                                    <input type="text" class="form-control" id="SalaryFormNonTaxSubAllowDays" name="nonTaxSubAllowDays" title="####">
	                                </div>
	                            </div>
	                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
	                                <label class="col-5 col-form-label" for="SalaryFormNonTaxSubAllowRate">Rate: *</label>
	                                <div class="col-5">
	                                    Rs. <input type="text" class="form-control" id="SalaryFormNonTaxSubAllowRate" name="nonTaxSubAllowRate" title="####">
	                                </div>
	                            </div>
	                        </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormNonTaxMedical">Non taxable medical: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormNonTaxMedical" name="nonTaxMedical" title="####" onchange="updateTotNonTaxaInx();">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px; background-color: lightgrey;">
                                <label class="col-5 col-form-label" for="SalaryFormTotNonTaxableIncome">Total Non Taxable Income: </label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormTotNonTaxableIncome" title="####" disabled>
                                </div>
	                        </div>
                        </div>

                        <div style="width: 550px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #FD4F00; clear: both; margin-bottom: 5px;">
                            <h5>DEDUCTIONS</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormEPF">EPF: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormEPF" name="epf" title="####">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormMedical">Medical: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormMedical" name="medical" title="####">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormLoanRepayment">Loan Repayments: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormLoanRepayment" name="loanRepayment" title="####">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="SalaryFormOtherDeductions">Other Deductions: *</label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormOtherDeductions" name="otherDeductions" title="####" onchange="updateTotDeductions();">
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px; background-color: lightgrey;">
                                <label class="col-5 col-form-label" for="SalaryFormTotDeductions">Total Deductions: </label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormTotDeductions" title="####" disabled>
                                </div>
	                        </div>
	                        <div class="form-group row" style="padding: 4px; padding-left: 16px; background-color: lightgrey;">
                                <label class="col-5 col-form-label" for="SalaryFormNetSalary">Net Salary: </label>
                                <div class="col-5">
                                    Rs. <input type="text" class="form-control" id="SalaryFormNetSalary" title="####" disabled>
                                </div>
	                        </div>
                        </div>
                        <div style="clear: both; float: right; margin-top: 20px;">
			                <div class="form-group row">
			                    <div>
			                    	<input type="reset" value="Reset" style="background-color: white; border-radius: 10px; color: black; border-color: #FD4F00; border-width: 2px; border-style: solid; font-size: 22px; margin-right:10px;"/>
			                    </div>
			                </div>
			            </div>
                    </div>
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