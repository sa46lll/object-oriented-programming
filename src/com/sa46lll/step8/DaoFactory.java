package com.sa46lll.step8;

import com.sa46lll.step8.dao.ConnectionGenerator;
import com.sa46lll.step8.dao.NConnectionGenerator;
import com.sa46lll.step8.dao.UserDao;

public class DaoFactory {
	
	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory() {
    }
	
	public static DaoFactory getInstance() {
        return instance;
    }

	public UserDao userDao() {
		return new UserDao(connectionGenerator());
	}
	
	public ConnectionGenerator connectionGenerator() {
		return new NConnectionGenerator();
	}
}
