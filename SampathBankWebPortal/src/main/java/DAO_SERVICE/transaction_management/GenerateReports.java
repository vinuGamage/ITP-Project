package DAO_SERVICE.transaction_management;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import POJO_MODEL.transaction_management.Transaction;

public class GenerateReports {

	public static boolean fullTransactionHistory(String path) throws FileNotFoundException, DocumentException {
		
	Document document = new Document();
		
		PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
		document.open();
	
BaseFont base;
try {
	base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
	Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
	Font hfont = new Font(base, 10, Font.BOLD);
	Font dfont = new Font(base, 10, Font.NORMAL);
	
	
	document.add(new Paragraph("Full History In Transaction.",pfont));
	
	document.add(new Paragraph("Sampath Transactions.",pfont));
	
	PdfPTable table = new PdfPTable(6);
	table.setWidthPercentage(100);
	
	
	table.setSpacingAfter(11f);
	table.setSpacingBefore(11f);
	table.setHorizontalAlignment(Element.ALIGN_RIGHT);
	
	float [] colWidth = {2.5f,2.5f,3f,2f,3.5f,3f};
	table.setWidths(colWidth);
	PdfPCell ch1=new PdfPCell (new Paragraph("TransactID",hfont));
	PdfPCell ch2=new PdfPCell (new Paragraph("DebitAccount",hfont));
	PdfPCell ch3=new PdfPCell (new Paragraph("CreditAccount",hfont));
	PdfPCell ch4=new PdfPCell (new Paragraph("Date",hfont));
	PdfPCell ch5=new PdfPCell (new Paragraph("Amount",hfont));
	PdfPCell ch6=new PdfPCell (new Paragraph("Status",hfont));
	
	
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

	ArrayList<Transaction> historyList = retreiveDAO.getAllTransacts();
	int x=0;
	while(x<historyList.size()) {
		Transaction h1 = historyList.get(x);
		
		PdfPCell ch10=new PdfPCell (new Paragraph(String.valueOf(h1.getTid()),dfont));
		PdfPCell ch11=new PdfPCell (new Paragraph(String.valueOf(h1.getAccountNo()),dfont));
		PdfPCell ch12=new PdfPCell (new Paragraph(String.valueOf(h1.getTaccountNo()),dfont));
		PdfPCell ch13=new PdfPCell (new Paragraph(String.valueOf(h1.getDate()),dfont));
		PdfPCell ch14=new PdfPCell (new Paragraph(String.valueOf(h1.getAmount()),dfont));
		PdfPCell ch15=new PdfPCell (new Paragraph(String.valueOf(h1.getStatus()),dfont));
		
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
	

	
	PdfPTable table1 = new PdfPTable(6);
	table1.setWidthPercentage(100);
	
	
	table1.setSpacingAfter(21f);
	table1.setSpacingBefore(21f);
	table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
	
	float [] colWidth1 = {2.5f,2.5f,3f,2f,3.5f,3f};
	table.setWidths(colWidth1);
	PdfPCell ch16=new PdfPCell (new Paragraph("TransactID",hfont));
	PdfPCell ch17=new PdfPCell (new Paragraph("DebitAccount",hfont));
	PdfPCell ch18=new PdfPCell (new Paragraph("CreditAccount",hfont));
	PdfPCell ch19=new PdfPCell (new Paragraph("Date",hfont));
	PdfPCell ch20=new PdfPCell (new Paragraph("Amount",hfont));
	PdfPCell ch21=new PdfPCell (new Paragraph("Status",hfont));
	
	
	ch16.setHorizontalAlignment(Element.ALIGN_CENTER);
	ch17.setHorizontalAlignment(Element.ALIGN_CENTER);
	ch18.setHorizontalAlignment(Element.ALIGN_CENTER);
	ch19.setHorizontalAlignment(Element.ALIGN_CENTER);
	ch20.setHorizontalAlignment(Element.ALIGN_CENTER);
	ch21.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	ch16.setPadding(5f);
	ch17.setPadding(5f);
	ch18.setPadding(5f);
	ch19.setPadding(5f);
	ch20.setPadding(5f);
	ch21.setPadding(5f);
	
	
	table1.addCell(ch16);
	table1.addCell(ch17);
	table1.addCell(ch18);
	table1.addCell(ch19);
	table1.addCell(ch20);
	table1.addCell(ch21);

	ArrayList<Transaction> historyList1 = retreiveDAO.getAllIntraTransacts();
	int y=0;
	while(y<historyList1.size()) {
		Transaction h2 = historyList1.get(y);
		
		PdfPCell ch22=new PdfPCell (new Paragraph(String.valueOf(h2.getTid()),dfont));
		PdfPCell ch23=new PdfPCell (new Paragraph(String.valueOf(h2.getAccountNo()),dfont));
		PdfPCell ch24=new PdfPCell (new Paragraph(String.valueOf(h2.getTaccountNo()),dfont));
		PdfPCell ch25=new PdfPCell (new Paragraph(String.valueOf(h2.getDate()),dfont));
		PdfPCell ch26=new PdfPCell (new Paragraph(String.valueOf(h2.getAmount()),dfont));
		PdfPCell ch27=new PdfPCell (new Paragraph(String.valueOf(h2.getStatus()),dfont));
		
		ch22.setVerticalAlignment(Element.ALIGN_MIDDLE);
		ch23.setVerticalAlignment(Element.ALIGN_MIDDLE);
		ch24.setVerticalAlignment(Element.ALIGN_MIDDLE);
		ch25.setVerticalAlignment(Element.ALIGN_MIDDLE);
		ch26.setVerticalAlignment(Element.ALIGN_MIDDLE);
		ch27.setVerticalAlignment(Element.ALIGN_MIDDLE);
	
		ch22.setPadding(5f);
		ch23.setPadding(5f);
		ch24.setPadding(5f);
		ch25.setPadding(5f);
		ch26.setPadding(5f);
		ch27.setPadding(5f);
		
		table1.addCell(ch22);
		table1.addCell(ch23);
		table1.addCell(ch24);
		table1.addCell(ch25);
		table1.addCell(ch26);
		table1.addCell(ch27);
		
		y++;
	}
	
	
	document.add(table);
	document.add(new Paragraph("Other Bank Transactions.",pfont));
	document.add(table1);
	document.close();
	writer.close();
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		
		
		
		
		return true;
	}
	
	
	
	
	public static boolean SpecificTransactionHistory(String path,Transaction t4) throws FileNotFoundException, DocumentException {
		
		Document document = new Document();
			
			PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\GeneratedReports\\"+path+".pdf"));
			document.open();
		
	BaseFont base;
	try {
		base = BaseFont.createFont("C:\\Windows\\Fonts\\GOTHIC.TTF",BaseFont.WINANSI,BaseFont.EMBEDDED);
		Font pfont = new Font(base, 12, Font.BOLD ,BaseColor.DARK_GRAY);
		Font hfont = new Font(base, 10, Font.BOLD);
		Font dfont = new Font(base, 10, Font.NORMAL);
		
		
		document.add(new Paragraph("Full History In Transaction.",pfont));
		
		document.add(new Paragraph("Sampath Transactions.",pfont));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100);
		
		
		table.setSpacingAfter(11f);
		table.setSpacingBefore(11f);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		
		float [] colWidth = {2.5f,2.5f,3f,2f,3.5f,3f};
		table.setWidths(colWidth);
		PdfPCell ch1=new PdfPCell (new Paragraph("TransactID",hfont));
		PdfPCell ch2=new PdfPCell (new Paragraph("DebitAccount",hfont));
		PdfPCell ch3=new PdfPCell (new Paragraph("CreditAccount",hfont));
		PdfPCell ch4=new PdfPCell (new Paragraph("Date",hfont));
		PdfPCell ch5=new PdfPCell (new Paragraph("Amount",hfont));
		PdfPCell ch6=new PdfPCell (new Paragraph("Status",hfont));
		
		
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

		ArrayList<Transaction> historyList = retreiveDAO.GetSpecificTransaction(t4);
		int x=0;
		while(x<historyList.size()) {
			Transaction h1 = historyList.get(x);
			
			PdfPCell ch10=new PdfPCell (new Paragraph(String.valueOf(h1.getTid()),dfont));
			PdfPCell ch11=new PdfPCell (new Paragraph(String.valueOf(h1.getAccountNo()),dfont));
			PdfPCell ch12=new PdfPCell (new Paragraph(String.valueOf(h1.getTaccountNo()),dfont));
			PdfPCell ch13=new PdfPCell (new Paragraph(String.valueOf(h1.getDate()),dfont));
			PdfPCell ch14=new PdfPCell (new Paragraph(String.valueOf(h1.getAmount()),dfont));
			PdfPCell ch15=new PdfPCell (new Paragraph(String.valueOf(h1.getStatus()),dfont));
			
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
		

		
		PdfPTable table1 = new PdfPTable(6);
		table1.setWidthPercentage(100);
		
		
		table1.setSpacingAfter(21f);
		table1.setSpacingBefore(21f);
		table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		
		float [] colWidth1 = {2.5f,2.5f,3f,2f,3.5f,3f};
		table.setWidths(colWidth1);
		PdfPCell ch16=new PdfPCell (new Paragraph("TransactID",hfont));
		PdfPCell ch17=new PdfPCell (new Paragraph("DebitAccount",hfont));
		PdfPCell ch18=new PdfPCell (new Paragraph("CreditAccount",hfont));
		PdfPCell ch19=new PdfPCell (new Paragraph("Date",hfont));
		PdfPCell ch20=new PdfPCell (new Paragraph("Amount",hfont));
		PdfPCell ch21=new PdfPCell (new Paragraph("Status",hfont));
		
		
		ch16.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch17.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch18.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch19.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch20.setHorizontalAlignment(Element.ALIGN_CENTER);
		ch21.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		ch16.setPadding(5f);
		ch17.setPadding(5f);
		ch18.setPadding(5f);
		ch19.setPadding(5f);
		ch20.setPadding(5f);
		ch21.setPadding(5f);
		
		
		table1.addCell(ch16);
		table1.addCell(ch17);
		table1.addCell(ch18);
		table1.addCell(ch19);
		table1.addCell(ch20);
		table1.addCell(ch21);

		ArrayList<Transaction> historyList1 = retreiveDAO.GetSpecificIntraTransaction(t4);
		int y=0;
		while(y<historyList1.size()) {
			Transaction h2 = historyList1.get(y);
			
			PdfPCell ch22=new PdfPCell (new Paragraph(String.valueOf(h2.getTid()),dfont));
			PdfPCell ch23=new PdfPCell (new Paragraph(String.valueOf(h2.getAccountNo()),dfont));
			PdfPCell ch24=new PdfPCell (new Paragraph(String.valueOf(h2.getTaccountNo()),dfont));
			PdfPCell ch25=new PdfPCell (new Paragraph(String.valueOf(h2.getDate()),dfont));
			PdfPCell ch26=new PdfPCell (new Paragraph(String.valueOf(h2.getAmount()),dfont));
			PdfPCell ch27=new PdfPCell (new Paragraph(String.valueOf(h2.getStatus()),dfont));
			
			ch22.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch23.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch24.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch25.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch26.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ch27.setVerticalAlignment(Element.ALIGN_MIDDLE);
		
			ch22.setPadding(5f);
			ch23.setPadding(5f);
			ch24.setPadding(5f);
			ch25.setPadding(5f);
			ch26.setPadding(5f);
			ch27.setPadding(5f);
			
			table1.addCell(ch22);
			table1.addCell(ch23);
			table1.addCell(ch24);
			table1.addCell(ch25);
			table1.addCell(ch26);
			table1.addCell(ch27);
			
			y++;
		}
		
		
		document.add(table);
		document.add(new Paragraph("Other Bank Transactions.",pfont));
		document.add(table1);
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
