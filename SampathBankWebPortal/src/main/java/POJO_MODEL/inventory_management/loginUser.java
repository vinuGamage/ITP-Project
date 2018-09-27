package POJO_MODEL.inventory_management;

import java.sql.SQLException;

public class loginUser {

	String username;
	
	String branch;
	
	//Constructor
	public loginUser(String username, String branch) {
		
		this.username = username;
		
		this.branch =branch;
	}
	
	//Getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}
