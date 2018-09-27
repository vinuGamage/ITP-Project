package POJO_MODEL.inventory_management;

import java.sql.SQLException;


import DAO_SERVICE.inventory_management.InsertDAO;
import DAO_SERVICE.inventory_management.UpdateDAO;;

public class item {

	String itemId;
	String itemName;
	int itemQty;
	String unit;
	int item_min;
	String description;
	String image;
	
	
	public item(String itemId, String itemName, int itemQty, String unit, int item_min , String description,String image) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.unit = unit;
		this.item_min = item_min;
		this.description=description;
		this.image = image;
	}


	public boolean updateItem() throws ClassNotFoundException, SQLException {
		
		
		return UpdateDAO.updateItemDetails(this);
		
	}
	
	
	public boolean insertItem() throws ClassNotFoundException, SQLException {
		return InsertDAO.insertNewItem(this);
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


	public int getItemQty() {
		return itemQty;
	}


	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public int getItem_min() {
		return item_min;
	}


	public void setItem_min(int item_min) {
		this.item_min = item_min;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
