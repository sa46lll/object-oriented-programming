package com.sa46lll.step8;

import com.sa46lll.step1.vo.User;
import com.sa46lll.step8.dao.UserDao;

/*
 * 싱글톤 패턴을 적용하여 하나의 DaoFactory가 생성되게 한다.
 */
public class UserDaoTest {
	
	private static DaoFactory daoFactory = DaoFactory.getInstance();
	
	public static void main(String[] args) throws Exception {
		
		User user = new User("sa46lll8", "1234", "kirby");
		
		UserDao dao = daoFactory.userDao();
		
		dao.insert(user);
		User result = dao.select("sa46lll8");
		
		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
