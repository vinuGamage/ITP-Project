package POJO_MODEL.user_management;

public class OnlineAccount {
	private String onlinePersonId;
	private String physicalPersonId;
	private String username;
	private String type;
	
	public String getOnlinePersonId() {
		return onlinePersonId;
	}
	public void setOnlinePersonId(String onlinePersonId) {
		this.onlinePersonId = onlinePersonId;
	}
	public String getPhysicalPersonId() {
		return physicalPersonId;
	}
	public void setPhysicalPersonId(String physicalPersonId) {
		this.physicalPersonId = physicalPersonId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
