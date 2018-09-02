package pojo_model.user_management;

public class OnlineSecurityKey {
	private String onlineSecurityKey;

	public OnlineSecurityKey() {}
	
	public OnlineSecurityKey(String onlineSecurityKey) {
		this.setOnlineSecurityKey(onlineSecurityKey);
	}
	
	public void setOnlineSecurityKey(String onlineSecurityKey) {
		this.onlineSecurityKey = onlineSecurityKey;
	}
	
	public String getOnlineSecurityKey() {
		return onlineSecurityKey;
	}
}
