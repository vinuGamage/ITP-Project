package CONTROLLER_SERVLET.inventory_management;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import javax.swing.ImageIcon;

import java.awt.Color;

import DAO_SERVICE.inventory_management.GeneratePrimaryKey;
import DAO_SERVICE.inventory_management.GenerateReports;
import DAO_SERVICE.inventory_management.OtherMethods;

/**
 * Servlet implementation class sampleServlet
 */
public class sampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		JOptionPane pane = new JOptionPane(" Addition Successful",JOptionPane.OK_CANCEL_OPTION);  
//		JDialog dialog = pane.createDialog("Status");  
//		dialog.setAlwaysOnTop(true);  
//		dialog.show(); 
		
//		int input = JOptionPane.showConfirmDialog(new JDialog(),"Press Okay to confirm", "Customized Dialog", 
//                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
//		System.out.println(input);
		
//		try {
//			GenerateReports.FullTransactionHistory("sample");
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Date dNow = new Date( );
//	      SimpleDateFormat ft = 
//	      new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
//
//	      System.out.println("Current Date: " + ft.format(dNow));
		
//		System.out.println(request.getParameter("month"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print(request.getParameter("pic"));
	}

}
