package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.WhuserType;


public class WhuserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Whusers.pdf");
		//create Element
		Paragraph p = new Paragraph("WELCOME TO SHIPMENT TYPE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<WhuserType> list=(List<WhuserType>) model.get("list");
		//creating table with no.of columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FOR");
		t.addCell("MAIL");
		t.addCell("CONTACT");
		t.addCell("ID TYPE");
		t.addCell("IF OTHER");
		t.addCell("ID NUMBER");

		//adding data to table
		for(WhuserType wt:list) {
			t.addCell(wt.getUserId().toString());
			t.addCell(wt.getUserType());
			t.addCell(wt.getUserCode());
			t.addCell(wt.getUserFor());
			t.addCell(wt.getUserMail());
			t.addCell(wt.getUserContact().toString());
			t.addCell(wt.getUserIdtype());
			t.addCell(wt.getIfOther());
			t.addCell(wt.getIdNumber().toString());
		}
		//add table to document
		document.add(t);
		//print Date and Time
		document.add(new Paragraph(new Date().toString()));
	}
}
