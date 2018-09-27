package CONTROLLER_SERVLET.inventory_management;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import DAO_SERVICE.inventory_management.GenerateReports;
import POJO_MODEL.inventory_management.HistoryItem;

/**
 * Servlet implementation class GenerateReportHistoryServlet
 */
public class GenerateReportHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateReportHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("submit1")!=null) {
			try {
				GenerateReports.FullItemHistory(request.getParameter("path"));
				JOptionPane pane = new JOptionPane("PDF Successfully created in D:\\GeneratedReports\\"+request.getParameter("path")+".pdf",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show();
				request.getRequestDispatcher("IM_GenerateReports.jsp").forward(request, response);
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			HistoryItem h1 = new HistoryItem(request.getParameter("histId"), request.getParameter("username"), request.getParameter("itemName"), request.getParameter("itemId"), request.getParameter("action"), request.getParameter("month"));
			try {
				GenerateReports.SpecificItemHistory(request.getParameter("path"), h1);
				

				
				JOptionPane pane = new JOptionPane("PDF Successfully created in E:\\GeneratedReports\\"+request.getParameter("path")+".pdf",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show();
				
				request.getRequestDispatcher("IM_GenerateReports.jsp").forward(request, response);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
