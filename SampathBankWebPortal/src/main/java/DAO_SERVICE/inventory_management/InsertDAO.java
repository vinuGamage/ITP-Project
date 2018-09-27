package DAO_SERVICE.inventory_management;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;;

public class InsertDAO {

	public static String query1="INSERT INTO  im_inventory_item VALUES(?,?,?,?,?,?,?)";
	public static String query2 ="INSERT INTO im_request_item VALUES(?,?,?,?,?,?)";
	public static String query3 ="INSERT INTO im_branch_item VALUES(?,?,?)";
	public static String query4 ="INSERT INTO im_history VALUES(?,?,?,?,?,?,?,?,?)";
	
	
	
	
	public static boolean insertNewItem(item i1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
		
		pst.setString(1, i1.getItemId());
		pst.setString(2, i1.getItemName());
		pst.setInt(3, i1.getItemQty());
		pst.setString(4, i1.getUnit());
		pst.setInt(5, i1.getItem_min());
		pst.setString(6, i1.getDescription());
		pst.setString(7, i1.getImage());
		
		pst.execute();
		return true;
		
	}
	
	public static boolean insertNewRequest(headRequestItem r1) throws SQLException, ClassNotFoundException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query2);
		
		pst.setString(1, r1.getRefId());
		pst.setString(2,r1.getHeadUsername());
		pst.setString(3,r1.getBranch());
		pst.setString(4,r1.getItemId());
		pst.setString(5, r1.getItemName());
		pst.setInt(6, r1.getReqAmount());
		
		pst.execute();
		return true;
		
		
		
		
	}
	
	public static boolean insertNewBranchItem(item i1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query3);
		
		pst.setString(1, i1.getItemId());
		pst.setString(2, i1.getItemName());
		pst.setInt(3, 0);
		pst.execute();
		return true;
		
		
	}
	
	public static boolean insertInsertHistory(HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);	
		  Date current = new Date( );
	      SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
	      
		pst.setString(1,GeneratePrimaryKey.generateHistoryId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,"New" );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		
		pst.execute();
		return true;
		
	}
	public static boolean insertUpdateHistory(HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		
		Date current = new Date( );
	    SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
		pst.setString(1,h1.getHistId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,h1.getAction() );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		pst.execute();
		return true;
	}
	
	public static boolean insertDeleteHistory (HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		
		Date current = new Date( );
	    SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
		
		pst.setString(1,h1.getHistId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,"Deleted" );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		pst.execute();
		return true;
	}
	
	public static boolean insertAddAmountHistory (HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		
		Date current = new Date( );
	    SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
		
		pst.setString(1,h1.getHistId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,h1.getAction() );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		pst.execute();
		return true;
	}
	
	public static boolean insertApproveItemHistory (HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		
		Date current = new Date( );
	    SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
		
		pst.setString(1,h1.getHistId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,h1.getAction() );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		pst.execute();
		return true;
	}
	
	public static boolean insertDisapproveItemHistory (HistoryItem h1) throws ClassNotFoundException, SQLException {
		Connection con = DBconnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query4);
		
		Date current = new Date( );
	    SimpleDateFormat ft =   new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a zzz");
		
		pst.setString(1,h1.getHistId());
		pst.setString(2,h1.getUsername());
		pst.setString(3, h1.getItemId());
		pst.setString(4, h1.getItemName());
		pst.setString(5,h1.getAction() );
		
		pst.setInt(6,h1.getQty());
		pst.setInt(7,h1.getFrom());
		pst.setInt(8, h1.getTo());
		pst.setString(9,ft.format(current));
		pst.execute();
		return true;
	}
	
}
