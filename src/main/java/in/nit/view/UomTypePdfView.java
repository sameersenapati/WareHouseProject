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

import in.nit.model.UomType;

public class UomTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download file
		response.addHeader("Content-Disposition", "attachment;filename=UomTypes.pdf");
		//create Element
		Paragraph p = new Paragraph("WELCOME TO UOM TYPE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<UomType> list=(List<UomType>) model.get("list");
		//creating table with no.of columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");
		//adding data to table
		for(UomType ut:list) {
			t.addCell(ut.getUomId().toString());
			t.addCell(ut.getUomType());
			t.addCell(ut.getUomModel());
			t.addCell(ut.getUdesc());
		}
		//add table to document
		document.add(t);
		//print Date and Time
		document.add(new Paragraph(new Date().toString()));
	}
}
