package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseDtl;
import in.nit.model.PurchaseOrderType;

public interface IPurchaseOrderTypeService {
	Integer saveOrderType( PurchaseOrderType p);
	List<PurchaseOrderType> displayAllPurchaseOrderTypes();
	public void deletePurchaseOrderId(Integer id);
	public PurchaseOrderType getOnePurchaseOrderType(Integer id);
	public void updatePurchaseOrderType(PurchaseOrderType ob);
	public List<Object[]> getPurchaseOrderCodeCount();

	//----------------Screen#2 Operations---------------
	public Integer savePurchaseDtl(PurchaseDtl dtl);
	public void deletePurchaseDtl(Integer id);

	public void updatePoStatus(Integer poId,String status);

	//-----------------------Integration methods--------
	public List<Object[]> getPurchaseOrderIdAndCode();



}
