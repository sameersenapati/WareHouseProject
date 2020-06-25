package in.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.PartType;
import in.nit.model.UomType;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartTypeService;
import in.nit.service.IUomTypeService;
import in.nit.util.CommonUtil;
import in.nit.util.PartTypeUtil;
import in.nit.view.PartTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/part")
public class PartTypeController {
	@Autowired
	private IPartTypeService service;
	@Autowired
	private IOrderMethodService omService;
	@Autowired
	private ServletContext context;
	@Autowired
	private PartTypeUtil util;
	@Autowired
	private IUomTypeService uomService;



	@SuppressWarnings("unused")
	private void commonUi(Model map){
		List<UomType> uomList = (List<UomType>)uomService.displayAllUomTypes();
		map.addAttribute("uomList",uomList);
		List<Object[]> list = omService.getOrderIdAndCode("sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(list);
		map.addAttribute("omSaleMap", omSaleMap);
		List<Object[]> omPurchaseList = omService.getOrderIdAndCode("purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);
		map.addAttribute("omPurchaseMap", omPurchaseMap);
	}

	@RequestMapping("/register")
	public String showUserPage(@ModelAttribute PartType partType,Model model) {
		//form backing Objects
		model.addAttribute("partType", new PartType());
		return "PartTypeRegister";
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String savePart(@ModelAttribute PartType partType,Model model) {
		Integer id=service.savePartType(partType);
		String message="PartType '"+id+"' saved";
		model.addAttribute("message", message);
		return "PartTypeRegister";
	}

	@RequestMapping("/all")
	public String diplayAll(Model model) {
		List<PartType> list=service.displayAllPartTypes();
		model.addAttribute("list",list);
		return "PartTypeData";
	}

	@RequestMapping("/delete")
	public String deletePartType(@RequestParam("pid") Integer id,Model model) {
		service.deletePartTypeId(id);
		String message = "PartType '"+id+"' deleted";
		model.addAttribute("message",message);
		List<PartType> list=service.displayAllPartTypes();
		model.addAttribute("list",list);
		return "PartTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("pid") Integer id,Model model) {
		PartType ut = service.getOnePartType(id);
		model.addAttribute("partType", ut);
		return "PartTypeEdit";
	}

	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updatePartType(
			@ModelAttribute PartType partType,Model model
			) {
		service.updatePartType(partType);
		String message="partType '"+partType.getPartId()+"' Updated";
		model.addAttribute(message, message);
		List<PartType> list=service.displayAllPartTypes();
		model.addAttribute("list", list);
		return "PartTypeData";
	}

	@RequestMapping({ "/view" })
	public String getOnePartType(@RequestParam("pid") final Integer id, final Model model) {
		final PartType st = this.service.getOnePartType(id);
		model.addAttribute("view", (Object)st);
		return "PartTypeView";
	}

	@RequestMapping({ "/excel" })
	public ModelAndView showExcel(@RequestParam(value = "id", required = false)  Integer id) {
		final ModelAndView m = new ModelAndView();
		m.setView(new PartTypeExcelView());
		if (id == null) {
			List<PartType> list = (List<PartType>)service.displayAllPartTypes();
			m.addObject("list", list);
		}
		else {
			PartType st = service.getOnePartType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping({ "/pdf" })
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if (id == null) {
			List<PartType> list = (List<PartType>)service.displayAllPartTypes();
			m.addObject("list", list);
		}
		else {
			PartType st = service.getOnePartType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping({ "/charts" })
	public String showCharts() {
		List<Object[]> list = (List<Object[]>)service.getPartCodeCount();
		String path = this.context.getRealPath("/");
		util.generatePie(path,list);
		util.generateBar(path,list);
		return "PartTypeCharts";
	}
}
