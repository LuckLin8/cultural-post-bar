package com.cultural.serviceimp;

import com.cultural.bean.User;
import com.cultural.daoimp.RegisterDao;


public class RegisterService {
	private RegisterDao registerDao;
	
	public RegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}

	public void save(User user) {
		registerDao.save(user);
		
	}
	
	
}
