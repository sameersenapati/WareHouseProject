package in.nit.controller;

import java.util.Arrays;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.WhuserType;
import in.nit.service.IWhuserTypeService;
import in.nit.util.EmailUtil;
import in.nit.util.WhuserTypeUtil;
import in.nit.validator.WhuserTypeValidator;
import in.nit.view.WhuserTypeExcelView;
import in.nit.view.WhuserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WhuserTypeController {
	@Autowired
	private IWhuserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhuserTypeUtil util;
	@Autowired
	private WhuserTypeValidator validator;
	@Autowired
	private EmailUtil emailUtil;

	@RequestMapping("/register")
	public String showWhuser(Model model) {
		//Form Backing Objects
		model.addAttribute("whuserType", new WhuserType());
		return "WhuserTypeRegister";
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveWhuser(@ModelAttribute WhuserType whuserType,Errors errors,ModelMap map){
		//call validator
		validator.validate(whuserType, errors);

		if(!errors.hasErrors()) { //has no errors
			Integer id=service.saveWhuserType(whuserType);
			map.addAttribute("message","WhuserType created with Id:"+id);
			map.addAttribute("whuserType",new WhuserType()) ;
		}
		else {
			//errors are added by validator
			map.addAttribute("message","Please check All Errors");
		}
		Integer id=service.saveWhuserType(whuserType);
		String message="WhUserType created with Id:"+id;


		if(id!=null) { //send email
			String text="Welcome to WhUser ="+whuserType.getUserCode()
			+", type="+whuserType.getUserType()
			+", All the best!!";

			boolean sent=emailUtil.sendEmail(
					whuserType.getUserMail(), 
					"Welcome WhUser", 
					text);
			if(sent)
				message+=",Email also sent!";
			else
				message+=",Email Sending Fail!";
		}
		map.addAttribute("message",message);

		map.addAttribute("whuserType",new WhuserType()) ;



		/*
		 * map.addAttribute("whuserType", new WhuserType()); Integer id=
		 * service.saveWhuserType(whuserType); String
		 * message="WhuserType '"+id+"' saved"; map.addAttribute("message", message);
		 */
		return "WhuserTypeRegister";
	}

	@RequestMapping("/all")
	public String diplayAll(Model model) {
		List<WhuserType> list=service.displayAllWhuerTypes();
		model.addAttribute("list",list);
		return "WhuserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhuserType(@RequestParam("wid") Integer id,Model model) {
		service.deleteAllWhuserType(id);
		String message = "WhuserType '"+id+"' deleted";
		model.addAttribute("message",message);
		List<WhuserType> list=service.displayAllWhuerTypes();
		model.addAttribute("list",list);
		return "WhuserTypeData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("wid") Integer id,Model model) {
		WhuserType st = service.getOneWhuserType(id);
		model.addAttribute("whuserType", st);
		return "WhuserTypeEdit";
	}

	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateWhuserType(
			@ModelAttribute WhuserType whuserType,Model model
			) {
		service.updateWhuserType(whuserType);
		String message="WhuserType '"+whuserType.getUserId()+"' Updated";
		model.addAttribute("message", message);
		List<WhuserType> list=service.displayAllWhuerTypes();
		model.addAttribute("list", list);
		return "WhuserTypeData";
	}

	@RequestMapping(value="/view")
	public String getOneWhuserType(@RequestParam("wid")Integer id,Model model) {
		WhuserType st=service.getOneWhuserType(id);
		model.addAttribute("view", st);
		return "WhuserTypeView";

	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id",required = false) Integer id ){
		ModelAndView m = new ModelAndView();
		m.setView(new WhuserTypeExcelView());
		if(id==null) {
			//export all rows
			List<WhuserType> list=service.displayAllWhuerTypes();
			m.addObject("list",list);
		}
		else{
			//export one row by id
			WhuserType wt = service.getOneWhuserType(id);
			m.addObject("list",Arrays.asList(wt));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id",required = false) Integer id
			) {
		ModelAndView m = new ModelAndView();
		m.setView(new WhuserTypePdfView());
		if(id==null){//show all
			List<WhuserType> list=service.displayAllWhuerTypes();
			m.addObject("list",list);
		}
		else {//show one
			WhuserType st = service.getOneWhuserType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getWhuserCodeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "WhuserTypeCharts";
	}

	/*
	 * @RequestMapping( value = "/save", method = RequestMethod.POST ) public String
	 * saveWhUserType(@ModelAttribute WhuserType whusertype, ModelMap map) { Integer
	 * id=service.saveWhuserType(whusertype); String
	 * message="WhUserType created with Id:"+id; if(id!=null) { //send email String
	 * text="Welcome to WhUser ="+whusertype.getUserCode()
	 * +", type="+whusertype.getUserType() +", All the best!!";
	 * 
	 * boolean sent=emailUtil.sendEmail( whusertype.getUserMail(), "Welcome WhUser",
	 * text); if(sent) message+=",Email also sent!"; else
	 * message+=",Email Sending Fail!"; } map.addAttribute("message",message);
	 * 
	 * map.addAttribute("whusertype",new WhuserType()) ; return
	 * "WhuserTypeRegister"; }
	 */
}
