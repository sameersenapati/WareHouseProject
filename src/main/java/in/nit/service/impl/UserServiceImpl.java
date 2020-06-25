package in.nit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUserDao;
import in.nit.model.User;
import in.nit.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Transactional
	public Integer saveUser(User user) {
		//read password enter in the ui
		String pwd=user.getUserPwd();
		//Encode password
		pwd=encoder.encode(pwd);
		//sent back to model object
		user.setUserPwd(pwd);
		return dao.saveUser(user);
	}

}//class
