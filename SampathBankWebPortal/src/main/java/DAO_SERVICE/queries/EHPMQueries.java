package DAO_SERVICE.queries;

public class EHPMQueries {
	public static final String EHPMquery0001 = "SELECT employeePrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0002 = "UPDATE next_primary_keys SET employeePrimaryKey=? WHERE primaryKey=1;";
	public static final String EHPMquery0003 = "SELECT customerPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0004 = "SELECT genderPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0005 = "SELECT nationalityPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0006 = "SELECT branchPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0007 = "SELECT onlineSecurityKeyPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0008 = "SELECT permissionPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0009 = "SELECT departmentPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0010 = "SELECT designationPrimaryKey FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0011 = "SELECT * FROM gender;";
	public static final String EHPMquery0012 = "SELECT * FROM nationality;";
	public static final String EHPMquery0013 = "SELECT * FROM permission;";
	public static final String EHPMquery0014 = "SELECT * FROM branch;";
	public static final String EHPMquery0015 = "SELECT * FROM department;";
	public static final String EHPMquery0016 = "SELECT * FROM designation;";
	public static final String EHPMquery0017 = "SELECT * FROM leave_days;";
	public static final String EHPMquery0018 = "SELECT * FROM leave_details WHERE employeeId=?;";
	public static final String EHPMquery0019 = "SELECT leaveRequestId FROM next_primary_keys WHERE primaryKey=1;";
	public static final String EHPMquery0020 = "UPDATE next_primary_keys SET leaveRequestId=? WHERE primaryKey=1;";
	public static final String EHPMquery0021 = "INSERT INTO leave_request(employeeId, leaveRequestId, leaveType, leaveDescription, leaveRequestedDate, leaveStartDate, leaveFinishDate, leaveStatus) VALUES(?,?,?,?,?,?,?,?);";
	public static final String EHPMquery0022 = "SELECT * FROM leave_request WHERE employeeId=?;";
}
