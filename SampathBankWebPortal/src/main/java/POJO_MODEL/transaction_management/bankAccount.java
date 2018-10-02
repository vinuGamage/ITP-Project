package POJO_MODEL.transaction_management;

public class bankAccount {

	private long accountno;
	private double amount;
	//private String type;
	
	
	public bankAccount(long accountno,double amount) {
		// TODO Auto-generated constructor stub
		this.accountno = accountno;
		this.amount = amount;
		
		
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

//	public void updateBalance(Transaction t) {
//		updateDAO.transactions(t);
//	}
	
}
