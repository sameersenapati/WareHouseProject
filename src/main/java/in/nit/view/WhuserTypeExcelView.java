package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.WhuserType;

public class WhuserTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//filename
		response.addHeader("Content-Disposition", "attachment;fileName=Whusers.xlsx");
		Sheet s=workbook.createSheet("WHUSER TYPES");
		//Construct-row-0
		setHeader(s);
		//read Model Data
		@SuppressWarnings("unchecked")
		List<WhuserType> list=(List<WhuserType>) model.get("list");
		setBody(s,list);
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("USER TYPE");
		r.createCell(2).setCellValue("USER CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("USER MAIL");
		r.createCell(5).setCellValue("USER CONTACT");
		r.createCell(6).setCellValue("USER ID TYPE");
		r.createCell(7).setCellValue("IF OTHER");
		r.createCell(8).setCellValue("ID NUMBER");
	}

	private void setBody(Sheet s,List<WhuserType> list) {
		int count=1;
		for(WhuserType st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getUserId());
			r.createCell(1).setCellValue(st.getUserType());
			r.createCell(2).setCellValue(st.getUserCode());
			r.createCell(3).setCellValue(st.getUserFor());
			r.createCell(4).setCellValue(st.getUserMail());
			r.createCell(5).setCellValue(st.getUserContact());
			r.createCell(6).setCellValue(st.getUserIdtype());
			r.createCell(7).setCellValue(st.getIfOther());
			r.createCell(8).setCellValue(st.getIdNumber());
		}
	}
}
