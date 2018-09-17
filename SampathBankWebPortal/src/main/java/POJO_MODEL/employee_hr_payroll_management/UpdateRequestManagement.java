package POJO_MODEL.employee_hr_payroll_management;

import java.util.Collection;

import POJO_MODEL.user_management.Updation;

public class UpdateRequestManagement {
	private Collection<Employee> employeeList;
	private Collection<Updation> UpdateList;
	
	public Collection<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Collection<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Collection<Updation> getUpdateList() {
		return UpdateList;
	}
	public void setUpdateList(Collection<Updation> updateList) {
		UpdateList = updateList;
	}
}
