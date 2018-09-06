package POJO_MODEL.user_management;

public class Nationality {
	private int nationalityId;
	private String nationality;
	
	public Nationality() {}
	
	public Nationality(int nationalityId, String nationality) {
		this.setNationalityId(nationalityId);
		this.setNationality(nationality);
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
