package com.megaeyes.service.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.impl.TUserDAOImpliBatis;
import com.megaeyes.persistence.ibatis.model.TUser;
import com.megaeyes.persistence.ibatis.model.TUserExample;
import com.megaeyes.service.iface.TestManager;

public class TestManagerImpl implements TestManager {
	private TUserDAOImpliBatis userDao;
	
	
	public void setUserDao(TUserDAOImpliBatis userDao) {
		this.userDao = userDao;
	}


	public List<TUser> test(){
		TUserExample example = new TUserExample();
		example.createCriteria().andIdIsNotNull();
		return  userDao.selectByExample(example);
	}
}
