package POJO_MODEL.inventory_management;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Document document = new Document();
		
		try {
			PdfWriter  writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\SamplePDF\\sample.pdf"));
			document.open();
			document.add(new Paragraph("Helloo PPL"));
			
			Paragraph p2 = new Paragraph("sample");
			
			PdfPTable table = new PdfPTable(3);
			
			
			
			table.setWidthPercentage(100);
			table.setSpacingAfter(11f);
			table.setSpacingBefore(11f);
			
			float [] colWidth = {2f,2f,2f};
			table.setWidths(colWidth);
			
			 Font font = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
			
			 PdfPCell c1=new PdfPCell (new Paragraph("Col1",font));
			
			
			PdfPCell c2=new PdfPCell (new Paragraph("Col2",font));
			PdfPCell c3=new PdfPCell (new Paragraph("Col3"));
//			PdfPCell c4=new PdfPCell (new Paragraph("Col4"));
			
//			c4.setHorizontalAlignment(Element.ALIGN_CENTER);
//			c4.setPadding(20);
			
			table.addCell(c1);
			table.addCell(c2);
			table.addCell(c3);
			table.addCell(c3);
			table.addCell(c3);
			table.addCell(c3);
//			table.addCell(c4);
//			table.addCell(c4);
//			table.addCell(c4);
			
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			document.add(table);
			document.add(p2);
			document.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
