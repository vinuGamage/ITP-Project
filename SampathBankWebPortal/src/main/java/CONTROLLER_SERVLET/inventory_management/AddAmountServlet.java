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
import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.OtherMethods;
import DAO_SERVICE.inventory_management.RetreiveDAO;
import DAO_SERVICE.inventory_management.UpdateDAO;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.item;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class AddAmountServlet
 */
public class AddAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAmountServlet() {
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
		loginUser u1 = (loginUser) session.getAttribute("IM_user");
		if(input==0) {
		
		ArrayList <item> itemList = (ArrayList <item>) session.getAttribute("IM_itemList");
		item i1 = itemList.get(Integer.parseInt(request.getParameter("value")));
		String itemID = i1.getItemId();
		int addAmount = Integer.parseInt(request.getParameter(request.getParameter("name")));
		
		
		try {
			int newQty = OtherMethods.getNewQty(itemID,addAmount);
			UpdateDAO.updateQty(itemID, newQty);
			item it2 = RetreiveDAO.retreiveInventoryRow(i1.getItemId());
			
			HistoryItem h1 = new HistoryItem(GeneratePrimaryKey.generateHistoryId(), u1.getUsername(), i1.getItemName(), i1.getItemId(), addAmount + " items were added", addAmount, i1.getItemQty(), it2.getItemQty());
			InsertDAO.insertAddAmountHistory(h1);
			ArrayList<item> i2 = 	 RetreiveDAO.getItems();
			
		
			session.setAttribute("IM_itemList", i2);
			
			
			request.getRequestDispatcher("IM_ShowItemListEmployee.jsp").forward(request, response);
		
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		else {
			
			try {
				ArrayList<item> i2 = 	 RetreiveDAO.getItems();
				
				session.setAttribute("IM_itemList", i2);
				
				
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
