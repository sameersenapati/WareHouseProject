package in.nit.dao;

import java.util.List;

import in.nit.model.Shipping;


public interface IShippingDao {
	public Integer saveShippingOrder(Shipping ob);
	List<Shipping> displayAllShippings();
	public void deleteShippingById(Integer id);
	public Shipping getOneShipping(Integer id);
	public void updateShipping(Shipping ob);

}
