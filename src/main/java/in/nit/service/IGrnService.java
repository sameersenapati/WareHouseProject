package in.nit.service;

import java.util.List;

import in.nit.model.Grn;

public interface IGrnService {
	public Integer saveGrnOrder(Grn ob);
	List<Grn> displayAllGrns();
	public void deleteGrnById(Integer id);
	public Grn getOneGrnType(Integer id);
	public void updateGrn(Grn ob);


}
