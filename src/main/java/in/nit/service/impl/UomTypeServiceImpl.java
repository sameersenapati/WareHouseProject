package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@Service
public class UomTypeServiceImpl implements IUomTypeService {
	@Autowired
	private IUomTypeDao dao;


	@Transactional
	@Override
	public Integer saveUomType(UomType ob) {
		return	dao.saveUomType(ob);
	}

	@Transactional
	public List<UomType> displayAllUomTypes(){
		List<UomType> list=dao.displayAllUomTypes();
		return list;
	}

	@Transactional

	public void deleteUomById(Integer id) {
		dao.deleteUomById(id);
	}

	@Transactional(readOnly = true)
	public UomType getOneUomType(Integer id) {
		return dao.getOneUomType(id);

	}
	@Transactional
	public void updateUomType(UomType ob) {
		dao.updateUomType(ob);
	}
	@Transactional
	public List<Object[]> getUomModelCount() {
		return dao.getUomModelCount();
	}

	@Transactional
	public List<Object[]> getUomIdAndUomModel() {
		return dao.getUomIdAndUomModel();
	}

	@Override
	public boolean isUomModelExist(String uomModel) {
		return dao.isUomModelExist(uomModel);
	}
}
