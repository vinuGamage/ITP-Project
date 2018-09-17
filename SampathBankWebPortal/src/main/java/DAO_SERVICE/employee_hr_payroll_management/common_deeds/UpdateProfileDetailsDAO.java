package DAO_SERVICE.employee_hr_payroll_management.common_deeds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.EHPMQueries;
import POJO_MODEL.employee_hr_payroll_management.LeaveDetails;
import POJO_MODEL.user_management.Updation;

public class UpdateProfileDetailsDAO {
	private static Connection con = null;
	
	public static boolean checkOldPassword(String employeeId, String oldPassword) {
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		
		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		boolean bool = false;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0042);
			EHPM_Prst0001.setString(1, employeeId);
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next()) {
				String retrievedOldPassword = EHPM_ResultSet0001.getString("password");
				
				if(retrievedOldPassword.equals(oldPassword))
					bool = true;
				else
					bool = false;
			} else {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return bool;
	}
	
	public static boolean updatePassword(String employeeId, String newPassword) {
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		
		PreparedStatement EHPM_Prst0001 = null;
		int i = 0;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0043);
			EHPM_Prst0001.setString(1, newPassword);
			EHPM_Prst0001.setString(2, employeeId);
			i = EHPM_Prst0001.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
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
	
	public static boolean updateAddressRequest(Updation updation) {
		boolean bool = checkTableForEntry(updation);
		
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		if(bool) {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0046);
				EHPM_Prst0001.setString(1,  updation.getAddressStreet01());
				EHPM_Prst0001.setString(2,  updation.getAddressStreet02());
				EHPM_Prst0001.setString(3,  updation.getAddressCity());
				EHPM_Prst0001.setString(4,  updation.getAddressProvince());
				EHPM_Prst0001.setInt(5,  updation.getAddressZIP());
				EHPM_Prst0001.setString(6, updation.getPersonId());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
					
		} else {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0045);
				EHPM_Prst0001.setString(1,  updation.getPersonId());
				EHPM_Prst0001.setString(2,  updation.getAddressStreet01());
				EHPM_Prst0001.setString(3,  updation.getAddressStreet02());
				EHPM_Prst0001.setString(4,  updation.getAddressCity());
				EHPM_Prst0001.setString(5,  updation.getAddressProvince());
				EHPM_Prst0001.setInt(6, updation.getAddressZIP());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
	
	public static boolean checkTableForEntry(Updation updation) {
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		
		PreparedStatement EHPM_Prst0001 = null;
		ResultSet EHPM_ResultSet0001 = null;
		int i = 0;
		boolean bool = false;
		
		try {
			EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0044);
			EHPM_Prst0001.setString(1, updation.getPersonId());
			EHPM_ResultSet0001 = EHPM_Prst0001.executeQuery();
			
			if(EHPM_ResultSet0001.next())
				bool = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(EHPM_ResultSet0001 != null)
					EHPM_ResultSet0001.close();
				
				if(EHPM_Prst0001 != null)
					EHPM_Prst0001.close();
				
				if(con != null)
					con.close();
			} catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		return bool;
	}
	
	public static boolean updatePersonalEmailRequest(Updation updation) {
		boolean bool = checkTableForEntry(updation);
		
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		if(bool) {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0048);
				EHPM_Prst0001.setString(1,  updation.getPersonalEmail());
				EHPM_Prst0001.setString(2,  updation.getPersonId());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
					
		} else {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0047);
				EHPM_Prst0001.setString(1,  updation.getPersonId());
				EHPM_Prst0001.setString(2,  updation.getPersonalEmail());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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

	public static boolean updateHomeCotactRequest(Updation updation) {
		boolean bool = checkTableForEntry(updation);
		
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		if(bool) {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0050);
				EHPM_Prst0001.setString(1,  updation.getHomeContact());
				EHPM_Prst0001.setString(2,  updation.getPersonId());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
					
		} else {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0049);
				EHPM_Prst0001.setString(1,  updation.getPersonId());
				EHPM_Prst0001.setString(2,  updation.getHomeContact());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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

	public static boolean updateMobileCotactRequest(Updation updation) {
		boolean bool = checkTableForEntry(updation);
		
		//Conneciton Managing Start
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cpmObj.printDatabaseStatus();
		//Conneciton Managing End
		
		if(bool) {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0052);
				EHPM_Prst0001.setString(1,  updation.getMobileContact());
				EHPM_Prst0001.setString(2,  updation.getPersonId());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
					
		} else {
			PreparedStatement EHPM_Prst0001 = null;
			int i = 0;
			
			try {
				EHPM_Prst0001 = con.prepareStatement(EHPMQueries.EHPMquery0051);
				EHPM_Prst0001.setString(1,  updation.getPersonId());
				EHPM_Prst0001.setString(2,  updation.getMobileContact());
				
				i = EHPM_Prst0001.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(EHPM_Prst0001 != null)
						EHPM_Prst0001.close();
					
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
}
