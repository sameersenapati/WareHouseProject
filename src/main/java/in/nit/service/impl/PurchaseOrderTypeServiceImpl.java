
package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseOrderTypeDao;
import in.nit.model.PurchaseDtl;
import in.nit.model.PurchaseOrderType;
import in.nit.service.IPurchaseOrderTypeService;

@Service
public class PurchaseOrderTypeServiceImpl implements IPurchaseOrderTypeService {
	@Autowired
	private IPurchaseOrderTypeDao dao;

	@Transactional
	public Integer saveOrderType(PurchaseOrderType p) {
		return dao.saveOrderType(p);
	}

	@Transactional(readOnly = true)
	public List<PurchaseOrderType> displayAllPurchaseOrderTypes() {
		List<PurchaseOrderType> list=dao.displayAllPurchaseOrderTypes();
		return list;
	}

	@Transactional
	public void deletePurchaseOrderId(Integer id) {
		dao.deletePurchaseOrderId(id);
	}

	@Transactional(readOnly = true)
	public PurchaseOrderType getOnePurchaseOrderType(Integer id) {
		return dao.getOnePurchaseOrderType(id);
	}

	@Transactional
	public void updatePurchaseOrderType(PurchaseOrderType ob) {
		dao.updatePurchaseOrderType(ob);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getPurchaseOrderCodeCount() {
		return dao.getPurchaseOrderCodeCount();
	}

	@Transactional 
	public Integer savePurchaseDtl(PurchaseDtl dtl) {
		return dao.savePurchaseDtl(dtl);
	}

	@Transactional
	public void deletePurchaseDtl(Integer id) {
		dao.deletePurchaseDtl(id);
	}

	@Transactional
	public void updatePoStatus(Integer poId, String status) {
		dao.updatePoStatus(poId, status);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getPurchaseOrderIdAndCode() {
		return dao.getPurchaseOrderIdAndCode();
	}
	
}//class
