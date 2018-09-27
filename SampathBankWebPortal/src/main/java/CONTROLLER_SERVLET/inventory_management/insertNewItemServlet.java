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

import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.RetreiveDAO;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.item;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class insertNewItemServlet
 */
public class insertNewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertNewItemServlet() {
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
		PrintWriter out = response.getWriter();
		
		item i1 = new item(request.getParameter("id"), request.getParameter("name"),Integer.parseInt( request.getParameter("qty")), request.getParameter("unit"),Integer.parseInt( request.getParameter("min")), request.getParameter("description"), request.getParameter("image"));
		
		HttpSession session = request.getSession();
		loginUser u1= (loginUser) session.getAttribute("IM_user");
		
		
		HistoryItem h1 = new HistoryItem(u1.getUsername(), i1.getItemName(), i1.getItemId(), i1.getItemQty(), 0, i1.getItemQty());
		
		try {
			h1.insertHistory();
			if(i1.insertItem()) {
				JOptionPane pane = new JOptionPane("Successfully Added",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				InsertDAO.insertNewBranchItem(i1);
				
				ArrayList<item> list = RetreiveDAO.getItems();
				session = request.getSession();
				session.setAttribute("IM_itemList", list);
				
				request.getRequestDispatcher("IM_ShowItemListEmployee.jsp").forward(request, response);
			}
			
			else {
				JOptionPane pane = new JOptionPane("Unsuccessfull",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("IM_ShowItemListEmployee.jsp").forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
