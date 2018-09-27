package CONTROLLER_SERVLET.inventory_management;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import POJO_MODEL.inventory_management.item;;

/**
 * Servlet implementation class individualItemServlet
 */
public class individualItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public individualItemServlet() {
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
		ArrayList<item> itemList=  (ArrayList<item>) session.getAttribute("IM_itemList");
		item i1 = itemList.get(Integer.parseInt(request.getParameter("item")));
		session.setAttribute("IM_indItem", i1);
		request.getRequestDispatcher("IM_ShowIndividualItemInfoEmployee.jsp").forward(request, response);
	}

}
