package in.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;
import in.nit.util.CommonUtil;
import in.nit.util.UomTypeUtil;
import in.nit.validator.UomValidator;
import in.nit.view.UomTypeExcelView;
import in.nit.view.UomTypePdfView;

@Controller
@RequestMapping("/uom")
public class UomTypeController {


	@Autowired
	private IUomTypeService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private UomTypeUtil util;
	@Autowired
	private UomValidator validator;

	@RequestMapping("/register")
	public String showUserPage(Model model) {
		//form backing Objects
		model.addAttribute("uomType", new UomType());
		return "UomPage";
	}
	@SuppressWarnings("unused")
	private void commonUi(Model model) {
		List<Object[]> uomList=service.getUomIdAndUomModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		model.addAttribute("uomMap", uomMap);
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveUom(@ModelAttribute UomType uomType,Errors errors,ModelMap map) {
		//must be called before save
		validator.validate(uomType, errors);
		/*
		 * Integer id=service.saveUomType(uomType); String
		 * message="UomType '"+id+"' saved"; map.addAttribute("message", message);
		 * return "UomPage";
		 */
		if(!errors.hasErrors()) { //If no errors are exist
			Integer  id=service.saveUomType(uomType);
			map.addAttribute("message","Uom created with Id:"+id);
			map.addAttribute("uom",new UomType()) ;
		}
		else { //If errors exist
			map.addAttribute("message","Please Check all Errors!");
		}
		return "UomPage";
	}



	@RequestMapping("/all")
	public String diplayAll(Model model) {
		List<UomType> list=service.displayAllUomTypes();
		model.addAttribute("list",list);
		return "UomTypeData";
	}

	@RequestMapping("/delete")
	public String deleteUomType(@RequestParam("uid") Integer id,Model model) {
		service.deleteUomById(id);
		String message = "UomType '"+id+"' deleted";
		model.addAttribute("message",message);
		List<UomType> list=service.displayAllUomTypes();
		model.addAttribute("list",list);
		return "UomTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("uid") Integer id,Model model) {
		UomType ut = service.getOneUomType(id);
		model.addAttribute("uomType", ut);
		return "UomTypeEdit";
	}

	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateUomType(
			@ModelAttribute UomType uomType,Model model
			) {
		service.updateUomType(uomType);
		String message="uomType '"+uomType.getUomId()+"' Updated";
		model.addAttribute(message, message);
		List<UomType> list=service.displayAllUomTypes();
		model.addAttribute("list", list);
		return "UomTypeData";
	}

	@RequestMapping(value="/view")
	public String getOneUomType(@RequestParam("uid")Integer id,Model model) {
		UomType st=service.getOneUomType(id);
		model.addAttribute("view", st);
		return "UomTypeView";

	}


	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id",required = false) Integer id ){
		ModelAndView m = new ModelAndView();
		m.setView(new UomTypeExcelView());
		if(id==null) {
			//export all rows
			List<UomType> list=service.displayAllUomTypes();
			m.addObject("list",list);
		}
		else{
			//export one row by id
			UomType st = service.getOneUomType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}



	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id",required = false) Integer id
			) {
		ModelAndView m = new ModelAndView();
		m.setView(new UomTypePdfView());
		if(id==null){//show all
			List<UomType> list=service.displayAllUomTypes();
			m.addObject("list",list);
		}
		else {//show one
			UomType st = service.getOneUomType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getUomModelCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UomTypeCharts";
	}

	@RequestMapping("/modelExist")
	public @ResponseBody String isModelExist(
			@RequestParam("model")String model
			)
	{
		String message="";
		boolean exist=service.isUomModelExist(model);
		if(exist) {
			message=model+" already exist";
		}
		return message;
	}
}