package POJO_MODEL.user_management;

public class OnlineAccount {
	private String onlinePersonId;
	private String physicalPersonId;
	private String username;
	
	public OnlineAccount() {
	}
	
	public OnlineAccount(String onlinePersonId, String physicalPersonId, String username) {
		this.onlinePersonId = onlinePersonId;
		this.physicalPersonId = physicalPersonId;
		this.username = username;
	}

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
	
	public void displayOnlineAccount() {
		System.out.println("============Online Account : ============");
		System.out.println(this.getOnlinePersonId());
		System.out.println(this.getPhysicalPersonId());
		System.out.println(this.getUsername());
	}
}
