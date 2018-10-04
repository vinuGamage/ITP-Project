<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="DAO_SERVICE.common_service.ConnectionPoolManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>
<%@page import="net.sf.jasperreports.engine.design.JRDesignQuery"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@ page  import="POJO_MODEL.employee_hr_payroll_management.Employee"%>

<%
	Employee employee = (Employee) session.getAttribute("employee");
	String employeeId = employee.getPersonId();
	Connection con = null;

	//Conneciton Managing Start
	ConnectionPoolManager cpmObj = new ConnectionPoolManager();
	DataSource dataSource = null;
	try {
		dataSource = cpmObj.initializePool();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	try {
		con = dataSource.getConnection();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	//Conneciton Managing End
	
	try {
		String file = session.getServletContext().getRealPath("/jsp/employee_hr_payroll_management/reports/Employee_Payslip.jrxml");
	 	JasperDesign jd= JRXmlLoader.load(new File(file));
		JRDesignQuery newQuery = new JRDesignQuery();
	 	newQuery.setText("SELECT * FROM Person p INNER JOIN employee e ON p.personId=e.employeeId INNER JOIN salary s ON e.employeeId=s.employeeId WHERE s.employeeId='"+employeeId+"'");
	 	jd.setQuery(newQuery);
	  
	 	
	 	JasperReport jasperReport = JasperCompileManager.compileReport(jd);
	 	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
	 	
	 	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(con != null)
			con.close();
	}
%>