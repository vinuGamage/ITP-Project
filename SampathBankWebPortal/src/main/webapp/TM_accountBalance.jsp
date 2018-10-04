<%@page import="POJO_MODEL.transaction_management.Transaction"%>
<%@page import="DAO_SERVICE.transaction_management.retreiveDAO"%>
<%@page import="POJO_MODEL.transaction_management.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css&js&jquery/customized.css" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>pin2</title>
</head>
<body>

  <nav class="navbar fixed-top navbar-expand-md navbar-dark fixed-stuff" >
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#" title="Go to Employee Homepage">Customer Home</a>
                    </li>
                    
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#" title="Go to Employee Homepage">Sampath Web Portal</a>
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
                        <a href="">Mr. xxx xx</a>
                    </div>
                </div>

            </div>

            <div class="container-fluid">
                <ul class="nav nav-pills nav-fill nav-justified nav-header">
                    <!--fixed-top-->
                    <li class="nav-item dropdown" title="Click to go to Homepage">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: #FD4F00">Home</a>
                            
                    </li>
                    <li class="nav-item dropdown" title="Click to See About Us">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">About Us</a>
                        
                    </li>
                    <li class="nav-item dropdown" title="Click to Contact Us">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Contact Us</a>
                        
                    </li>
                    <li class="nav-item dropdown" title="Click to See Available Jobs ">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Careers</a>
                        
                    </li>
                    <li class="nav-item dropdown" title="Click to See News">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">News</a>
                        
                    </li>
                    <li class="nav-item dropdown" title="Click to See Branches">
                        <a class="nav-link nav-change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; background-color: #FD4F00">Branch Network</a>
                        
                    </li>
                </ul>
            </div>

        </header>







        <div class="container-fluid" style="height: 850px ">
            
            <div class="row">
                <div class="col-md-2" style="height: 450px;background-color:#fd4f00 ;border-radius: 10px 10px 10px 10px;margin-top:5px;">
                
                <ul class="nav nav-center" align="center" style="margin-top:20px">
                    <li class="nav-item">
                        <a class="nav-link nav_change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;font-weight:bold;color:#fd4f00;width:200px">Transaction</a>
                    
                    <ul class="list-unstyled" align="center" style="text-align:10px;margin-left:5px">
                        
                        <li>   <a href="/SampathBankWebPortal/TM_interBankTransacts.jsp" style="color:white">Inter-Bank Transaction</a>  </li>
                      <li>  <a href="/SampathBankWebPortal/TM_intraBankTransacts.jsp" style="color:white">Intra-Bank Transaction</a>  </li>  
                      <li> <a href="/SampathBankWebPortal/TM_viewBalance.jsp" style="color:white">Account Balance</a>          </li> 
                      <li> <a href="/SampathBankWebPortal/transHisServlet" style="color:white">Account History</a>             </li> 
                   
                    
                    </ul>
                    
                    </li>
                    
                    <li class="nav-item">        
                        <a class="nav-link nav_change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;font-weight:bold;color:#fd4f00;;width:200px">Loan Calculator</a>
                    
                    
                     <ul class="list-unstyled" align="center" style="text-align:10px;margin-left:5px">
                        
                      <li>   <a href="#!" style="color:white">Other Loan Related</a>  </li>
                      
                   
                    
                    </ul>
                    
                    </li>
                    
                    <li class="nav-item">    
                        <a class="nav-link nav_change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;font-weight:bold;color:#fd4f00;;width:200px">Lease Calculator</a>
                    
                     <ul class="list-unstyled" align="center" style="text-align:10px;margin-left:5px">
                        
                      <li>   <a href="#!" style="color:white">Other Loan Related</a>  </li>
                      
                   
                    
                    </ul>
                    
                    
                    </li>
                    
                    <li class="nav-item">    
                        <a class="nav-link nav_change" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;font-weight:bold;color:#fd4f00;;width:200px">Complaint Handling</a>
                    
                    <ul class="list-unstyled" align="center" style="text-align:10px;margin-left:5px">
                        
                      <li>   <a href="#!" style="color:white">Lodge</a>  </li>
                      <li>  <a href="#!" style="color:white">History</a>  </li>  
                      <li> <a href="#!" style="color:white">Chat Support</a>          </li> 
                      
                   
                    
                    </ul>
                    
                    
                    </li>
                <ul>
                
                </div>
                
                <div class="col-md-10"  style="background-color:white;border-radius:30px;margin-left:0px " >
                    <!-- Include your stuff here-->
                    
                    
                    
                    
           <div class="col-md-10" >
                   <div class = "container" >
 						<div align="center">
							<br><br><br><br>		
								<p style="center:100%;font-size:35px;margin-left:200px">Your Account Balance</p>
						</div>
					<div align="center">
						
							<table class="table-striped"  align="left" cellpadding="10%" style="font-size: 110%;center: 10%;color:#404350;background-color:#FFA07A;margin-left:440px" > 
										
											<%
												Login l = (Login)session.getAttribute("username");
												
											%>
											
										
											<tr style ="font-size:115%;">
												<th >Account No</th>
												<th>Balance Amount</th>
											</tr>
											<tr>
												<td><%=l.getAccount() %></td>
												<td><%=retreiveDAO.getAccountBalance(l.getAccount()) %></td>
											</tr>
											
							</table>
						
                    	</div>
                    </div>
                </div>
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
                                <a href="#!" style="color:white">View History</a>
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