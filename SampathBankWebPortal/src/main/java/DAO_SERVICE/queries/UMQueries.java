package DAO_SERVICE.queries;

public class UMQueries {
	public static final String queryUM_01 = "SELECT * FROM online_customer_credentials WHERE username=? AND password=?;";
	public static final String queryUM_02 = "SELECT * FROM online_employee_credentials WHERE username=? AND password=?;";
}
