package DAO_SERVICE.user_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.UMQueries;

public class CustomerRegistrationDAO {
	private static Connection con = null;
	
	public static String checkData(String regNic, Date regDOB01, int regZIP01, String regPersonalEmail, int regAccountNo01) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		String custId = null;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_07);
			UM_Pr.setString(1, regNic);
			UM_Pr.setDate(2, regDOB01);
			UM_Pr.setInt(3, regZIP01);
			UM_Pr.setString(4, regPersonalEmail);
			UM_Pr.setInt(5, regAccountNo01);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				if(UM_RS.getString("nic").equals(regNic) && UM_RS.getDate("dateOfBirth").equals(regDOB01) && UM_RS.getInt("addressZipCode") == regZIP01 && UM_RS.getString("personalEmail").equals(regPersonalEmail) && UM_RS.getInt("accountNo") == regAccountNo01) {
					custId = UM_RS.getString("customerId");
				}
			} else {
				custId = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return custId;
	}

	public static boolean checkOnlineAccount(String custId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		boolean a = true; //true indicates not having an online account yet
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_08);
			UM_Pr.setString(1, custId);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				a = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return a;
	}

	public static boolean checkRegistrationRequest(String custId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		boolean a = true; //true indicates not having a request yet
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_09);
			UM_Pr.setString(1, custId);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				a = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return a;
	}

	public static boolean checkForTempOnlinePinData(String custId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		boolean a = true; //true indicates not having a pin assigned
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_10);
			UM_Pr.setString(1, custId);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				a = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return a;
	}

	public static boolean insertOnlinePinData(String custId, int onlineRegPin) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		int  i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_11);
			UM_Pr.setString(1, custId);
			UM_Pr.setInt(2, onlineRegPin);
			
			i = UM_Pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
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

	public static boolean updateOnlinePinData(String custId, int onlineRegPin) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int  i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_12);
			UM_Pr.setInt(1, onlineRegPin);
			UM_Pr.setString(2, custId);
			
			i = UM_Pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
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

	public static boolean validateOnlineRegPin(String custId, int onlineRegPin) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		ResultSet UM_RS = null;
		boolean i = false;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_13);
			UM_Pr.setString(1, custId);
			UM_Pr.setInt(2, onlineRegPin);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				if(UM_RS.getInt("onlineRegPin") == onlineRegPin)
					i = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_RS != null)
					UM_RS.close();
				
				if(UM_Pr != null)
					UM_Pr.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return i;
	}

	public static boolean storeRequestForCustomerOnlineAccount(String custId, String question01, String answer01, String question02, String answer02) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int  i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_14);
			UM_Pr.setString(1, custId);
			UM_Pr.setString(2, question01);
			UM_Pr.setString(3, answer01);
			UM_Pr.setString(4, question02);
			UM_Pr.setString(5, answer02);
			
			i = UM_Pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
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

	public static boolean deleteFromTempOnlineRegPins(String custId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int  i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_15);
			UM_Pr.setString(1, custId);
			
			i = UM_Pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(UM_Pr != null)
					UM_Pr.close();
				
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
