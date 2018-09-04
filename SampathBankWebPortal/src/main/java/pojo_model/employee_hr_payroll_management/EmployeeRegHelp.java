package pojo_model.employee_hr_payroll_management;

public class EmployeeRegHelp<T1, T2> {
	T1 x;
	T2 y;
	
	public EmployeeRegHelp(T1 x, T2 y) {
		this.setX(x);
		this.setY(y);
	}

	public T1 getX() {
		return x;
	}

	public void setX(T1 x) {
		this.x = x;
	}

	public T2 getY() {
		return y;
	}

	public void setY(T2 y) {
		this.y = y;
	}
}
