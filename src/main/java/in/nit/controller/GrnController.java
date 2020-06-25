package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Grn;
import in.nit.service.IGrnService;
import in.nit.service.IPurchaseOrderTypeService;
import in.nit.util.CommonUtil;

@Controller
@RequestMapping("/grn")
public class GrnController {
	@Autowired
	private IGrnService service;
	@Autowired
	private IPurchaseOrderTypeService poService;

	public void addCommonUi(Model model) {
		List<Object[]> poList= poService.getPurchaseOrderIdAndCode();
		Map<Integer,String> poMap=CommonUtil.convert(poList);
		model.addAttribute("poMap", poMap);
	}
	
	@RequestMapping("/register")
	public String showUserPage(Model model) {
		//form backing objects
		model.addAttribute("grn", new Grn());
		addCommonUi(model);
		return "GrnRegister";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveGrn(@ModelAttribute Grn grn,Model model ) {
		model.addAttribute("grn", new Grn());
		Integer id=service.saveGrnOrder(grn);
		String message="Grn'"+id+"'Saved";
		poService.updatePoStatus(grn.getPo().getId(), "RECEIVED");
		model.addAttribute("message", message);
		addCommonUi(model);
		return "GrnRegister";
	}
	
	@RequestMapping("/all")
	public String displayAll(Model model) {
		List<Grn> list =service.displayAllGrns();
		model.addAttribute("list",list );
		return "GrnData";
	}
	@RequestMapping("/delete")
	public String deleteGrn(@RequestParam("gid") Integer id,Model model) {
		service.deleteGrnById(id);
		String message = "Grn '"+id+"' deleted";
		model.addAttribute("message",message);
		List<Grn> list=service.displayAllGrns();
		model.addAttribute("list",list);
		return "GrnData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("gid") Integer id,Model model){
		Grn gt=service.getOneGrnType(id);
		model.addAttribute("grn", gt);
		addCommonUi(model);
		return "GrnEdit";
	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateGrn(@ModelAttribute Grn grn,Model model) {
		service.updateGrn(grn);
		String message="Grn'"+grn.getGrnId()+"'Updated";
		model.addAttribute("message", message);
		List<Grn> list=service.displayAllGrns();
		model.addAttribute("list", list);
		return "GrnData";
	}
	@RequestMapping(value = "/view")
	public String getOneGrn(@RequestParam("gid") Integer id,Model model ) {
		Grn gt=service.getOneGrnType(id);
		model.addAttribute("gt", gt);
		return "GrnView";
	}
}
