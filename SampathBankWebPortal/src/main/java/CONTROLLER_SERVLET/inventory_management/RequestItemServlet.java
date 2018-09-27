package CONTROLLER_SERVLET.inventory_management;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.inventory_management.GeneratePrimaryKey;
import POJO_MODEL.inventory_management.BranchItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class RequestItemServlet
 */
public class RequestItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestItemServlet() {
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
		HttpSession session = request.getSession();
		ArrayList<BranchItem> branchItem =(ArrayList<BranchItem>) session.getAttribute("IM_branchItemList");
		
		String itemID = branchItem.get(Integer.parseInt(request.getParameter("value"))).getId();
		int reqAmount = Integer.parseInt(request.getParameter(request.getParameter("name")));
		String name = branchItem.get(Integer.parseInt(request.getParameter("value"))).getName();
		loginUser u1 = (loginUser) session.getAttribute("IM_user");
		
		
		PrintWriter out = response.getWriter();
		
		
		
		try {
			headRequestItem i1 = new headRequestItem(GeneratePrimaryKey.generateRequestItemId(), u1.getUsername(), u1.getBranch(), itemID, name, reqAmount);
			if(i1.insertRequest()) {
				JOptionPane pane = new JOptionPane("Successfully Requested",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				request.getRequestDispatcher("IM_RequestItemHead.jsp").forward(request, response);
			}
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			out.println(GeneratePrimaryKey.generateRequestItemId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
