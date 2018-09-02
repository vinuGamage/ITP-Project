package pojo_model.user_management;

import java.util.ArrayList;
import java.util.Collection;

public class Role {
	private int roleId;
	private String roleGroup;
	private String role;
	private Collection<Person> person = new ArrayList<Person>();
	
	public Role() {}

	public Role(int roleId,  String roleGroup, String role) {
		this.setRoleId(roleId);
		this.setRoleGroup(roleGroup);
		this.setRole(role);
	}
	
	public Role(String role, String roleGroup) {
		this.setRole(role);
		this.setRoleGroup(roleGroup);
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public void setRoleGroup(String roleGroup) {
		this.roleGroup = roleGroup;
	}
	
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}
	
	public String getRole() {
		return this.role;
	}

	public String getRoleGroup() {
		return this.roleGroup;
	}
	
	public Collection<Person> getPerson() {
		return person;
	}
	
	public void setSinglePerson(Person person) {
		person.setRole(this);
	}
	
	public void setMultiplePersons(Person... persons) {
		for(Person person: persons) {
			person.setRole(this);
		}
	}
}
