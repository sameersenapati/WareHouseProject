package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.PartType;


public class PartTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition", "attachment;fileName=PartType.xlsx");
		Sheet s=workbook.createSheet("PART TYPES");
		//Construct-row-0
		setHeader(s);
		//read Model Data
		@SuppressWarnings("unchecked")
		List<PartType> list=(List<PartType>) model.get("list");
		setBody(s,list);
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("WIDTH");
		r.createCell(3).setCellValue("LENGTH");
		r.createCell(4).setCellValue("HEIGHT");
		r.createCell(5).setCellValue("COST");
		r.createCell(6).setCellValue("CURRENCY");
		r.createCell(7).setCellValue("DESCRIPTION");
      
	}

	private void setBody(Sheet s,List<PartType> list) {
		int count=1;
		for(PartType st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getPartId());
			r.createCell(1).setCellValue(st.getPartCode());
			r.createCell(2).setCellValue(st.getPartWidth());
			r.createCell(3).setCellValue(st.getPartLength());
			r.createCell(4).setCellValue(st.getPartHeight());
			r.createCell(5).setCellValue(st.getPartBaseCost());
			r.createCell(6).setCellValue(st.getPartBaseCurrency());
			r.createCell(7).setCellValue(st.getDescription());
          
		}
	}

}


