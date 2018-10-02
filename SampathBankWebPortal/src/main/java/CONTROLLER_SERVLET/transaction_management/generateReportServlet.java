package CONTROLLER_SERVLET.transaction_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import DAO_SERVICE.transaction_management.GenerateReports;
import POJO_MODEL.transaction_management.Transaction;

/**
 * Servlet implementation class generateReportServlet
 */
public class generateReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			GenerateReports.fullTransactionHistory("sample");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("submit1")!=null) {
			try {
				GenerateReports.fullTransactionHistory(request.getParameter("path"));
				//request.getRequestDispatcher("TM_empGenerateReports.jsp").forward(request, response);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			Transaction t1 = new Transaction(Long.parseLong(request.getParameter("srcAccount")),Long.parseLong(request.getParameter("tarAccount")) , request.getParameter("month"), Double.parseDouble(request.getParameter("amount")), Integer.parseInt(request.getParameter("transId")), request.getParameter("status"));
			try {
				GenerateReports.SpecificTransactionHistory(request.getParameter("path"), t1);
				System.out.println(t1.getTid());
				System.out.println(t1.getAccountNo());
				System.out.println(t1.getTaccountNo());
				System.out.println(t1.getDate());
				System.out.println(t1.getAmount());
				System.out.println(t1.getStatus());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
