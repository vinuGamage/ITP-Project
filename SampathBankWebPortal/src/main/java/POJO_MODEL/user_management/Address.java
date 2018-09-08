package POJO_MODEL.user_management;

public class Address {
	private String addressStreet01;
	private String addressStreet02;
	private String addressCity;
	private String addressProvince;
	private int addressZipCode;
	
	public Address() {}
	
	public Address(String addressStreet01, String addressStreet02, String addressCity, String addressProvince, 
			int addressZipCode) {
		this.setAddStreet01(addressStreet01.trim());
		
		if(addressStreet02 == null || addressStreet02.trim().length() == 0)
			this.setAddStreet02(null);
		else
			this.setAddStreet02(addressStreet02.trim());
		
		this.setAddressCity(addressCity.trim());
		this.setAddressProvince(addressProvince.trim());
		this.setAddressZipCode(addressZipCode);
	}
	
	public void setAddStreet01(String addressStreet01) {
		this.addressStreet01 = addressStreet01;
	}
	
	public void setAddStreet02(String addressStreet02) {
		this.addressStreet02 = addressStreet02;
	}
	
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}
	
	public void setAddressZipCode(int addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
	
	public String getAddressStreet01() {
		return this.addressStreet01;
	}
	
	public String getAddressStreet02() {
		return this.addressStreet02;
	}
	
	public String getAddressCity() {
		return this.addressCity;
	}
	
	public String getAddressProvince() {
		return this.addressProvince;
	}
	
	public int getAddressZIPCode() {
		return this.addressZipCode;
	}
	
	public void displayAddress() {
		System.out.println("============Address : ============");
		System.out.println(this.getAddressStreet01());
		System.out.println(this.getAddressStreet02());
		System.out.println(this.getAddressCity());
		System.out.println(this.getAddressProvince());
		System.out.println(this.getAddressZIPCode());
	}
}