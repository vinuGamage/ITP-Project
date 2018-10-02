package POJO_MODEL.transaction_management;

import java.text.SimpleDateFormat;
import java.util.Date;

import DAO_SERVICE.transaction_management.retreiveDAO;

public class StandingOrder {

	private long accountno;
	private long Taccountno;
	private String description;
	private double amount;
	private int date;
	private int period;
	
	public StandingOrder(long accountno,long Taccountno,String description,double amount,int date,int period) {
		// TODO Auto-generated constructor stub
		this.accountno = accountno;
		this.amount = amount;
		this.Taccountno = Taccountno;
		this.date = date;
		this.description = description;
		this.period = period;
		
	}


	public long getAccountno() {
		return accountno;
	}


	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}


	public long getTaccountno() {
		return Taccountno;
	}


	public void setTaccountno(long taccountno) {
		Taccountno = taccountno;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}

	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public double standingOrderPayments(long account, double damount,int date,int period) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd HH:mm:ss");  
	    Date day = new Date();  
	    int Day = Integer.parseInt((formatter.format(day)));  
		
		double balance = 0.0;
		if(account == account && Day == date && period > 0) {
			balance = retreiveDAO.getAccountBalance((int)account);
			balance -= damount;
			period--;
			
		}
		return balance;
	}
	
}
