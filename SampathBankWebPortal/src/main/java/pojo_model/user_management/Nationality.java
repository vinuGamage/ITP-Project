package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Nationality {
	private int nationalityId;
	private String nationality;
	private Collection<Person> person = new ArrayList<Person> ();
	
	public Nationality() {}
	
	public Nationality(int nationalityId, String nationality) {
		this.setNationalityId(nationalityId);
		this.setNationality(nationality);
	}
	
	public Nationality(String nationality) {
		this.setNationality(nationality);
	}
	
	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}
	
	public int getNationalityId() {
		return nationalityId;
	}

	public String getNationality() {
		return this.nationality;
	}
	
	public Collection<Person> getPerson() {
		return person;
	}
	
	public void setSinglePerson(Person person) {
		person.setNationality(this);
	}
	
	public void setMultiplePersons(Person... persons) {
		for(Person person: persons) {
			person.setNationality(this);
		}
	}
}
