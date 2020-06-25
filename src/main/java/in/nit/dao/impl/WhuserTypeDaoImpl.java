package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhuserTypeDao;
import in.nit.model.WhuserType;

@Repository
public class WhuserTypeDaoImpl implements IWhuserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhuserType(WhuserType ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<WhuserType> displayAllWhuerTypes() {
		return ht.loadAll(WhuserType.class);
	}

	@Override
	public void deleteAllWhuserType(Integer id) {
		ht.delete(new WhuserType(id));		
	}

	@Override
	public WhuserType getOneWhuserType(Integer id) {
		return ht.get(WhuserType.class,id);


	}
	@Override
	public void updateWhuserType(WhuserType ob) {
		ht.update(ob);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhuserCodeCount() {
		String hql=" SELECT userCode,COUNT(userCode) "
				+ " from in.nit.model.WhuserType "
				+ " group by userCode ";
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public boolean isUserCodeExist(String userCode) {
		boolean flag=false;
		String hql=" SELECT COUNT(userCode) FROM in.nit.model.WhuserType WHERE userCode=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, userCode);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) flag =false;//data not exist
			else
				flag=true;//data exist
		}
		return flag;
	}

	@Override
	public boolean isUserMailExist(String userMail) {
		boolean flag=false;
		String hql=" SELECT COUNT(userMail) FROM in.nit.model.WhuserType WHERE userMail=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql,userMail);
		if(list!=null && list.size()>0){
			long count=list.get(0);
			if(count==0) flag=false;//not exist
			else
				flag=true;//exist
		}
		return flag;
	}

	@Override
	public boolean isUserContactExist(String userContact) {
		boolean flag=false;
		String hql="SELECT COUNT(userContact) FROM in.nit.model.WhuserType "
				+ " WHERE userContact like '%"+userContact+"' " //without +91
				+" or userContact like '"+userContact+"'"; //with +91
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql);
		if(list!=null && !list.isEmpty()) {
			long count= list.get(0);
			if(count==0) flag=false;//not exist
			else
				flag=true;//exist
		}
		return flag;
	}

	@Override
	public boolean isUserIdNumberExist(String idNumber) {
		boolean flag=false;
		String hql=" SELECT COUNT(idNumber) FROM in.nit.model.WhuserType WHERE idNumber=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, idNumber);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) flag=false;
			else flag=true;

		}
		return flag;
	}


}
