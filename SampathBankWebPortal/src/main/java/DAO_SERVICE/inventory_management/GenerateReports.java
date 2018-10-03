package DAO_SERVICE.inventory_management;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import POJO_MODEL.inventory_management.HistoryItem;
import POJO_MODEL.inventory_management.headRequestItem;
import POJO_MODEL.inventory_management.item;
import sun.security.jca.GetInstance;

public class GenerateReports {

	
	public static boolean FullItemHistory(String path) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		
		PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
		document.open();
		
		try {
			BaseFont base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
		
		
		Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
		Font hfont = new Font(base, 10, Font.BOLD);
		Font dfont = new Font(base, 10, Font.NORMAL);
		Image img  = Image.getInstance("C:\\Users\\isuru\\git\\ITP-2018-MLB-G3-10\\SampathBankWebPortal\\src\\main\\webapp\\resources\\images\\sampathbanklogo\\SampathBankLogo01.png"); 
		img.scaleToFit(110,110);
		img.setAlignment(Element.ALIGN_RIGHT);
//         img.setAbsolutePosition(390, 720);
         
         Paragraph p2 = new Paragraph();
         p2.add(img);
     
         document.add(p2);
//		Paragraph p1 = new Paragraph("Full History in Inventory Management System");
//		
//		p1.setFont(pfont);
//		p1.setAlignment(Element.ALIGN_CENTER);

		document.add(new Paragraph("Full History in Inventory Management System",pfont));
		
		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(110);
		
		
		table.setSpacingAfter(11f);
		table.setSpacingBefore(11f);
		
		
		float [] colWidth = {1.5f,1.8f,1.3f,2f,3.5f,1.5f,1.25f,1.25f,2.5f};
		table.setWidths(colWidth);
		PdfPCell ch1=new PdfPCell (new Paragraph("HistoryID",hfont));
		PdfPCell ch2=new PdfPCell (new Paragraph("Username",hfont));
		PdfPCell ch3=new PdfPCell (new Paragraph("ItemID",hfont));
		PdfPCell ch4=new PdfPCell (new Paragraph("Item Name",hfont));
		PdfPCell ch5=new PdfPCell (new Paragraph("Action",hfont));
		PdfPCell ch6=new PdfPCell (new Paragraph("Quantity",hfont));
		PdfPCell ch7=new PdfPCell (new Paragraph("From",hfont));
		PdfPCell ch8=new PdfPCell (new Paragraph("To",hfont));
		PdfPCell ch9=new PdfPCell (new Paragraph("Date And Time",hfont));
		
		
		ch1.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch2.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch3.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch4.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch5.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch6.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch7.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch8.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch9.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		ch1.setPadding(5f);
		ch2.setPadding(5f);
		ch3.setPadding(5f);
		ch4.setPadding(5f);
		ch5.setPadding(5f);
		ch6.setPadding(5f);
		ch7.setPadding(5f);
		ch8.setPadding(5f);
		ch9.setPadding(5f);
		
		
		
		table.addCell(ch1);
		table.addCell(ch2);
		table.addCell(ch3);
		table.addCell(ch4);
		table.addCell(ch5);
		table.addCell(ch6);
		table.addCell(ch7);
		table.addCell(ch8);
		table.addCell(ch9);
		
		
		ArrayList<HistoryItem> historyList = RetreiveDAO.retreiveHistoryRecords();
		int x=0;
		while(x<historyList.size()) {
			HistoryItem h1 = historyList.get(x);
			PdfPCell ch10=new PdfPCell (new Paragraph(h1.getHistId(),dfont));
			PdfPCell ch11=new PdfPCell (new Paragraph(h1.getUsername(),dfont));
			PdfPCell ch12=new PdfPCell (new Paragraph(h1.getItemId(),dfont));
			PdfPCell ch13=new PdfPCell (new Paragraph(h1.getItemName(),dfont));
			PdfPCell ch14=new PdfPCell (new Paragraph(h1.getAction(),dfont));
			PdfPCell ch15=new PdfPCell (new Paragraph(String.valueOf(h1.getQty()),dfont));
			PdfPCell ch16=new PdfPCell (new Paragraph(String.valueOf(h1.getFrom()),dfont));
			PdfPCell ch17=new PdfPCell (new Paragraph(String.valueOf(h1.getTo()),dfont));
			PdfPCell ch18=new PdfPCell (new Paragraph(h1.getDateAndTime(),dfont));
			
			ch10.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch11.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch12.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch13.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch14.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch15.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch16.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch17.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch18.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			ch10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch13.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch14.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch15.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch16.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch17.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch18.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			ch10.setPadding(5f);
			ch11.setPadding(5f);
			ch12.setPadding(5f);
			ch13.setPadding(5f);
			ch14.setPadding(5f);
			ch15.setPadding(5f);
			ch16.setPadding(5f);
			ch17.setPadding(5f);
			ch18.setPadding(5f);
			
			table.addCell(ch10);
			table.addCell(ch11);
			table.addCell(ch12);
			table.addCell(ch13);
			table.addCell(ch14);
			table.addCell(ch15);
			table.addCell(ch16);
			table.addCell(ch17);
			table.addCell(ch18);
			
			x++;
		}
				
		
		
		document.add(table);
		document.close();
		writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
		
	}
	
	public static boolean FullItemList(String path) throws FileNotFoundException, DocumentException {
		
Document document = new Document();
		
		PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
		document.open();
		
		try {
			BaseFont base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
		
		
		Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
		Font hfont = new Font(base, 10, Font.BOLD);
		Font dfont = new Font(base, 10, Font.NORMAL);
		Image img  = Image.getInstance("C:\\Users\\isuru\\git\\ITP-2018-MLB-G3-10\\SampathBankWebPortal\\src\\main\\webapp\\resources\\images\\sampathbanklogo\\SampathBankLogo01.png"); 
		img.scaleToFit(110,110);
		img.setAlignment(Element.ALIGN_RIGHT);
//         img.setAbsolutePosition(390, 720);
         
         Paragraph p2 = new Paragraph();
         p2.add(img);
     
         document.add(p2);
//		Paragraph p1 = new Paragraph("Full History in Inventory Management System");
//		
//		p1.setFont(pfont);
//		p1.setAlignment(Element.ALIGN_CENTER);

		document.add(new Paragraph("Full Item List  in Inventory Management System",pfont));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(110);
		
		
		table.setSpacingAfter(11f);
		table.setSpacingBefore(11f);
		
		
		float [] colWidth = {3f,3f,3f,3f,3f,5f};
		table.setWidths(colWidth);
		PdfPCell ch1=new PdfPCell (new Paragraph("ItemID",hfont));
		PdfPCell ch2=new PdfPCell (new Paragraph("Item Name",hfont));
		PdfPCell ch3=new PdfPCell (new Paragraph("Quantity",hfont));
		PdfPCell ch4=new PdfPCell (new Paragraph("Measurement",hfont));
		PdfPCell ch5=new PdfPCell (new Paragraph("Low Stock Level",hfont));
		PdfPCell ch6=new PdfPCell (new Paragraph("Description",hfont));
		
		
		
		ch1.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch2.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch3.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch4.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch5.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		ch1.setPadding(5f);
		ch2.setPadding(5f);
		ch3.setPadding(5f);
		ch4.setPadding(5f);
		ch5.setPadding(5f);
		ch6.setPadding(5f);
		
		
		
		
		table.addCell(ch1);
		table.addCell(ch2);
		table.addCell(ch3);
		table.addCell(ch4);
		table.addCell(ch5);
		table.addCell(ch6);
	
		
		
		ArrayList<item> itemList = RetreiveDAO.getItems();
		int x=0;
		while(x<itemList.size()) {
			item i1 = itemList.get(x);
			PdfPCell ch10=new PdfPCell (new Paragraph(i1.getItemId(),dfont));
			PdfPCell ch11=new PdfPCell (new Paragraph(i1.getItemName(),dfont));
			PdfPCell ch12=new PdfPCell (new Paragraph(String.valueOf(i1.getItemQty()),dfont));
			PdfPCell ch13=new PdfPCell (new Paragraph(i1.getUnit(),dfont));
			PdfPCell ch14=new PdfPCell (new Paragraph(String.valueOf(i1.getItem_min()),dfont));
			PdfPCell ch15=new PdfPCell (new Paragraph(i1.getDescription(),dfont));
			
			
			ch10.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch11.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch12.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch13.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch14.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch15.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			ch10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch13.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch14.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch15.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			
			ch10.setPadding(5f);
			ch11.setPadding(5f);
			ch12.setPadding(5f);
			ch13.setPadding(5f);
			ch14.setPadding(5f);
			ch15.setPadding(5f);
			
			
			table.addCell(ch10);
			table.addCell(ch11);
			table.addCell(ch12);
			table.addCell(ch13);
			table.addCell(ch14);
			table.addCell(ch15);
			
			
			x++;
		}
				
		
		
		document.add(table);
		document.close();
		writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return true;
		
	}
	public static boolean SpecificItemHistory(String path,HistoryItem h2) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		
		PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
		document.open();
		
		try {
			BaseFont base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
		
		
		Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
		Font hfont = new Font(base, 10, Font.BOLD);
		Font dfont = new Font(base, 10, Font.NORMAL);
		Image img  = Image.getInstance("C:\\Users\\isuru\\git\\ITP-2018-MLB-G3-10\\SampathBankWebPortal\\src\\main\\webapp\\resources\\images\\sampathbanklogo\\SampathBankLogo01.png"); 
		img.scaleToFit(110,110);
		img.setAlignment(Element.ALIGN_RIGHT);
//         img.setAbsolutePosition(390, 720);
         
         Paragraph p2 = new Paragraph();
         p2.add(img);
     
         document.add(p2);
//		Paragraph p1 = new Paragraph("Full History in Inventory Management System");
//		
//		p1.setFont(pfont);
//		p1.setAlignment(Element.ALIGN_CENTER);

		document.add(new Paragraph("Full History in Inventory Management System",pfont));
		
		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(110);
		
		
		table.setSpacingAfter(11f);
		table.setSpacingBefore(11f);
		
		
		float [] colWidth = {1.5f,1.8f,1.3f,2f,3.5f,1.5f,1.25f,1.25f,2.5f};
		table.setWidths(colWidth);
		PdfPCell ch1=new PdfPCell (new Paragraph("HistoryID",hfont));
		PdfPCell ch2=new PdfPCell (new Paragraph("Username",hfont));
		PdfPCell ch3=new PdfPCell (new Paragraph("ItemID",hfont));
		PdfPCell ch4=new PdfPCell (new Paragraph("Item Name",hfont));
		PdfPCell ch5=new PdfPCell (new Paragraph("Action",hfont));
		PdfPCell ch6=new PdfPCell (new Paragraph("Quantity",hfont));
		PdfPCell ch7=new PdfPCell (new Paragraph("From",hfont));
		PdfPCell ch8=new PdfPCell (new Paragraph("To",hfont));
		PdfPCell ch9=new PdfPCell (new Paragraph("Date And Time",hfont));
		
		
		ch1.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch2.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch3.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch4.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch5.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch6.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch7.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch8.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch9.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		ch1.setPadding(5f);
		ch2.setPadding(5f);
		ch3.setPadding(5f);
		ch4.setPadding(5f);
		ch5.setPadding(5f);
		ch6.setPadding(5f);
		ch7.setPadding(5f);
		ch8.setPadding(5f);
		ch9.setPadding(5f);
		
		
		
		table.addCell(ch1);
		table.addCell(ch2);
		table.addCell(ch3);
		table.addCell(ch4);
		table.addCell(ch5);
		table.addCell(ch6);
		table.addCell(ch7);
		table.addCell(ch8);
		table.addCell(ch9);
		
		
		ArrayList<HistoryItem> historyList = RetreiveDAO.retreiveGenerateReportSpecificHistory(h2);
		int x=0;
		while(x<historyList.size()) {
			HistoryItem h1 = historyList.get(x);
			PdfPCell ch10=new PdfPCell (new Paragraph(h1.getHistId(),dfont));
			PdfPCell ch11=new PdfPCell (new Paragraph(h1.getUsername(),dfont));
			PdfPCell ch12=new PdfPCell (new Paragraph(h1.getItemId(),dfont));
			PdfPCell ch13=new PdfPCell (new Paragraph(h1.getItemName(),dfont));
			PdfPCell ch14=new PdfPCell (new Paragraph(h1.getAction(),dfont));
			PdfPCell ch15=new PdfPCell (new Paragraph(String.valueOf(h1.getQty()),dfont));
			PdfPCell ch16=new PdfPCell (new Paragraph(String.valueOf(h1.getFrom()),dfont));
			PdfPCell ch17=new PdfPCell (new Paragraph(String.valueOf(h1.getTo()),dfont));
			PdfPCell ch18=new PdfPCell (new Paragraph(h1.getDateAndTime(),dfont));
			
			ch10.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch11.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch12.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch13.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch14.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch15.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch16.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch17.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch18.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			ch10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch13.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch14.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch15.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch16.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch17.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch18.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			ch10.setPadding(5f);
			ch11.setPadding(5f);
			ch12.setPadding(5f);
			ch13.setPadding(5f);
			ch14.setPadding(5f);
			ch15.setPadding(5f);
			ch16.setPadding(5f);
			ch17.setPadding(5f);
			ch18.setPadding(5f);
			
			table.addCell(ch10);
			table.addCell(ch11);
			table.addCell(ch12);
			table.addCell(ch13);
			table.addCell(ch14);
			table.addCell(ch15);
			table.addCell(ch16);
			table.addCell(ch17);
			table.addCell(ch18);
			
			x++;
		}
				
		
		
		document.add(table);
		document.close();
		writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
		
	}

	public static boolean FullRquest(String path) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		
		PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
		document.open();
		
		try {
			BaseFont base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
		
		
		Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
		Font hfont = new Font(base, 10, Font.BOLD);
		Font dfont = new Font(base, 10, Font.NORMAL);
		Image img  = Image.getInstance("C:\\Users\\isuru\\git\\ITP-2018-MLB-G3-10\\SampathBankWebPortal\\src\\main\\webapp\\resources\\images\\sampathbanklogo\\SampathBankLogo01.png"); 
		img.scaleToFit(110,110);
		img.setAlignment(Element.ALIGN_RIGHT);
//         img.setAbsolutePosition(390, 720);
         
         Paragraph p2 = new Paragraph();
         p2.add(img);
     
         document.add(p2);
//		Paragraph p1 = new Paragraph("Full History in Inventory Management System");
//		
//		p1.setFont(pfont);
//		p1.setAlignment(Element.ALIGN_CENTER);

		document.add(new Paragraph("Full History in Inventory Management System",pfont));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(110);
		
		
		table.setSpacingAfter(11f);
		table.setSpacingBefore(11f);
		
		
		float [] colWidth = {3f,3f,3f,3f,3f,5f};
		table.setWidths(colWidth);
		PdfPCell ch1=new PdfPCell (new Paragraph("Reference ID",hfont));
		PdfPCell ch2=new PdfPCell (new Paragraph("Username",hfont));
		PdfPCell ch3=new PdfPCell (new Paragraph("branch",hfont));
		PdfPCell ch4=new PdfPCell (new Paragraph("Item ID",hfont));
		PdfPCell ch5=new PdfPCell (new Paragraph("Item Name",hfont));
		PdfPCell ch6=new PdfPCell (new Paragraph("Requested Amount",hfont));
	
		
		
		ch1.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch2.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch3.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch4.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch5.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		ch1.setPadding(5f);
		ch2.setPadding(5f);
		ch3.setPadding(5f);
		ch4.setPadding(5f);
		ch5.setPadding(5f);
		ch6.setPadding(5f);
		
		
		
		
		table.addCell(ch1);
		table.addCell(ch2);
		table.addCell(ch3);
		table.addCell(ch4);
		table.addCell(ch5);
		table.addCell(ch6);
		
		
		
		ArrayList<headRequestItem> requestList = RetreiveDAO.getRequestDetails();
		int x=0;
		while(x<requestList.size()) {
			headRequestItem r1 = requestList.get(x);
			PdfPCell ch10=new PdfPCell (new Paragraph(r1.getRefId(),dfont));
			PdfPCell ch11=new PdfPCell (new Paragraph(r1.getHeadUsername(),dfont));
			PdfPCell ch12=new PdfPCell (new Paragraph(r1.getBranch(),dfont));
			PdfPCell ch13=new PdfPCell (new Paragraph(r1.getItemId(),dfont));
			PdfPCell ch14=new PdfPCell (new Paragraph(r1.getItemName(),dfont));
			PdfPCell ch15=new PdfPCell (new Paragraph(String.valueOf(r1.getReqAmount()),dfont));
			
			
			ch10.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch11.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch12.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch13.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch14.setHorizontalAlignment(Element.ALIGN_CENTER);
			ch15.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			ch10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch13.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch14.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch15.setVerticalAlignment(Element.ALIGN_MIDDLE);
			
			
			ch10.setPadding(5f);
			ch11.setPadding(5f);
			ch12.setPadding(5f);
			ch13.setPadding(5f);
			ch14.setPadding(5f);
			ch15.setPadding(5f);
			
			
			table.addCell(ch10);
			table.addCell(ch11);
			table.addCell(ch12);
			table.addCell(ch13);
			table.addCell(ch14);
			table.addCell(ch15);
			
			
			x++;
		}
				
		
		
		document.add(table);
		document.close();
		writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
		
	}
}
