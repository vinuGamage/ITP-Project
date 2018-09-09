package DAO_SERVICE.employee_hr_payroll_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import POJO_MODEL.employee_hr_payroll_management.generators.KeyFix;

public class PrimaryKeyGeneratorDAO {
	static Connection con = null;
	
	public static String EmployeePrimaryKeyGenerator() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		PreparedStatement EHPMprst0001 = null;
		ResultSet EHPMresultSet0001 = null;
		String nextId = null;
		boolean bool = true;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPMprst0001 = con.prepareStatement(EHPMQueries.EHPMquery0001);
			EHPMresultSet0001 = EHPMprst0001.executeQuery();
			
			if(EHPMresultSet0001.next()) {
				nextId = EHPMresultSet0001.getString(1);
				bool = EmployeePrimaryKeyIncrementor(nextId);
				if(bool)
					System.out.println("Updated the employeePrimaryKey successfully.");
				else
					System.out.println("EmployeePrimaryKey not updated.");
			}
			else
				nextId = null;////////////////////////////////////////////////DO SOMETHING ABOUT THIS
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyGenerator()");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyGenerator()");
		} finally {
			try {
				if(EHPMresultSet0001 != null)
					EHPMresultSet0001.close();
				
				if(EHPMprst0001 != null)
					EHPMprst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return nextId;////////////////////////////////////////////////DO SOMETHING ABOUT THIS
	}
	
	private static boolean EmployeePrimaryKeyIncrementor(String oldPrimarykey) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		PreparedStatement EHPMprst0002 = null;
		ResultSet EHPMresultSet0002 = null;
		int i = 0;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPMprst0002 = con.prepareStatement(EHPMQueries.EHPMquery0002);
			EHPMprst0002.setString(1, KeyFix.Char10Increment(oldPrimarykey));
			i = EHPMprst0002.executeUpdate();
			
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyIncrementor()");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyIncrementor()");
		} finally {
			try {
				if(EHPMresultSet0002 != null)
					EHPMresultSet0002.close();
				
				if(EHPMprst0002 != null)
					EHPMprst0002.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(i == 0)
			return false;
		else
			return true;
	}

	public static int LeaveRequestKeyGenerator() {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		PreparedStatement EHPMprst0001 = null;
		ResultSet EHPMresultSet0001 = null;
		int nextId = 1;
		boolean bool = true;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPMprst0001 = con.prepareStatement(EHPMQueries.EHPMquery0019);
			EHPMresultSet0001 = EHPMprst0001.executeQuery();
			
			if(EHPMresultSet0001.next()) {
				nextId=0;
				nextId = EHPMresultSet0001.getInt("leaveRequestId");
				bool = LeaveRequestPrimaryKeyIncrementor(nextId);
				if(bool)
					System.out.println("Updated theLeaveRequestId successfully.");
				else
					System.out.println("LeaveRequestId not updated.");
			}
			else
				nextId = 1;////////////////////////////////////////////////DO SOMETHING ABOUT THIS
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Problem in LeaveRequestIdGenerator()");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in LeaveRequestIdGenerator()");
		} finally {
			try {
				if(EHPMresultSet0001 != null)
					EHPMresultSet0001.close();
				
				if(EHPMprst0001 != null)
					EHPMprst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return nextId;////////////////////////////////////////////////DO SOMETHING ABOUT THIS
	}
	
	private static boolean LeaveRequestPrimaryKeyIncrementor(int oldPrimarykey) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		PreparedStatement EHPMprst0002 = null;
		ResultSet EHPMresultSet0002 = null;
		int i = 0;
		
		try {
			DataSource dataSource = cpmObj.initializePool();
			cpmObj.printDatabaseStatus();
			
			con = dataSource.getConnection();
			cpmObj.printDatabaseStatus();
			
			EHPMprst0002 = con.prepareStatement(EHPMQueries.EHPMquery0020);
			EHPMprst0002.setInt(1, KeyFix.IntIncrement(oldPrimarykey));
			i = EHPMprst0002.executeUpdate();
			
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyIncrementor()");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in EmployeePrimaryKeyIncrementor()");
		} finally {
			try {
				if(EHPMresultSet0002 != null)
					EHPMresultSet0002.close();
				
				if(EHPMprst0002 != null)
					EHPMprst0002.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(i == 0)
			return false;
		else
			return true;
	}
}
