package in.nit.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.ISaleOrderDao;
import in.nit.model.SaleOrder;

@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveSaleOrder(SaleOrder ob) {
		return (Integer) ht.save(ob);
	}

}
