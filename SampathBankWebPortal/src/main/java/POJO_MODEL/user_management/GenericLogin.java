package POJO_MODEL.user_management;

public class GenericLogin <T1, T2, T3, T4>{
	private T1 found;
	private T2 type;
	private T3 customer;
	private T4 employee;
	public T1 getFound() {
		return found;
	}
	public void setFound(T1 found) {
		this.found = found;
	}
	public T2 getType() {
		return type;
	}
	public void setType(T2 type) {
		this.type = type;
	}
	public T3 getCustomer() {
		return customer;
	}
	public void setCustomer(T3 customer) {
		this.customer = customer;
	}
	public T4 getEmployee() {
		return employee;
	}
	public void setEmployee(T4 employee) {
		this.employee = employee;
	}
}
