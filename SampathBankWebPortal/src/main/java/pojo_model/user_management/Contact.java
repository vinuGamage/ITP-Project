package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Contact {
	private String personalEmail;
	private Collection<ContactNumber> contactNumberList = new ArrayList<ContactNumber>();
	
	public Contact() {}
	
	public Contact(String personalEmail, String contactNumberHome, String contactNumberMobile) {
		this.setPersonalEmail(personalEmail.trim());
		this.setContactNumber(contactNumberHome.trim(), contactNumberMobile.trim());
	}
	
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	
	public void setContactNumber(String contactNumberHome, String contactNumberMobile) {
		ContactNumber contactNumber = null;
		String number = contactNumberHome;
		String type = "Home";
		for(int i = 0; i < 2; i++) {
			if(number != null && number.length() > 0) {
				contactNumber = new ContactNumber(number, type);
				this.insertContactNumberList(contactNumber);
			}
			number = contactNumberMobile;
			type="Mobile";
		}	
	}
	
	public String getPersonalEmail() {
		return this.personalEmail;
	}
	
	public Collection<ContactNumber> getContactNumberList() {
		return this.contactNumberList;
	}
	
	public void insertContactNumberList(ContactNumber contactNumber) {
		this.contactNumberList.add(contactNumber);
	}
}
