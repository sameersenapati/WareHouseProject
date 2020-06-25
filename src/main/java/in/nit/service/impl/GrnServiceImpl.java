package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IGrnDao;
import in.nit.model.Grn;
import in.nit.service.IGrnService;

@Service
public class GrnServiceImpl implements IGrnService {
	@Autowired
	private IGrnDao dao;
	@Transactional
	public Integer saveGrnOrder(Grn ob) {
		return dao.saveGrnOrder(ob);
	}

	@Transactional(readOnly = true)
	public List<Grn> displayAllGrns() {
		return dao.displayAllGrns();
	}

	@Transactional
	public void deleteGrnById(Integer id) {
		dao.deleteGrnById(id);
	}

	@Transactional(readOnly = true)
	public Grn getOneGrnType(Integer id) {
		return dao.getOneGrnType(id);
	}

	@Transactional
	public void updateGrn(Grn ob) {
		dao.updateGrn(ob);

	}

}
