package POJO_MODEL.user_management;

import java.sql.Date;

public class RegistrationDates {
	private Date physicalRegistrationDate;
	private Date onlineRegistrationDate;
	
	public RegistrationDates() {}

	public RegistrationDates(Date physicalRegistrationDate, Date onlineRegistrationDate) {
		this.physicalRegistrationDate = physicalRegistrationDate;
		this.onlineRegistrationDate = onlineRegistrationDate;
	}

	public Date getPhysicalRegistrationDate() {
		return physicalRegistrationDate;
	}

	public void setPhysicalRegistrationDate(Date physicalRegistrationDate) {
		this.physicalRegistrationDate = physicalRegistrationDate;
	}

	public Date getOnlineRegistrationDate() {
		return onlineRegistrationDate;
	}

	public void setOnlineRegistrationDate(Date onlineRegistrationDate) {
		this.onlineRegistrationDate = onlineRegistrationDate;
	}
}
