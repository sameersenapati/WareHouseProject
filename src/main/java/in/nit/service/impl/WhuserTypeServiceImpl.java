package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhuserTypeDao;
import in.nit.model.WhuserType;
import in.nit.service.IWhuserTypeService;

@Service
public class WhuserTypeServiceImpl implements IWhuserTypeService {
	@Autowired
	private IWhuserTypeDao dao;

	@Transactional
	public Integer saveWhuserType(WhuserType ob) {
		return	dao.saveWhuserType(ob);
	}
	@Transactional
	public List<WhuserType> displayAllWhuerTypes() {
		List<WhuserType> list=dao.displayAllWhuerTypes();
		return list;
	}

	@Transactional
	public void deleteAllWhuserType(Integer id) {
		dao.deleteAllWhuserType(id);
	}
	@Transactional
	public WhuserType getOneWhuserType(Integer id) {
		return dao.getOneWhuserType(id);
	}
	@Transactional
	public void updateWhuserType(WhuserType ob) {
		dao.updateWhuserType(ob);
	}

	@Override
	public List<Object[]> getWhuserCodeCount() {
		return dao.getWhuserCodeCount();
	}
	@Transactional(readOnly = true)
	public boolean isUserCodeExist(String userCode) {
		return dao.isUserCodeExist(userCode);
	}
	@Transactional(readOnly = true)
	public boolean isUserMailExist(String userMail) {
		return dao.isUserMailExist(userMail);
	}
	@Transactional(readOnly = true)
	public boolean isUserContactExist(String userContact) {
		return dao.isUserContactExist(userContact);
	}
	@Transactional(readOnly = true)
	public boolean isUserIdNumberExist(String idNumber) {
		return dao.isUserIdNumberExist(idNumber);
	}

}
