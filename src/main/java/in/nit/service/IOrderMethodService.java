package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethods();
	public void deleteOrderMethod(Integer id);	
	public OrderMethod getOneOrderMethod(Integer id);
	public void updateOrderMethod(OrderMethod ob);
	public List<Object[]> getOrderMethodModeCount();
	public List<Object[]> getOrderIdAndCode(String mode);
 
}
