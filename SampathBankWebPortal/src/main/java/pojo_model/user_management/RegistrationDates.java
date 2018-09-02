package pojo_model.user_management;

import java.sql.Date;

public class RegistrationDates {
	private Date phyRegDate;
	private Date onlineRegDate;
	
	public RegistrationDates() {}
	
	public RegistrationDates(Date phyRegDate, Date onlineRegDate) {
		this.setPhyRegDate(phyRegDate);
		this.setOnlineRegDate(onlineRegDate);
	}

	public void setPhyRegDate(Date phyRegDate) {
		this.phyRegDate = phyRegDate;
	}

	public void setOnlineRegDate(Date onlineRegDate) {
		this.onlineRegDate = onlineRegDate;
	}
	
	public Date getPhyRegDate() {
		return this.phyRegDate;
	}

	public Date getOnlineRegDate() {
		return this.onlineRegDate;
	}
}
