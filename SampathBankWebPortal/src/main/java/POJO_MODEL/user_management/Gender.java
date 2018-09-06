package POJO_MODEL.user_management;

public class Gender {
	private int genderId;
	private String gender;

	public Gender() {}
	
	public Gender(int genderId, String gender) {
		this.setGenderId(genderId);
		this.setGender(gender);
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
