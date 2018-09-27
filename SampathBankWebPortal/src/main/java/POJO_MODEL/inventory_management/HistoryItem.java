package POJO_MODEL.inventory_management;

import java.sql.SQLException;

import DAO_SERVICE.inventory_management.OtherMethods;

public class HistoryItem {
		
	private String histId;
	private String username;
	private String itemName; 
	private String itemId;
	private String action;
	private int qty;
	private int from;
	private int to;
	private String dateAndTime;
	
	public HistoryItem(String histId, String username, String itemName, String itemId, int qty, int from, int to) {
		super();
		this.histId = histId;
		this.username = username;
		this.itemName = itemName;
		this.itemId = itemId;
		this.qty = qty;
		this.from = from;
		this.to = to;
	}

	
	public HistoryItem(String histId, String username, String itemName, String itemId, String action,
			String dateAndTime) {
		super();
		this.histId = histId;
		this.username = username;
		this.itemName = itemName;
		this.itemId = itemId;
		this.action = action;
		this.dateAndTime = dateAndTime;
	}


	public HistoryItem(String username, String itemName, String itemId, int qty, int from, int to) {
		super();
		this.username = username;
		this.itemName = itemName;
		this.itemId = itemId;
		this.qty = qty;
		this.from = from;
		this.to = to;
	}
	
	

	public HistoryItem(String histId, String username, String itemName, String itemId, String action, int qty, int from,
			int to) {
		super();
		this.histId = histId;
		this.username = username;
		this.itemName = itemName;
		this.itemId = itemId;
		this.action = action;
		this.qty = qty;
		this.from = from;
		this.to = to;
	}
	

	public HistoryItem(String histId, String username, String itemName, String itemId, String action, int qty, int from,
			int to, String dateAndTime) {
		super();
		this.histId = histId;
		this.username = username;
		this.itemName = itemName;
		this.itemId = itemId;
		this.action = action;
		this.qty = qty;
		this.from = from;
		this.to = to;
		this.dateAndTime = dateAndTime;
	}

	public String getHistId() {
		return histId;
	}

	public void setHistId(String histId) {
		this.histId = histId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
	
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public boolean insertHistory() throws ClassNotFoundException, SQLException {
		return OtherMethods.insertHistory(this);
	}
	
	
}
