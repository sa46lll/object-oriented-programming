package com.sa46lll.step4;

import com.sa46lll.step1.vo.User;
import com.sa46lll.step4.dao.UserDao;

public class UserDaoTest {
	public static void main(String[] args) throws Exception {

		User user = new User("sa46lll4", "1234", "kirby");
		UserDao dao = new UserDao();

		dao.insert(user);
		User result = dao.select("sa46lll4");

		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
