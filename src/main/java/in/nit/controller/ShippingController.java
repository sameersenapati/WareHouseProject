package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Shipping;
import in.nit.service.IShippingService;
@Controller
@RequestMapping("/shipping")
public class ShippingController {
	@Autowired
	private IShippingService service;

	@RequestMapping("/regi")
	public String showUserPage(Model model) {
		//form backing objects 
		model.addAttribute("shipping", new Shipping());
		return "ShippingRegister";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveShipping(@ModelAttribute Shipping shipping,Model model) {
		model.addAttribute("shipping", new Shipping());
		Integer id=service.saveShippingOrder(shipping);
		String message="Shipping '"+id+"'Saved";
		model.addAttribute("message", message);
		return "ShippingRegister";
	}

}
