package POJO_MODEL.user_management;

import java.sql.Date;

public class RegistrationDates {
	private int registrationDatesId;
	private Date physicalRegistrationDate;
	private Date onlineRegistrationDate;
	
	public RegistrationDates() {}

	public RegistrationDates(int registrationDatesId, Date physicalRegistrationDate, Date onlineRegistrationDate) {
		this.registrationDatesId = registrationDatesId;
		this.physicalRegistrationDate = physicalRegistrationDate;
		this.onlineRegistrationDate = onlineRegistrationDate;
	}
	
	public int getRegistrationDatesId() {
		return registrationDatesId;
	}

	public void setRegistrationDatesId(int registrationDatesId) {
		this.registrationDatesId = registrationDatesId;
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
