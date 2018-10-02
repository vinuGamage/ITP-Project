<%@page import="POJO_MODEL.transaction_management.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link type ="text/css" rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css" >
    <link type="text/css" rel="stylesheet" href="resources/css&js&jquery/customized.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" >
    <title>Common Employee Inventory</title>
    </head>

    <body>
        <nav class="navbar fixed-top navbar-expand-md navbar-dark fixed-stuff">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#" title="Go to Employee Homepage">EmpHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" title="Go to Customer Homepage">CustomerHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" title="View Profile">MyProfile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" title="View Company Messages">MyInbox</a>
                    </li>
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#" title="Go to Employee Homepage">SampathEmpWeb</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item" title="Sign Up">
                        <a class="nav-link" href="#"><span class="fa fa-user"></span> Sign Up</a>
                    </li>
                    <li class="nav-item" title="Login">
                        <a class="nav-link" href="#"><span class="fa fa-sign-in"></span> Login</a>
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
                        <img src="resources/images/ProfilePlaceholder.png" alt="" class="pro-pic">
                    </div>
                    <div class="container-fluid" style="float: right; clear: both;" >
                        <a href="">Mr. xxx xxx</a>
                    </div>
                </div>

            </div>

            <div class="container-fluid">
                <ul class="nav nav-pills nav-fill nav-justified nav-header">
                    <!--fixed-top-->
                    <li class="nav-item dropdown" title="Click to See Your Duties">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Employee Duties</a>
                            <div class="dropdown-menu nav-dropdown">
                              <a class="dropdown-item" href="/SampathBankWebPortal/showAllTransactDetailsServlet" style="color:white">Display Transaction</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/approveTransactservlet" style="color:white">Approve Transactions</a>
                            
                            <a class="dropdown-item" href="TM_empGenerateReports.jsp" style="color:white">Generate Reports</a>
                            
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Leave Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Leave Request Inquiry</a>
                        <div class="dropdown-menu nav-dropdown">
                              <a class="dropdown-item" href="/SampathBankWebPortal/showAllTransactDetailsServlet" style="color:white">Display Transaction</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/approveTransactservlet" style="color:white">Approve Transactions</a>
                            
                            <a class="dropdown-item" href="TM_empGenerateReports.jsp" style="color:white">Generate Reports</a>
                            
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Salary Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Salary Inquiry</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="#" style="color:white">Calculate Salary</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">Salary History</a>
                            <a class="dropdown-item" href="#" style="color:white">Next Salary Details</a>
                            <a class="dropdown-item" href="#" style="color:white">Personal Salary Details</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">File a Complaint</a>
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
                            <a class="dropdown-item" href="#" style="color:white">Inbox</a>
                            <a class="dropdown-item" href="#" style="color:white">Outbox</a>
                            <a class="dropdown-item" href="#" style="color:white">New Message</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Profile Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Profile Related</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="#" style="color:white">Profile Details</a>
                            <a class="dropdown-item" href="#" style="color:white">Update Profile</a>
                            <a class="dropdown-item" href="#" style="color:white">Change History</a>
                        </div>
                    </li>
                </ul>
            </div>

        </header>







        <div class="container" style="overflow: auto">
        <br>
			<div class="row">
   				 <div class="col-sm-8">
					<h3 align="left">Sampath Transactions</h3>
     
                           <table class="table-striped"  align="center" cellpadding="10%" style="font-size: 110%;color:#404350;margin-left:10px" > 
							<tr style ="font-size:115%;">
								<th>Transaction ID</th>
								<th>Debit Account</th>
								<th>Credit Account</th>
								<th>Date</th>
								<th>Amount</th>
								<th>Status</th>
								<th>Approve</th>
							</tr>
							<%
							ArrayList<Transaction> list = (ArrayList<Transaction>) session.getAttribute("allTransacts");
							
							
							int x =0;
							while(x<list.size()){
								Transaction t = list.get(x);
							
							%>
							<tr >
								<td align=center><%=t.getTid() %></td>
							<td align="center"><%=t.getAccountNo() %></td>
							<td align=center><%=t.getTaccountNo() %></td>
							<td align=center><%=t.getDate() %></td>
							<td align=center><%=t.getAmount() %></td>
							<td align="center"><%=t.getStatus() %></td>
							<td align="center">
								<form action="approveInterServlet" method="post">
									<input name="approve" type="hidden" value=<%=x %>>
									<input type="submit" value="Approve">
								</form>
							</td>
							</tr>
					
			
							<%
							x++;
							}
							%>
							
							
							
							</table>
							  <br><br>
					
				</div>
			
			
						
   				 <div class="col-sm-8">
					<h3 align="left">Other Bank Transactions</h3>
     	
                           <table class="table-striped"  align="center" cellpadding="10%" style="font-size: 110%;color:#404350;margin-left:10px" > 
							<tr style ="font-size:115%;">
								<th>Transaction ID</th>
								<th>Debit Account</th>
								<th>Credit Account</th>
								<th>Date</th>
								<th>Amount</th>
								<th>Status</th>
								<th>Approve</th>
							</tr>
							<%
							ArrayList<Transaction> list1 = (ArrayList<Transaction>) session.getAttribute("allIntraTransacts");
							
							
							int y =0;
							while(y<list1.size()){
								Transaction t = list1.get(y);
							
							%>
							<tr >
							<td align=center><%=t.getTid() %></td>
							<td align="center"><%=t.getAccountNo() %></td>
							<td align=center><%=t.getTaccountNo() %></td>
							<td align=center><%=t.getDate() %></td>
							<td align=center><%=t.getAmount() %></td>
							<td align="center"><%=t.getStatus() %></td>
							<td align="center">
								<form action="approveIntraServlet" method="post">
									<input name="approve1" type="hidden" value=<%=y %>>
									<input type="submit" value="Approve">
								</form>
							</td>
							</tr>
					
			
							<%
							y++;
							}
							%>
							
							
							
							</table>
							  <br><br>
					
				</div>
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
    <script src="resources/css&js&jquery/jquery-3.3.1.slim.min.js"></script>
    <script src="resources/css&js&jquery/popper.min.js"></script>
    <script src="resources/css&js&jquery/bootstrap.min.js"></script>
    </body>
</html>