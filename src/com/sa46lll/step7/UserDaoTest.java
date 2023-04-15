package com.sa46lll.step7;

import com.sa46lll.step1.vo.User;
import com.sa46lll.step7.dao.UserDao;

/*
 * 객체 생성하는 열할을 DaoFactory에 위임함 (Factory Method 패턴)
 */
public class UserDaoTest {
	public static void main(String[] args) throws Exception {

		User user = new User("sa46lll6", "1234", "kirby");
		
		UserDao dao = (new DaoFactory()).userDao();
		
		dao.insert(user);
		User result = dao.select("sa46lll6");
		
		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
