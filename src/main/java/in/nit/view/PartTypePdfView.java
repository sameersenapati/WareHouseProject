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

import in.nit.model.PartType;

public class PartTypePdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download file
		response.addHeader("Content-Disposition", "attachment;filename=PartTypes.pdf");
		//create Element
		Paragraph p = new Paragraph("WELCOME TO PART TYPE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<PartType> list=(List<PartType>) model.get("list");
		//creating table with no.of columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("WIDTH");
		t.addCell("LENGTH");
		t.addCell("HEIGHT");
		t.addCell("COST");
		t.addCell("CURRENCY");
		t.addCell("NOTE");
		//adding data to table
		for(PartType ut:list) {
			t.addCell(ut.getPartId().toString());
			t.addCell(ut.getPartCode());
			t.addCell(ut.getPartWidth().toString());
			t.addCell(ut.getPartLength().toString());
			t.addCell(ut.getPartHeight().toString());
			t.addCell(ut.getPartBaseCost().toString());
			t.addCell(ut.getPartBaseCurrency().toString());
			t.addCell(ut.getDescription());
		}
		//add table to document
		document.add(t);
		//print Date and Time
		document.add(new Paragraph(new Date().toString()));
	}
}
