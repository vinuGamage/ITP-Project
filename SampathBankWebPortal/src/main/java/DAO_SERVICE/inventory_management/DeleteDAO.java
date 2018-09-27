package DAO_SERVICE.inventory_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO_MODEL.inventory_management.item;

public class DeleteDAO {

	
	public static String query1="DELETE FROM im_inventory_item where itemId=?";
	public static String query2="DELETE FROM im_request_item where refId=?";
	public static String query3="DELETE FROM im_branch_item where branchItemId=?";
	public static String query4="DELETE FROM im_request_item where itemId = ?";
	
	public static boolean deleteItem(String s) throws ClassNotFoundException, SQLException {
		
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
		pst.setString(1, s);
		pst.executeUpdate();
		
		
		return true;
		
	}
	public static boolean deleteRequest(String s) throws SQLException, ClassNotFoundException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query2);
		pst.setString(1, s);
		pst.executeUpdate();
		return true;
	}
	public static boolean deleteBranchItem(String s) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query3);
		pst.setString(1, s);
		pst.executeUpdate();
		return true;
	}
	public static boolean deleteRequest_itemdeleted(String s) throws SQLException, ClassNotFoundException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		pst.setString(1, s);
		pst.executeUpdate();
		return true;
	}
}
