package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.PurchaseOrderType;
import in.nit.service.IPurchaseOrderTypeService;
import in.nit.service.IShipmentTypeService;
import in.nit.util.CommonUtil;

@Controller
@RequestMapping({ "/po" })
public class PurchaseOrderTypeController
{
	@Autowired
	private IPurchaseOrderTypeService service;
	@Autowired
	private IShipmentTypeService shipSerivice;

	@SuppressWarnings("unused")
	private void commonUi(Model model) {
		List<Object[]> shipList = shipSerivice.getShipIdAndCode();
		Map<Integer,String> shipMap = CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);
	}
	@RequestMapping({ "/register" })
	public String showPurchasePage(@ModelAttribute PurchaseOrderType purchaseOrderType,Model model) {
		//form backing Objects
		model.addAttribute("purchaseOrderType", new PurchaseOrderType());
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value = "/save" , method =  POST )
	public String savePurchase(@ModelAttribute PurchaseOrderType purchaseOrderType, Model model) {
		PurchaseOrderType  pot=new PurchaseOrderType();
		pot.setStatus("OPEN");
		model.addAttribute("pot");
		Integer id = service.saveOrderType(purchaseOrderType);
		String message = "PurchaseOrderType '" + id + "' saved ";
		model.addAttribute("message",message);
		return "PurchaseOrderRegister";
	}
	@RequestMapping("/all")
	public String diplayAll(Model model) {
		List<PurchaseOrderType> list=service.displayAllPurchaseOrderTypes();
		model.addAttribute("list",list);
		return "PurchaseOrderTypeData";
	}

	@RequestMapping("/delete")
	public String deletePurchaseOrderType(@RequestParam("poid") Integer id,Model model) {
		service.deletePurchaseOrderId(id);
		String message = "PurchaseOrderType '"+id+"' deleted";
		model.addAttribute("message",message);
		List<PurchaseOrderType> list=service.displayAllPurchaseOrderTypes();
		model.addAttribute("list",list);
		return "PurchaseOrderTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("poid") Integer id,Model model) {
		PurchaseOrderType pot = service.getOnePurchaseOrderType(id);
		model.addAttribute("purchaseOrderType", pot);
		return "PurchaseOrderTypeEdit";
	}

	@RequestMapping(value="/update",method = POST)
	public String updatePurchaseOrderType(
			@ModelAttribute PurchaseOrderType purchaseOrderType,Model model
			) {
		service.updatePurchaseOrderType(purchaseOrderType);
		String message="purchaseOrderType '"+purchaseOrderType.getId()+"' Updated";
		model.addAttribute(message, message);
		List<PurchaseOrderType> list=service.displayAllPurchaseOrderTypes();
		model.addAttribute("list", list);
		return "PurchaseOrderTypeData";
	}

	@RequestMapping(value="/view")
	public String getOnePurchaseOrderType(@RequestParam("poid")Integer id,Model model) {
		PurchaseOrderType st=service.getOnePurchaseOrderType(id);
		model.addAttribute("view", st);
		return "PurchaseOrderTypeView";

	}

}
