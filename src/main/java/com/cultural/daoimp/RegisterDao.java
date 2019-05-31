package com.cultural.daoimp;

import com.cultural.bean.User;


public class RegisterDao extends BaseDao {
	
	public void save(User user) {		
		getSession().saveOrUpdate(user);
	}
	
}
