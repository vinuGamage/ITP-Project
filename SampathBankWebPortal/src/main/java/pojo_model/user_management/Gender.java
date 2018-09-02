package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Gender {
	private int genderId;
	private String gender;
	private Collection<Person> person = new ArrayList<Person>();

	public Gender() {}
	
	public Gender(int genderId, String gender) {
		this.setGenderId(genderId);
		this.setGender(gender);
	}
	
	public Gender(String gender) {
		this.setGender(gender);
	}
	
	public void setGenderId(int genderId) {
		this.genderId = genderId; 
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getGenderId() {
		return this.genderId;
	}
	
	public String getGender() {
		return this.gender;
	}

	public Collection<Person> getPerson() {
		return this.person;
	}
	
	public void setSinglePerson(Person person) {
		person.setGender(this);
	}
	
	public void setMultiplePersons(Person... persons) {
		for(Person person: persons) {
			person.setGender(this);
		}
	}
}
