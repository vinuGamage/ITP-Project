package pojo_model.user_management;

public class Address {
	private String addStreet01;
	private String addStreet02;
	private String addCity;
	private String addProvince;
	private int zipCode;
	
	public Address() {}
	
	public Address(String addStreet01, String addStreet02, String addCity, String addProvince, int zipCode) {
		this.setAddStreet01(addStreet01.trim());
		
		if(addStreet02 == null || addStreet02.trim().length() == 0)
			this.setAddStreet02(null);
		else
			this.setAddStreet02(addStreet02.trim());
		
		this.setAddCity(addCity.trim());
		this.setAddProvince(addProvince.trim());
		this.setZipCode(zipCode);
	}
	
	public void setAddStreet01(String addStreet01) {
		this.addStreet01 = addStreet01;
	}
	
	public void setAddStreet02(String addStreet02) {
		this.addStreet02 = addStreet02;
	}
	
	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}
	
	public void setAddProvince(String addProvince) {
		this.addProvince = addProvince;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getAddStreet01() {
		return this.addStreet01;
	}
	
	public String getAddStreet02() {
		return this.addStreet02;
	}
	
	public String getAddCity() {
		return this.addCity;
	}
	
	public String getAddProvince() {
		return this.addProvince;
	}
	
	public int getZIPCode() {
		return this.zipCode;
	}
}