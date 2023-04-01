package com.sa46lll.step3;

import com.sa46lll.step3.dao.NUserDao;
import com.sa46lll.step3.dao.UserDao;
import com.sa46lll.step1.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception {

		User user = new User("sa46lll3", "1234", "kirby");
		UserDao dao = new NUserDao();
		
		dao.insert(user);
		User result = dao.select("sa46lll3");

		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
