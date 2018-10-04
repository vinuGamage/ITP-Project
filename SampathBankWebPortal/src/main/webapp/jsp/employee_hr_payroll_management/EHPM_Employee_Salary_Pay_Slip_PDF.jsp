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

<%
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
		String file = session.getServletContext().getRealPath("/jsp/employee_hr_payroll_management/reports/AllEmployeeContactDetails.jrxml");
		InputStream input = new FileInputStream(new File(file));
		
		JasperReport jr = JasperCompileManager.compileReport(input);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		
		JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(con != null)
			con.close();
	}
%>