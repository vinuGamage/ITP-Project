package DAO_SERVICE.inventory_management;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;
import CONTROLLER_SERVLET.inventory_management.RequestItemServlet;

public class OtherMethods {

	private static String query="SELECT * from im_inventory_item WHERE itemId=? ";
	
	
	
	public static int getOldQty(int id) {
		return (Integer) null;
	}
	
	public static int getNewQty(String id ,int amount) throws ClassNotFoundException, SQLException {
		
		int oldQty = 0;
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, id);
		
		ResultSet rst = pst.executeQuery();
		if(rst.next()) {
			oldQty =rst.getInt(3);
		}
		oldQty=oldQty+amount;
		return oldQty;
		
	}
	
	public static boolean reduceQty(headRequestItem r1) throws ClassNotFoundException, SQLException {
	int currentQty=	RetreiveDAO.getItemQty(r1.getItemId());
		currentQty = currentQty- r1.getReqAmount();
		
		UpdateDAO.addBranchItemQty(r1.getItemId(), r1.getReqAmount());
		DeleteDAO.deleteRequest(r1.getRefId());
		
		
		return UpdateDAO.updateQty(r1.getItemId(),currentQty);
		
		
	}
	
	public static boolean insertHistory(HistoryItem h1) throws ClassNotFoundException, SQLException {
		
		InsertDAO.insertInsertHistory(h1);
	
		return true;
		
	}
	
	public static String CompareItem(item oldItem, item updateItem){
		ArrayList<String> updatedFields = new ArrayList<String>();
		String updated ="" ;
		
		if((!(oldItem.getItemName().equals(updateItem.getItemName()))) ||(!(oldItem.getItemQty()==updateItem.getItemQty())) || (!(oldItem.getUnit().equals(updateItem.getUnit()))) || (!(oldItem.getItem_min()==updateItem.getItem_min())) ||(!(oldItem.getDescription().equals(updateItem.getDescription()))) ) {
			String action1="Updated"+".   ";
			updatedFields.add(action1);
		}
		if(!(oldItem.getItemName().equals(updateItem.getItemName()))) {
			String action1 ="Item was renamed from : " + oldItem.getItemName() + " To : " + updateItem.getItemName()+ ".   ";
			updatedFields.add(action1);
		}
		if(!(oldItem.getItemQty()==updateItem.getItemQty())) {
			String action1 ="Item Quantity was changed from : " + oldItem.getItemQty() + " To : " + updateItem.getItemQty()+".   ";
			updatedFields.add(action1);
		}
		
		if(!(oldItem.getUnit().equals(updateItem.getUnit()))) {
			
			String action1 ="Item Measurement was changed from : " + oldItem.getUnit() + " To : " + updateItem.getUnit()+ ".   ";
			updatedFields.add(action1);
		}
		
		if(!(oldItem.getItem_min()==updateItem.getItem_min())) {
			String action1 ="Item Minimum  Quantity was changed from : " + oldItem.getItem_min() + " To : " + updateItem.getItem_min()+ ".   ";
			updatedFields.add(action1);
		}
		if(!(oldItem.getDescription().equals(updateItem.getDescription()))) {
			String action1 ="Item Description was changed from : " + oldItem.getDescription() + " To : " + updateItem.getDescription()+ ".   ";
			updatedFields.add(action1);	
		}
		
		if(((oldItem.getItemName().equals(updateItem.getItemName()))) && ((oldItem.getItemQty()==updateItem.getItemQty())) && ((oldItem.getUnit().equals(updateItem.getUnit()))) && ((oldItem.getItem_min()==updateItem.getItem_min())) && ((oldItem.getDescription().equals(updateItem.getDescription()))) ) {
			String action1="No Change"+".   ";
			updatedFields.add(action1);
		}
		int x =0;
		while(x<updatedFields.size()) {
			
			updated = updated +System.lineSeparator() + updatedFields.get(x);
			x++;
		}
		
		System.out.println(updated);
		return updated;
	}
	
	
	
}
