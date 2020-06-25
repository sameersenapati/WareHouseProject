package in.nit.dao;

import java.util.List;

import in.nit.model.Grn;

public interface IGrnDao {
	public Integer saveGrnOrder(Grn ob);
	List<Grn> displayAllGrns();
	public void deleteGrnById(Integer id);
	public Grn getOneGrnType(Integer id);
	public void updateGrn(Grn ob);

}
