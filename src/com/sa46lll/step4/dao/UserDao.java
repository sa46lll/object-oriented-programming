package com.sa46lll.step4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa46lll.step1.vo.User;

/*
 * 의존성 주입을 통해 객체 간의 결합도를 낮추자. (UserDao가 SimpleConnectionGenerator를 직접 생성해주지 않고, 생성자를 통해 주입받음)
 */
public class UserDao {

	private SimpleConnectionGenerator simpleConnectionGenerator;

	public UserDao() {
		simpleConnectionGenerator = new SimpleConnectionGenerator();
	}

	public void insert(User user) throws Exception {

		Connection conn = simpleConnectionGenerator.getConnection();

		// 3. PreparedStatement
		String sql = "INSERT INTO users VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());

		// 4. SQL 실행
		int result = pstmt.executeUpdate();

		// 5. 결과 처리
		// 6. resource 해제
		pstmt.close();
		conn.close();
	}

	public User select(String userId) throws Exception {

		Connection conn = simpleConnectionGenerator.getConnection();

		// 3. PreparedStatement
		String sql = "SELECT id, password, name FROM users WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);

		// 4. SQL 실행
		ResultSet result = pstmt.executeQuery();

		// 5. 결과 처리
		User user = new User();
		if (result.next()) {
			user = new User(result.getString("id"), result.getString("password"), result.getString("name"));
		}

		// 6. resource 해제
		result.close();
		pstmt.close();
		conn.close();

		return user;
	}

}
