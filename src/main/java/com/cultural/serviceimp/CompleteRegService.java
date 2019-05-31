package com.cultural.serviceimp;


import com.cultural.bean.UserInformation;
import com.cultural.daoimp.CompleteRegDao;

public class CompleteRegService {
	private CompleteRegDao completeRegDao;

	public CompleteRegDao getCompleteRegDao() {
		return completeRegDao;
	}

	public void setCompleteRegDao(CompleteRegDao completeRegDao) {
		this.completeRegDao = completeRegDao;
	}
	public void save(UserInformation userInformation) {
		completeRegDao.save(userInformation);
	}
	public void updateUserInfo(UserInformation userInformation) {
		completeRegDao.updateUserInfo(userInformation);
	}
}
