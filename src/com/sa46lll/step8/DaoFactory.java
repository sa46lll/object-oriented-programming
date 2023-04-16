package com.sa46lll.step8;

import com.sa46lll.step8.dao.ConnectionGenerator;
import com.sa46lll.step8.dao.NConnectionGenerator;
import com.sa46lll.step8.dao.UserDao;

public class DaoFactory {
	
	private static DaoFactory instance = new DaoFactory();
	private UserDao userDao;
	private ConnectionGenerator connectionGenerator;
	
	private DaoFactory() {
		userDao = new UserDao(connectionGenerator);
		connectionGenerator = new NConnectionGenerator();
	}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public ConnectionGenerator getConnectionGenerator() {
		return connectionGenerator;
	}
}
