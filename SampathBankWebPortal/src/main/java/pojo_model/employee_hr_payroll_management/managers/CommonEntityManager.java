package pojo_model.employee_hr_payroll_management.managers;

import java.util.ArrayList;
import java.util.Collection;

import pojo_model.employee_hr_payroll_management.Branch;
import pojo_model.employee_hr_payroll_management.Department;
import pojo_model.user_management.Gender;
import pojo_model.user_management.Nationality;
import pojo_model.user_management.Role;

public class CommonEntityManager {
	private Collection<Gender> genderList = new ArrayList<Gender> ();
	private Collection<Nationality> nationalityList = new ArrayList<Nationality> ();
	private Collection<Role> roleList = new ArrayList<Role> ();
	private Collection<Branch> BranchList = new ArrayList<Branch> ();
	private Collection<Department> DepartmentList = new ArrayList<Department> ();
	
	public Gender getGender(String gender) {
		if(gender.equalsIgnoreCase("MALE"))
			return new Gender(1, "male");
		else if(gender.equalsIgnoreCase("FEMALE"))
			return new Gender(2, "female");
		else
			return new Gender();
	}
	
	public Nationality getNationality(String nationality) {
		if(nationality.equalsIgnoreCase("SINHALESE"))
			return new Nationality(1, "sinhala");
		else if(nationality.equalsIgnoreCase("TAMIL"))
			return new Nationality(2, "tamil");
		else if(nationality.equalsIgnoreCase("MUSLIM"))
			return new Nationality(3, "muslim");
		else
			return new Nationality();	
	}
	
	public Role getRole(String role) {
		if(role.equalsIgnoreCase("NORMAL EMPLOYEE"))
			return new Role(1, "normal employee", "employee");
		else
			return new Role();
	}
	
	public Branch getBranch(String branch) {
		if(branch.equalsIgnoreCase("MAHARAGAMA"))
			return new Branch("ABCD0001", "87", "abc", "maharagama", "western", 10280, "as");
		else
			return new Branch();
	}
	
	public Department getDepartment(String department) {
		if(department.equalsIgnoreCase("IT"))
				return new Department("it");
		else
			return new Department();
	}
}
