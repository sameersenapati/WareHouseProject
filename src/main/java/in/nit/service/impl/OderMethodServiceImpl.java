package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Service
public class OderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;
	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {
		return dao.saveOrderMethod(ob);
	}
	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		List<OrderMethod> list=dao.getAllOrderMethods();
		Collections.sort(list,(o1,o2)->o1.getOrderId()-o2.getOrderId());
		return list;
	}
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}
	@Transactional(readOnly = true)
	
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}
	@Transactional
	public void updateOrderMethod(OrderMethod ob) {
		dao.updateOrderMethod(ob);
	}
	@Transactional
	public List<Object[]> getOrderMethodModeCount() {
		return dao.getOrderMethodModeCount();
	}
	@Transactional
	public List<Object[]> getOrderIdAndCode(String mode) {
		return dao.getOrderIdAndCode(mode);
	}
}
