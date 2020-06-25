package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartTypeDao;
import in.nit.model.PartType;

@Repository
public class PartTypeDaoImpl implements IPartTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePartType(PartType ob) {
		return (Integer) ht.save(ob);
	}

	@Override
	public List<PartType> displayAllPartTypes() {
		return ht.loadAll(PartType.class);
	}

	@Override
	public void deletePartTypeId(Integer id) {
		ht.delete(new PartType(id));
	}

	@Override
	public PartType getOnePartType(Integer id) {
		return ht.get(PartType.class,id);
	}

	@Override
	public void updatePartType(PartType ob) {
		ht.update(ob);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getPartCodeCount() {
		String hql=" select partCode,count(partCode)  "
				+ " from in.nit.model.ShipmentType"
				+ " group by partCode";
		return (List<Object[]>) ht.find(hql);
	}

}
