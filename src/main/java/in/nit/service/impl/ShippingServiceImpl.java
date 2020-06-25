package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShippingDao;
import in.nit.model.Shipping;
import in.nit.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private IShippingDao dao;
	@Transactional
	public Integer saveShippingOrder(Shipping ob) {
		return dao.saveShippingOrder(ob);
	}

	@Transactional
	public List<Shipping> displayAllShippings() {
		List<Shipping> list=dao.displayAllShippings();
		return list;
	}

	@Transactional
	public void deleteShippingById(Integer id) {
		dao.deleteShippingById(id);
	}

	@Transactional(readOnly = true)
	public Shipping getOneShipping(Integer id) {
		return dao.getOneShipping(id);
	}

	@Transactional
	public void updateShipping(Shipping ob) {
		dao.updateShipping(ob);
	}

}
