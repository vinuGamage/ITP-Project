package POJO_MODEL.transaction_management;

public class Login {

	private String username;

	private int account;
	
	public Login(String username,int account) {
		this.account = account;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
}
