package com.sa46lll.step7;

import com.sa46lll.step7.dao.ConnectionGenerator;
import com.sa46lll.step7.dao.NConnectionGenerator;
import com.sa46lll.step7.dao.UserDao;

public class DaoFactory {

	public UserDao userDao() {
		UserDao dao = new UserDao(connectionGenerator());
		return dao;
	}
	
	public ConnectionGenerator connectionGenerator() {
		return new NConnectionGenerator();
	}
}
