package POJO_MODEL.user_management;

public class OnlineSecurityKey {
	private int onlineSecurityId;
	private String onlineSecurityKey;
	
	public OnlineSecurityKey() {}

	public OnlineSecurityKey(int onlineSecurityId, String onlineSecurityKey) {
		this.onlineSecurityId = onlineSecurityId;
		this.onlineSecurityKey = onlineSecurityKey;
	}
	
	public int getOnlineSecurityId() {
		return onlineSecurityId;
	}

	public void setOnlineSecurityId(int onlineSecurityId) {
		this.onlineSecurityId = onlineSecurityId;
	}

	public String getOnlineSecurityKey() {
		return onlineSecurityKey;
	}

	public void setOnlineSecurityKey(String onlineSecurityKey) {
		this.onlineSecurityKey = onlineSecurityKey;
	}
	
	public void displayOnlineSecurityKey() {
		System.out.println("============Online Security Key : ============");
		System.out.println(this.getOnlineSecurityId());
		System.out.println(this.getOnlineSecurityKey());
	}
}
