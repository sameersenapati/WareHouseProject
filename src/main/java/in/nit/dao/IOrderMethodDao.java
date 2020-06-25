package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;



public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethods();
	public void deleteOrderMethod(Integer id);	
	public OrderMethod getOneOrderMethod(Integer id);
	public void updateOrderMethod(OrderMethod ob);
	public List<Object[]> getOrderMethodModeCount();
	List<Object[]> getOrderIdAndCode(String mode);
	
}
