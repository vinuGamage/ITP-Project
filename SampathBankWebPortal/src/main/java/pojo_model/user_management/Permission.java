package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Permission {
	private int permissionLevel;
	private String permissionType;
	private Collection<Person> person = new ArrayList<Person> ();
	
	public Permission() {}
	
	public Permission(int permissionLevel, String permissionType) {
		this.setPermissionLevel(permissionLevel);
		this.setPermissionType(permissionType);
	}
	
	public Permission(String permissionType) {
		this.setPermissionType(permissionType);
	}

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}

	public int getPermissionLevel() {
		return this.permissionLevel;
	}

	public String getPermissionType() {
		return this.permissionType;
	}
	
	public Collection<Person> getPerson() {
		return person;
	}

//	public void setSinglePerson(Person person) {
//		person.setPermission(this);
//	}
//	
//	public void setMultiplePersons(Person... persons) {
//		for(Person person: persons) {
//			person.setPermission(this);
//		}
//	}
}
