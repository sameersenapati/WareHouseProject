package in.nit.dao;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeDao {

	public Integer saveUomType(UomType ob);
	List<UomType> displayAllUomTypes();
	public void deleteUomById(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ob);
	public List<Object[]> getUomModelCount();
	List<Object[]> getUomIdAndUomModel();
	boolean isUomModelExist(String uomModel);

}
