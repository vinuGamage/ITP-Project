package DAO_SERVICE.queries;

public class UMQueries {
	public static final String queryUM_01 = "SELECT * FROM online_customer_credentials WHERE username=? AND password=?;";
	public static final String queryUM_02 = "SELECT * FROM online_employee_credentials WHERE username=? AND password=?;";
	public static final String queryUM_03 = "SELECT * FROM person p INNER JOIN employee e ON p.personId = e.employeeId WHERE e.employeeId=?;";
	public static final String queryUM_04 = "SELECT * FROM online_security_key WHERE onlineSecurityId=?;";
	public static final String queryUM_06 = "SELECT * FROM person p INNER JOIN customer c ON p.personId = c.customerId INNER JOIN accounts a ON c.customerId = a.personId WHERE c.customerId=?;";
	public static final String queryUM_07 = "SELECT * FROM person p INNER JOIN customer c ON p.personId = c.customerId INNER JOIN accounts a ON c.customerId=a.personId WHERE p.nic=? AND p.dateOfBirth=? AND p.addressZipCode=? AND p.personalEmail=? AND a.accountNo=?;";
	public static final String queryUM_08 = "SELECT * FROM online_customer_credentials WHERE customerId=?;";
	public static final String queryUM_09 = "SELECT * FROM customer_registration_requests WHERE customerId=?;";
	public static final String queryUM_10 = "SELECT * FROM temp_customer_online_reg_pins WHERE customerId=?;";
	public static final String queryUM_11 = "INSERT INTO temp_customer_online_reg_pins(customerId, onlineRegPin) VALUES(?, ?);";
	public static final String queryUM_12 = "UPDATE temp_customer_online_reg_pins SET onlineRegPin=? WHERE customerId=?;";
	public static final String queryUM_13 = "SELECT * FROM temp_customer_online_reg_pins WHERE customerId=? AND onlineRegPin=?;";
	public static final String queryUM_14 = "INSERT INTO customer_registration_requests(customerId, question01, answer01, question02, answer02) VALUES (?, ?, ?, ?, ?);";
	public static final String queryUM_15 = "DELETE FROM temp_customer_online_reg_pins WHERE customerId=?;";
	public static final String queryUM_16 = "SELECT * FROM person p INNER JOIN customer_registration_requests c ON p.personId=c.customerId;";
	public static final String queryUM_17 = "SELECT nextOnlineCustomerId FROM next_primary_keys;";
	public static final String queryUM_18 = "UPDATE next_primary_keys SET nextOnlineCustomerId=? WHERE primaryKey=1;";
	public static final String queryUM_19 = "INSERT INTO online_security_key(onlineSecurityId, onlineSecurityKey) VALUES(?, ?);";
	public static final String queryUM_20 = "SELECT * FROM person p INNER JOIN customer_registration_requests c ON p.personId=c.customerId WHERE c.customerID=?;";
	public static final String queryUM_21 = "INSERT INTO online_customer_credentials(onlineCustomerId, customerId, username, password, question01, answer01, question02, answer02) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String queryUM_22 = "UPDATE person SET onlineRegistrationDate=?, onlineSecurityId=? WHERE personId=?;";
	public static final String queryUM_23 = "DELETE FROM customer_registration_requests WHERE customerId=?;";
	public static final String queryUM_24 = "SELECT * FROM person p INNER JOIN customer c ON p.personId = c.customerId WHERE personId LIKE ? OR firstName LIKE ? OR middleName LIKE ? OR lastName LIKE ? OR otherNames LIKE ? OR addressStreet01 LIKE ? OR addressStreet02 LIKE ? OR addressCity LIKE ? OR addressProvince LIKE ? OR addressZipCode LIKE ? OR nic LIKE ? OR personalEmail LIKE ? OR branchId LIKE ? OR homeContact LIKE ? OR mobileContact LIKE ?;";
	public static final String queryUM_25 = "SELECT companyEmail FROM employee WHERE companyEmail = ?;";
	public static final String queryUM_26 = "INSERT INTO email_company(sender, receiver, subject, content, sentDate) VALUES(?, ?, ?, ?, ?);";
	public static final String queryUM_27 = "SELECT * FROM email_company WHERE receiver = ?;";
	public static final String queryUM_28 = "UPDATE email_company SET receiver = NULL WHERE emailId = ?;";
	public static final String queryUM_29 = "SELECT * FROM email_company WHERE sender = ?;";
	public static final String queryUM_30 = "UPDATE email_company SET sender = NULL WHERE emailId = ?;";
}