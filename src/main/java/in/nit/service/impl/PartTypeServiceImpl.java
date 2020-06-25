package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartTypeDao;
import in.nit.model.PartType;
import in.nit.service.IPartTypeService;

@Service
public class PartTypeServiceImpl implements IPartTypeService {
	@Autowired
	private IPartTypeDao dao;

	@Transactional
	public Integer savePartType(PartType ob) {
		return dao.savePartType(ob);
	}

	@Transactional
	public List<PartType> displayAllPartTypes() {
		List<PartType> list=dao.displayAllPartTypes();
		return list;
	}

	@Transactional
	public void deletePartTypeId(Integer id) {
		dao.deletePartTypeId(id);
	}

	@Transactional(readOnly = true)
	public PartType getOnePartType(Integer id) {
		return dao.getOnePartType(id);
	}

	@Transactional
	public void updatePartType(PartType ob) {
		dao.updatePartType(ob);
	}

	@Transactional
	public List<Object[]> getPartCodeCount() {
		return dao.getPartCodeCount();
	}

}
