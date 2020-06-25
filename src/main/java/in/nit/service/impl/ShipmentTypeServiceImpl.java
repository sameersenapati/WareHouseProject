package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		return	dao.saveShipmentType(ob);
	}

	@Transactional
	public List<ShipmentType> displayAllShipmentTypes() {
		List<ShipmentType> list=dao.displayAllShipmentTypes();
		return list;

	}

	@Transactional
	public void deleteShipmentById(Integer id) {
		dao.deleteShipmentById(id);

	}

	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(Integer id) {
		return dao.getOneShipmentType(id);
	}

	@Transactional
	public void updateShipmentType(ShipmentType ob) {
		dao.updateShipmentType(ob);

	}

	@Transactional
	public List<Object[]> getShipmentModeCount() {
		return dao.getShipmentModeCount();
	}
	@Transactional(readOnly = true)
	public List<Object[]> getShipIdAndCode() {
		return dao.getShipIdAndCode();
	}

}
