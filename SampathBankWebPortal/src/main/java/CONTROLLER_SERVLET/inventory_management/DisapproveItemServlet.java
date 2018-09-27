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

import DAO_SERVICE.inventory_management.DeleteDAO;
import DAO_SERVICE.inventory_management.GeneratePrimaryKey;
import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.RetreiveDAO;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.loginUser;

/**
 * Servlet implementation class DisapproveItemServlet
 */
public class DisapproveItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisapproveItemServlet() {
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
		
		int input = JOptionPane.showConfirmDialog(new JDialog(),"Press Okay to confirm", "Customized Dialog", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		loginUser u1 =	(loginUser) session.getAttribute("IM_user");
	
		if(input==0) {
		
		ArrayList<headRequestItem> reqList = (ArrayList<headRequestItem>) session.getAttribute("IM_RequestList") ;
		headRequestItem r1 = reqList.get(Integer.parseInt(request.getParameter("request")));
		try {
			DeleteDAO.deleteRequest(r1.getRefId());
			
			ArrayList<headRequestItem> reqList1;
			reqList1 = RetreiveDAO.getRequestDetails();
			session.setAttribute("IM_RequestList", reqList1);
			
			HistoryItem h1 = new HistoryItem(GeneratePrimaryKey.generateHistoryId(), u1.getUsername(), r1.getItemName(), r1.getItemId(), "Disapproved Request", r1.getReqAmount(), RetreiveDAO.retreiveInventoryRow(r1.getItemId()).getItemQty(),RetreiveDAO.retreiveInventoryRow(r1.getItemId()).getItemQty() );
			InsertDAO.insertDisapproveItemHistory(h1);
			
			JOptionPane pane = new JOptionPane("Disapproved (Approve request will be deleted)",JOptionPane.WARNING_MESSAGE);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show();
			
			request.getRequestDispatcher("IM_ShowRequestItemListEmployee.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			ArrayList<headRequestItem> reqList1;
			try {
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
