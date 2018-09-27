package CONTROLLER_SERVLET.inventory_management;

import java.io.IOException;

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
import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.OtherMethods;
import DAO_SERVICE.inventory_management.RetreiveDAO;
import DAO_SERVICE.inventory_management.UpdateDAO;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.item;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class updateItemServlet
 */
public class updateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateItemServlet() {
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
		
		int input = JOptionPane.showConfirmDialog(new JDialog(),"Press Okay to confirm", "Customized Dialog", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		HttpSession session = request.getSession();
		if(input==0) {
		
		JOptionPane pane = new JOptionPane("Update Successful",JOptionPane.WARNING_MESSAGE);  
		JDialog dialog = pane.createDialog("Status");  
		dialog.setAlwaysOnTop(true);  
		dialog.show(); 
		
		session = request.getSession();
		loginUser l1= (loginUser) session.getAttribute("IM_user");
		
		
		item i1 = new item(request.getParameter("id"), request.getParameter("name"),Integer.parseInt( request.getParameter("qty")), request.getParameter("unit"), Integer.parseInt(request.getParameter("min")), request.getParameter("description"), request.getParameter("path"));
		
		try {
			item oldItem = RetreiveDAO.retreiveInventoryRow(i1.getItemId());

			
			String action = OtherMethods.CompareItem(oldItem, i1);
			HistoryItem h1 = new HistoryItem(GeneratePrimaryKey.generateHistoryId(), l1.getUsername(), i1.getItemName(), i1.getItemId(), action, i1.getItemQty(), 0, i1.getItemQty());

			if(i1.updateItem()) {
				
				
				UpdateDAO.updateBranchItemName(i1);
				InsertDAO.insertUpdateHistory(h1);
				ArrayList<item> list = RetreiveDAO.getItems();
				session = request.getSession();
				session.setAttribute("IM_itemList", list);
				
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
		else
		{
			ArrayList<item> list;
			try {
				list = RetreiveDAO.getItems();
				session = request.getSession();
				session.setAttribute("IM_itemList", list);
				
				request.getRequestDispatcher("IM_ShowItemListEmployee.jsp").forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
