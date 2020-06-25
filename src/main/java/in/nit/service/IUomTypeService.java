package in.nit.service;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeService {
	public Integer saveUomType(UomType ob);
	List<UomType> displayAllUomTypes();
	public void deleteUomById(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ob);
	public List<Object[]> getUomModelCount();
	public List<Object[]> getUomIdAndUomModel();
	boolean isUomModelExist(String uomModel);
}
