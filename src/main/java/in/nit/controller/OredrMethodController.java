package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.util.OrderMethodUtil;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OredrMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;

	@RequestMapping("/register") // GET
	public String showRegisterPage(Model model) {
		//Form Backing Objects
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute OrderMethod orderMethod, Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		Integer id = service.saveOrderMethod(orderMethod);
		String message = "OrderMethod '" + id + "' saved ";
		model.addAttribute("message", message);
		return "OrderMethodRegister";
	}

	@RequestMapping("/all") //GET 
	public String getAllOrderMethods(Model model) {
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}



	@RequestMapping("/delete")  //GET
	public String deleteOrderMethod(
			@RequestParam("oid") Integer id, Model model) {
		service.deleteOrderMethod(id);
		String message = "Order '"+id+"' deleted";
		model.addAttribute("message", message);
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData"; //pageName
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid") Integer id,Model model) {
		OrderMethod od= service.getOneOrderMethod(id);
		model.addAttribute("orderMethod", od);
		return "OrderMethodEdit";
	}

	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateOrderMethod(
			@ModelAttribute OrderMethod orderMethod,Model model
			) {
		service.updateOrderMethod(orderMethod);
		String message="OrderMethod '"+orderMethod.getOrderId()+"' Updated";
		model.addAttribute(message, message);
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	@RequestMapping(value="/view")
	public String getOneOrderMethod(@RequestParam("oid")Integer id,Model model) {
		OrderMethod st=service.getOneOrderMethod(id);
		model.addAttribute("view", st);
		return "OrderMethodView";

	}


	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id",required = false) Integer id ){
		ModelAndView m = new ModelAndView();
		m.setView(new OrderMethodExcelView());
		if(id==null) {
			//export all rows
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}
		else{
			//export one row by id
			OrderMethod st = service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}


	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id",required = false) Integer id
			) {
		ModelAndView m = new ModelAndView();
		m.setView(new OrderMethodPdfView());
		if(id==null){//show all
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}
		else {//show one
			OrderMethod st = service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}


	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getOrderMethodModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "OrderMethodCharts";
	}
}
