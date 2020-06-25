package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.WhuserType;
import in.nit.service.IWhuserTypeService;
@Component
public class WhuserTypeValidator implements Validator{
	@Autowired
	private IWhuserTypeService service;
	@Override
	public boolean supports(Class<?> clazz) {
		return WhuserType.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		//Downcast to Actual object
		WhuserType user=(WhuserType) target;
		//verify userCode with DB
		if(service.isUserCodeExist(user.getUserCode())) {
			errors.rejectValue("userCode", null,  " User code '"+user.getUserCode()+"' already exist ");

		}
		//verify userMail with DB
		if(service.isUserMailExist(user.getUserMail())) {
			errors.rejectValue("userMail", null, "User Email'"+user.getUserMail()+"'Already Exist");
		}
		//verify userContact with Db
		if(service.isUserContactExist(user.getUserContact())) {
			errors.rejectValue("userContact", null, "User Contact'"+user.getUserContact()+"'Already Exist");
		}
		//verify idNumber with db
		if(service.isUserIdNumberExist(user.getIdNumber())) {
			errors.rejectValue("idNumber", null, "IdNumber'"+user.getIdNumber()+"'Already Exist");

		}
	}
}
