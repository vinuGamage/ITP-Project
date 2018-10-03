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
import javax.websocket.Session;

import DAO_SERVICE.inventory_management.GeneratePrimaryKey;
import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.OtherMethods;
import DAO_SERVICE.inventory_management.RetreiveDAO;
import POJO_MODEL.employee_hr_payroll_management.email_client.EmailClient;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class ApproveItemServlet
 */
public class ApproveItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveItemServlet() {
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
			HttpSession session = request.getSession();
			int input = JOptionPane.showConfirmDialog(new JDialog(),"Press Okay to confirm", "Customized Dialog", 
	                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		loginUser u1 =	(loginUser) session.getAttribute("IM_user");
			if(input==0) {
			
			
			ArrayList<headRequestItem> reqList = (ArrayList<headRequestItem>) session.getAttribute("IM_RequestList") ;
			headRequestItem r1 = reqList.get(Integer.parseInt(request.getParameter("request")));
			
			
			try {
				item oldItem = RetreiveDAO.retreiveInventoryRow(r1.getItemId());
				if(OtherMethods.reduceQty(r1)) {
					ArrayList<item> i2 = 	 RetreiveDAO.getItems();
					session = request.getSession();
					session.setAttribute("IM_itemList", i2);
					
					ArrayList<headRequestItem> reqList1;
					reqList1 = RetreiveDAO.getRequestDetails();
					session.setAttribute("IM_RequestList", reqList1);
					item newItem = RetreiveDAO.retreiveInventoryRow(r1.getItemId());
					
					HistoryItem i1 = new HistoryItem(GeneratePrimaryKey.generateHistoryId(), u1.getUsername(), r1.getItemName(), r1.getItemId(), "Approved Request", r1.getReqAmount(), oldItem.getItemQty(), newItem.getItemQty());
					InsertDAO.insertAddAmountHistory(i1);
					
					if(newItem.getItemQty()<newItem.getItem_min()) {
						EmailClient.sendMail("atheeqrc@gmail.com", "Low Stock Level Request", "Please restock the item : " + newItem.getItemName() + " \n Current Quantity is : " + newItem.getItemQty() + " \n Low Stock Level is : " + newItem.getItem_min() );
					}
					
					JOptionPane pane = new JOptionPane("Successfully approved (Approve request will be deleted)",JOptionPane.WARNING_MESSAGE);  
					JDialog dialog = pane.createDialog("Status");  
					dialog.setAlwaysOnTop(true);  
					dialog.show();
					
					request.getRequestDispatcher("IM_ShowRequestItemListEmployee.jsp").forward(request, response);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				ArrayList<item> i2;
				try {
					i2 = RetreiveDAO.getItems();
					session = request.getSession();
					session.setAttribute("IM_itemList", i2);
					
					ArrayList<headRequestItem> reqList1;
					reqList1 = RetreiveDAO.getRequestDetails();
					session.setAttribute("IM_RequestList", reqList1);
					request.getRequestDispatcher("IM_ShowRequestItemListEmployee.jsp").forward(request, response);
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
