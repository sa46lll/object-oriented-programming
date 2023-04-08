package com.sa46lll.step6;

import com.sa46lll.step1.vo.User;
import com.sa46lll.step6.dao.ConnectionGenerator;
import com.sa46lll.step6.dao.NConnectionGenerator;
import com.sa46lll.step6.dao.UserDao;

public class UserDaoTest {
	public static void main(String[] args) throws Exception {

		User user = new User("sa46lll6", "1234", "kirby");

		ConnectionGenerator connectionGenerator = new NConnectionGenerator();

		// Dependency Injection
		UserDao dao = new UserDao(connectionGenerator);

		dao.insert(user);
		User result = dao.select("sa46lll6");

		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
