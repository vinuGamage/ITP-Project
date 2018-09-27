package POJO_MODEL.inventory_management;

import java.sql.SQLException;



import DAO_SERVICE.inventory_management.InsertDAO;;

public class headRequestItem {
	
	
	private String refId;
	private String headUsername;
	private String branch;
	private String itemId ;
	private String itemName;
	private int reqAmount;
	public headRequestItem(String refId, String headUsername, String branch, String itemId, String itemName,
			int reqAmount) {
		super();
		this.refId = refId;
		this.headUsername = headUsername;
		this.branch = branch;
		this.itemId = itemId;
		this.itemName = itemName;
		this.reqAmount = reqAmount;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getHeadUsername() {
		return headUsername;
	}
	public void setHeadUsername(String headUsername) {
		this.headUsername = headUsername;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getReqAmount() {
		return reqAmount;
	}
	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}
	
	
	public boolean insertRequest() throws ClassNotFoundException, SQLException {
		return InsertDAO.insertNewRequest(this);
	}
}
