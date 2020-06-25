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

import in.nit.model.OrderMethod;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download file
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethods.pdf");
		//create Element
		Paragraph p = new Paragraph("WELCOME TO ORDERMETHOD TYPE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//creating table with no.of columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACPT");
		t.addCell("NOTE");
		//adding data to table
		for(OrderMethod st:list) {
			t.addCell(st.getOrderId().toString());
			t.addCell(st.getOrderMode());
			t.addCell(st.getOrderCode());
			t.addCell(st.getOrderType());
			t.addCell(st.getOrderAcpt().toString());
			t.addCell(st.getDescription());
		}
		//add table to document
		document.add(t);
		//print Date and Time
		document.add(new Paragraph(new Date().toString()));
	}
}
