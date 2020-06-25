package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@Component
public class UomValidator implements Validator {
	@Autowired
	private IUomTypeService service;
	
	/**
	 * This method ask which model class objects
	 * are accepted for validation
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return UomType.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		//down cast to model
		UomType uom=(UomType) target;

		//TODO validation logic starts here....
		if(service.isUomModelExist(uom.getUomModel())) {
			errors.rejectValue("uomModel", null, "Uom Model '"+uom.getUomModel()+"' already exist");
		}
	}

}
