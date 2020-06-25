package in.nit.service;

import java.util.List;

import in.nit.model.PartType;

public interface IPartTypeService {
	public Integer savePartType(PartType ob);
	List<PartType> displayAllPartTypes();
	public void deletePartTypeId(Integer id);
	public PartType getOnePartType(Integer id);
	public void updatePartType(PartType ob);
	public List<Object[]> getPartCodeCount();
}
