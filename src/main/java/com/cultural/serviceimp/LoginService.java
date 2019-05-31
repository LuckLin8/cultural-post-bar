package com.cultural.serviceimp;

import com.cultural.bean.User;
import com.cultural.bean.UserInformation;
import com.cultural.daoimp.LoginDao;


public class LoginService {
	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public User find(String username) {
		return loginDao.find(username);		
	}
	public UserInformation getUserInfo(Integer userId) {
		return loginDao.getUserInfo(userId);
	}
}
