package DAO_SERVICE.inventory_management;

import java.sql.*;


import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;

public class UpdateDAO {

	public static String query1="UPDATE im_inventory_item set itemName=?,quantity=?,measurement=?,lowStockLevel=?,description=? where itemId=? ";
	public static String query2="UPDATE im_inventory_item set quantity=? where itemId=?";
	public static String query3 ="UPDATE im_branch_item set quantity=? where branchItemId=?";
	public static String query4 ="UPDATE im_branch_item set name=? where branchItemId=?";
	
	public static boolean updateItemDetails(item i1) throws SQLException, ClassNotFoundException {
		
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
		pst.setString(1, i1.getItemName());
		pst.setString(2, String.valueOf(i1.getItemQty()));
		pst.setString(3, i1.getUnit());
		pst.setString(4, String.valueOf(i1.getItem_min()));
		pst.setString(5, i1.getDescription());
		pst.setString(6, i1.getItemId());
		pst.executeUpdate();
		
		return true;
		
	}
	
	public static boolean updateQty(String id, int qty) throws SQLException, ClassNotFoundException {
		Connection con = DBconnection.connectDB();
		
		PreparedStatement pst = con.prepareStatement(query2);
		pst.setInt(1, qty);
		pst.setString(2, id);
		
		pst.executeUpdate();
		
		return true;
		
	}
	
	public static boolean addBranchItemQty(String id,int amount) throws ClassNotFoundException, SQLException {
		int oldQty = RetreiveDAO.getBranchItemQty(id);
		oldQty= oldQty+amount;
		Connection con = DBconnection.connectDB();
		
		PreparedStatement pst = con.prepareStatement(query3);
		pst.setInt(1, oldQty);
		pst.setString(2, id);
		
		
		pst.executeUpdate();
		
		return true;
		
	}
	
	public static boolean updateBranchItemName(item i1) throws ClassNotFoundException, SQLException {
		
		Connection con = DBconnection.connectDB();
		
		PreparedStatement pst = con.prepareStatement(query4);
		pst.setString(1, i1.getItemName());
		pst.setString(2, i1.getItemId());
		
		
		pst.executeUpdate();
		return true;
		
	}
	
	
}
