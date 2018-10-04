<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="DAO_SERVICE.inventory_management.RetreiveDAO"%>
<%@page import="DAO_SERVICE.inventory_management.OtherMethods"%>
<%@page import="POJO_MODEL.inventory_management.headRequestItem"%>
<%@page import="POJO_MODEL.inventory_management.BranchItem"%>
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
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveItemServlet" style="color:white">Item List</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveHistoryServlet" style="color:white">History</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/RetreiveRequestServlet" style="color:white">Show Branch Request</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/IM_ShowWarehouse-Branch.jsp" style="color:white">Warehouse - Branch</a>
                            <a class="dropdown-item" href="/SampathBankWebPortal/IM_GenerateReports.jsp" style="color:white">Generate Reports</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" title="Click to See Leave Related Options">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Leave Request Inquiry</a>
                        <div class="dropdown-menu nav-dropdown">
                            <a class="dropdown-item" href="#" style="color:white">Apply for Leave</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">Leave History</a>
                            <a class="dropdown-item" href="#" style="color:white">Leave Status</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" style="color:white">Leave Analysis</a>
                            <a class="dropdown-item" href="#" style="color:white">File a Complaint</a>
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







    <div class="container" style="overflow: auto;min-height: 500px">
			
		
                
            <div class="container">
                            <br>
                            <div class="row justify-content-center">
                                                <div class="col-12 col-md-10 col-lg-8">
                                                    <form class="card card-sm" action="RetreiveSearchRequestServlet" method="post">
                                                        <div class="card-body row no-gutters align-items-center">
                                                            <div class="col-auto">
                                                                
                                                            </div>
                                                            <!--end of col-->
                                                            <div class="col">
                                                                <input class="form-control form-control-lg form-control-borderless" type="search" name="search" placeholder="Enter any field name you want to search">
                                                            </div>
                                                            <!--end of col-->
                                                            <div class="col-auto">
                                                                <button class="btn btn-lg btn-success" type="submit">Search</button>
                                                            </div>
                                                            <!--end of col-->
                                                        </div>
                                                    </form>
                                                </div>
                                                <!--end of col-->
                            </div>
                        </div>    
                <br>
                <% 
                if(session.getAttribute("IM_RequestList")==null){
                	JOptionPane pane = new JOptionPane("Please Login to continue",JOptionPane.WARNING_MESSAGE);  
            		JDialog dialog = pane.createDialog("Error");  
            		dialog.setAlwaysOnTop(true);  
            		dialog.show(); 
            		
            		request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                ArrayList<headRequestItem> reqList = (ArrayList<headRequestItem>) session.getAttribute("IM_RequestList") ;
               if(reqList.isEmpty()){
            	   
            	   %>
            	   <p align="center"> No requests Available <p>
            	<%
               }
               else{
                %>
              <table style="border-weight:thick;border-color:black;text-align:center;" cellpadding="20px" cellspacing="20px" align="center" border="1"  >
        		
        		<tr>
                    <th style="font=weight:bold;">Request ID</th>
                    <th style="font=weight:bold;">Head UsernName</th>
                    <th style="font=weight:bold;">Branch</th>
                    <th style="font=weight:bold;">Item Name </th>
                    <th style="font=weight:bold;">Quantity Needed</th>
                    <th style="font=weight:bold;">Quantity Available</th>
                   	<th style="font=weight:bold;">Approve Request</th>
                   	<th style="font=weight:bold;">Disapprove Request</th>
                    
                  </tr>
                  
                  <%
                  
                  int x=0;
                  while(x<reqList.size()){
                	  headRequestItem h1 = reqList.get(x);
                          	
                  %>
                  
                  <tr>
                  		<td><%=h1.getRefId() %></td>
                  		<td><%=h1.getHeadUsername() %></td>
                  		<td><%=h1.getBranch() %> </td>
                  		<td><%=h1.getItemName() %></td>
                  		<td><%=h1.getReqAmount() %></td>
                  		<td><%=RetreiveDAO.getItemQty(h1.getItemId()) %></td>
                  		
                  		<td >
                  		<form action="ApproveItemServlet" method="post">
                  		<input name="request" value=<%=x %> type="hidden">
                  		<input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#fd4f00;display: inline-table;" value="Approve">
                  		</form>
                  		
                  		
                  		
                  		</td>
                  		<td>
                  		<form action="DisapproveItemServlet" method="post">
                  		<input name="request" value=<%=x %> type="hidden">
                  		<input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:120px;border-weight:10px;border-color:#fd4f00;display: inline-table;" value="Disapprove">
                  		</form>
                  		</td>
                  </tr>
                   
                   
                   <%
                   x++;
                   } 
                   
                   }%>
        		</table>
               
               <br><br>
	
			
			
			
			
			
			
							
		
		
		
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