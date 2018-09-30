package DAO_SERVICE.user_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import DAO_SERVICE.common_service.ConnectionPoolManager;
import DAO_SERVICE.queries.UMQueries;
import POJO_MODEL.user_management.Email;

public class EmailDAO {
	private static Connection con = null;
	
	public static boolean checkForReceiver(String receiver) {
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
		boolean bool = false;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_25);
			UM_Pr.setString(1, receiver);
			
			UM_RS = UM_Pr.executeQuery();
			
			if(UM_RS.next()) {
				if(UM_RS.getString("companyEmail").equals(receiver))
					bool = true;
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
		
		return bool;
	}
	
	public static boolean storeComposeEmail(Email email) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_26);
			UM_Pr.setString(1, email.getSender());
			UM_Pr.setString(2, email.getReceiver());
			UM_Pr.setString(3, email.getSubject());
			UM_Pr.setString(4, email.getContent());
			UM_Pr.setDate(5, email.getSentDate());
			
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

	public static Collection<Email> inboxRetrieve(String receiver) {
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
		Collection<Email> inboxList = new ArrayList<Email> ();
		Email email = null;
		int i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_27);
			UM_Pr.setString(1, receiver);
			
			UM_RS = UM_Pr.executeQuery();
			
			while(UM_RS.next()) {
				if(UM_RS.getString("receiver").equals(receiver)) {
					email = new Email(UM_RS.getInt("emailId"), UM_RS.getString("sender"), UM_RS.getString("receiver"), UM_RS.getString("subject"), UM_RS.getString("content"), UM_RS.getDate("sentDate"));
					
					inboxList.add(email);
					i++;
					System.out.println("MEMMEE");
				}
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
		
		if(i == 0)
			inboxList = null;
		
		return inboxList;
	}

	public static boolean deleteFromInbox(int emailId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_28);
			UM_Pr.setInt(1, emailId);
			
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

	public static Collection<Email> outboxRetrieve(String sender) {
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
		Collection<Email> outboxList = new ArrayList<Email> ();
		Email email = null;
		int i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_29);
			UM_Pr.setString(1, sender);
			
			UM_RS = UM_Pr.executeQuery();
			
			while(UM_RS.next()) {
				if(UM_RS.getString("sender").equals(sender)) {
					email = new Email(UM_RS.getInt("emailId"), UM_RS.getString("sender"), UM_RS.getString("receiver"), UM_RS.getString("subject"), UM_RS.getString("content"), UM_RS.getDate("sentDate"));
					
					outboxList.add(email);
					i++;
				}
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
		
		if(i == 0)
			outboxList = null;
		
		return outboxList;
	}
	
	public static boolean deleteFromOutbox(int emailId) {
		ConnectionPoolManager cpmObj = new ConnectionPoolManager();
		DataSource dataSource = null;
		try {
			dataSource = cpmObj.initializePool();
			con = dataSource.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		PreparedStatement UM_Pr = null;
		int i = 0;
		
		try {
			UM_Pr = con.prepareStatement(UMQueries.queryUM_30);
			UM_Pr.setInt(1, emailId);
			
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
