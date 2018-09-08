package DAO_SERVICE.queries;

public class UMQueries {
	public static final String queryUM_01 = "SELECT * FROM online_customer_credentials WHERE username=? AND password=?;";
	public static final String queryUM_02 = "SELECT * FROM online_employee_credentials WHERE username=? AND password=?;";
	public static final String queryUM_03 = "SELECT * FROM person p INNER JOIN employee e ON p.personId = e.employeeId WHERE e.employeeId=?;";
	public static final String queryUM_04 = "SELECT * FROM online_security_key WHERE onlineSecurityId=?;";
	public static final String queryUM_05 = "SELECT * FROM person_contact WHERE personId=?;";
}
