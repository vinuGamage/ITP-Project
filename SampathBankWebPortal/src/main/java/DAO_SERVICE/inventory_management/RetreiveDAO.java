package DAO_SERVICE.inventory_management;

import java.util.ArrayList;



import java.sql.*;

import POJO_MODEL.inventory_management.BranchItem;
import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;

public class RetreiveDAO {

	private static String query1 ="SELECT * from im_inventory_item";
	private static String query2="SELECT * from im_branch_item";
	private static String query3="SELECT * from im_request_item";
	private static String query4 ="SELECT * from im_inventory_item WHERE itemId=? ";
	private static String query5 ="SELECT * from im_branch_item WHERE branchItemId=? ";
	private static String query6 = "SELECT * from im_inventory_item WHERE itemId=? ";
	private static String query7 ="SELECT * from im_history";
	private static String query8 ="SELECT * from im_inventory_item WHERE itemId LIKE ? OR itemName LIKE ? OR quantity LIKE ? OR measurement LIKE ? OR lowStockLevel LIKE ?";
	private static String query9 ="SELECT * from im_history WHERE histId LIKE ? OR username LIKE ? OR ItemId LIKE ? OR ItemName LIKE ? OR action LIKE ? OR qty LIKE ? OR fromQty LIKE ? OR toQty LIKE ? OR dateAndTime LIKE ? ";
	private static String query10 = "SELECT * from im_request_item WHERE refId LIKE ? OR head_username LIKE ? OR branch LIKE ? OR itemId LIKE ? OR itemName LIKE ? OR requestAmount LIKE ? ";
	private static String query11 ="SELECT * from im_history WHERE histId LIKE ? AND username LIKE ? AND ItemId LIKE ? AND ItemName LIKE ? AND action LIKE ? AND dateAndTime LIKE ? ";
	
	public static ArrayList<item> getItems() throws ClassNotFoundException, SQLException{
		
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
			
		ResultSet rst = pst.executeQuery();
		ArrayList<item> itemList = new ArrayList<item>();
		
		while(rst.next()) {
			
			
			
			item i1 = new item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5),rst.getString(6),rst.getString(7));
			itemList.add(i1);
			
		}
		return itemList;
		
		
		}
	
		public static ArrayList<BranchItem> getBranchItems() throws SQLException, ClassNotFoundException{
			
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query2);
			
			ResultSet rst = pst.executeQuery();
			
			ArrayList<BranchItem> branchItemList = new ArrayList<BranchItem>();
			
			while(rst.next()) {
				BranchItem b1 = new BranchItem(rst.getString(1), rst.getString(2), rst.getInt(3));
				branchItemList.add(b1);
				
			}
			return branchItemList;
			
		}
		
		public static ArrayList<headRequestItem> getRequestDetails() throws SQLException, ClassNotFoundException{
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query3);
			
			ResultSet rst = pst.executeQuery();
			
			ArrayList<headRequestItem> requestItemList = new ArrayList<headRequestItem>();
			
			while(rst.next()) {
				headRequestItem h1 = new headRequestItem(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6));
				requestItemList.add(h1);
				
			}
			return requestItemList;
		}
		
		public static int getItemQty(String id) throws ClassNotFoundException, SQLException {
			Connection con= DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query4);
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				return rst.getInt(3);
			}
			else return (Integer) null;
		}
		
		public static int getBranchItemQty(String id) throws ClassNotFoundException, SQLException {
			Connection con= DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query5);
			pst.setString(1, id);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				return rst.getInt(3);
			}
			else return (Integer) null;
		}
		
		public static ArrayList<item> getRestockingItems() throws ClassNotFoundException, SQLException{
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query1);
				
			ResultSet rst = pst.executeQuery();
			ArrayList<item> itemList = new ArrayList<item>();
			
			while(rst.next()) {
				
				
				
				item i1 = new item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5),rst.getString(6),rst.getString(7));
				if(i1.getItemQty()<=i1.getItem_min()) {
					itemList.add(i1);
				}
				
				
				
			}
			return itemList;
		}
		
		public static item retreiveInventoryRow (String id) throws ClassNotFoundException, SQLException {
			item i1 = null;
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query6);
			pst.setString(1,id );
			
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
			i1 = new item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getString(7));
			}
			return i1;
			
		}
		
		public static ArrayList<HistoryItem> retreiveHistoryRecords() throws ClassNotFoundException, SQLException{
			ArrayList<HistoryItem> historyList = new ArrayList<HistoryItem>();
			
			Connection con = DBconnection.connectDB();
			PreparedStatement pst=  con.prepareStatement(query7);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				HistoryItem h1 = new HistoryItem(rst.getString(1), rst.getString(2), rst.getString(4), rst.getString(3), rst.getString(5), rst.getInt(6), rst.getInt(7), rst.getInt(8), rst.getString(9));
				historyList.add(h1);
			}
			return historyList;
		}
		
		public static ArrayList<item> retreiveSearchItem(String search) throws ClassNotFoundException, SQLException{
			ArrayList<item> itemList = new ArrayList<item>();
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query8);
			pst.setString(1, "%"+search+"%");
			pst.setString(2, "%"+search+"%");
			pst.setString(3, "%"+search+"%");
			pst.setString(4, "%"+search+"%");
			pst.setString(5, "%"+search+"%");
			
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				item i1 = new item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getInt(5),rst.getString(6),rst.getString(7));
				itemList.add(i1);
			}
			return itemList;
		}
		
		public static ArrayList<HistoryItem> retreiveSearchHistory(String search) throws ClassNotFoundException, SQLException{
			ArrayList<HistoryItem> historyList = new ArrayList<HistoryItem>();
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query9);
			pst.setString(1, "%"+search+"%");
			pst.setString(2, "%"+search+"%");
			pst.setString(3, "%"+search+"%");
			pst.setString(4, "%"+search+"%");
			pst.setString(5, "%"+search+"%");
			pst.setString(6, "%"+search+"%");
			pst.setString(7, "%"+search+"%");
			pst.setString(8, "%"+search+"%");
			pst.setString(9, "%"+search+"%");
			
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				HistoryItem h1 = new HistoryItem(rst.getString(1), rst.getString(2), rst.getString(4), rst.getString(3), rst.getString(5), rst.getInt(6), rst.getInt(7), rst.getInt(8), rst.getString(9));
				historyList.add(h1);
			}
			return historyList;
		}
		
		public static ArrayList<headRequestItem > retreiveRequestHistory(String search) throws ClassNotFoundException, SQLException{
			ArrayList<headRequestItem> requestList = new ArrayList<headRequestItem>();
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query10);
			pst.setString(1, "%"+search+"%");
			pst.setString(2, "%"+search+"%");
			pst.setString(3, "%"+search+"%");
			pst.setString(4, "%"+search+"%");
			pst.setString(5, "%"+search+"%");
			pst.setString(6, "%"+search+"%");
			
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				headRequestItem h1 = new headRequestItem(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6));
				requestList.add(h1);
			}
			return requestList;
		}
		
		public static ArrayList<HistoryItem> retreiveGenerateReportSpecificHistory(HistoryItem h1) throws ClassNotFoundException, SQLException{
			ArrayList<HistoryItem> historyList = new ArrayList<HistoryItem>();
			Connection con = DBconnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query11);
			pst.setString(1, "%"+h1.getHistId()+"%");
			pst.setString(2, "%"+h1.getUsername()+"%");
			pst.setString(3, "%"+h1.getItemId()+"%");
			pst.setString(4, "%"+h1.getItemName()+"%");
			pst.setString(5, "%"+h1.getAction()+"%");
			pst.setString(6, "%"+h1.getDateAndTime()+"%");
			
			
			
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				HistoryItem h2 = new HistoryItem(rst.getString(1), rst.getString(2), rst.getString(4), rst.getString(3), rst.getString(5), rst.getInt(6), rst.getInt(7), rst.getInt(8), rst.getString(9));
				historyList.add(h2);
			}
			return historyList;
		}
} 
