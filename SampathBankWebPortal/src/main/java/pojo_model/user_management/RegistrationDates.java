package pojo_model.user_management;

import java.sql.Date;

public class RegistrationDates {
	private Date physicalRegistrationDate;
	private Date onlineRegistrationDate;
	
	public RegistrationDates() {}
	
	public RegistrationDates(Date physicalRegistrationDate, Date onlineRegistrationDate) {
		this.setPhysicalRegistrationDate(physicalRegistrationDate);
		this.setOnlineRegistrationDate(onlineRegistrationDate);
	}
	
	public void setPhysicalRegistrationDate(Date physicalRegistrationDate) {
		this.physicalRegistrationDate = physicalRegistrationDate;
	}

	public void setOnlineRegistrationDate(Date onlineRegistrationDate) {
		this.onlineRegistrationDate = onlineRegistrationDate;
	}

	public Date getPhysicalRegistrationDate() {
		return physicalRegistrationDate;
	}

	public Date getOnlineRegistrationDate() {
		return onlineRegistrationDate;
	}
}
