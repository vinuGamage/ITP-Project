package POJO_MODEL.transaction_management;

import DAO_SERVICE.transaction_management.retreiveDAO;

public class Transaction {

	private long accountNo;
	private long taccountNo;
	private String date;
	private double amount;
	private int tid;
	private String status;

	public Transaction(long accountNo,long taccountNo,String date,double amount) {
		// TODO Auto-generated constructor stub
		this.accountNo = accountNo;
		this.taccountNo = taccountNo;
		this.amount = amount;
		this.date = date;
		
		
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Transaction(long accountNo, long taccountNo, String date, double amount, int tid) {

		this.accountNo = accountNo;
		this.taccountNo = taccountNo;
		this.date = date;
		this.amount = amount;
		this.tid = tid;
	}



	public Transaction(long accountNo, long taccountNo, String date, double amount, int tid, String status) {
		super();
		this.accountNo = accountNo;
		this.taccountNo = taccountNo;
		this.date = date;
		this.amount = amount;
		this.tid = tid;
		this.status = status;
	}

	public Transaction(String parameter, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6) {
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}



	public void setTid(int tid) {
		this.tid = tid;
	}



	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public long getTaccountNo() {
		return taccountNo;
	}

	public void setTaccountNo(long taccountNo) {
		this.taccountNo = taccountNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double creditAccount(long taccount, double camount) {
		if(taccountNo ==  taccount);
		 double balance = retreiveDAO.accountBalance(this); 
			balance += camount;
			return balance;
		
	}
	
	public double debitAccount(long account, double damount) {
		if(accountNo == account);
			double balance = retreiveDAO.debitAccountBalance(this);
			balance -= damount;
			return balance;
	}
	
	
}
