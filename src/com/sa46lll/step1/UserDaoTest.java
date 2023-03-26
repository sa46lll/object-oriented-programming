package com.sa46lll.step1;

import com.sa46lll.step1.dao.UserDao;
import com.sa46lll.step1.vo.User;

public class UserDaoTest {
	public static void main(String[] args) throws Exception {
		
		User user = new User("sa46lll", "1234", "kirby");
		UserDao dao = new UserDao();
		
		dao.insert(user);
		User result = dao.select("sa46lll");
		
		if (result != null) {
			System.out.println("새로운 사용자가 등록되었어요!");
		}
	}
}
