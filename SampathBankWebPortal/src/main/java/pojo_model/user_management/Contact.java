package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Contact {
	private String email;
	private Collection<ContactNumber> contactNumberList = new ArrayList<ContactNumber>();
	
	public Contact() {}
	
	public Contact(String email, String contactNumberHome, String contactNumberMobile) {
		this.setPersonalEmail(email.trim());
		this.setContactNumber(contactNumberHome.trim(), contactNumberMobile.trim());
	}
	
	public void setPersonalEmail(String email) {
		this.email = email;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public Collection<ContactNumber> getContactNumberList() {
		return this.contactNumberList;
	}
	
	public void insertContactNumberList(ContactNumber contactNumber) {
		this.contactNumberList.add(contactNumber);
	}
}
