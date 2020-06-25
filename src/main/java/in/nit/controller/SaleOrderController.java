package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {
	@Autowired
	private ISaleOrderService service;


	@RequestMapping("/register")
	public String showUserPage(Model model) {
		//form backing Objects
		model.addAttribute("saleOrder", new SaleOrder());
		return "SaleOrderRegister";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder,Model model) {
		model.addAttribute("saleOrder",new SaleOrder());
		Integer id=service.saveSaleOrder(saleOrder);
		String message="SaleOrder '"+id+"' saved";
		model.addAttribute("message", message);
		return "SaleOrderRegister";
	}




}
