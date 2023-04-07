package com.sa46lll.step5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa46lll.step1.vo.User;

/*
 * 인터페이스를 통해 UserDao 클래스가 사용하는 ConnectionGenerator 인터페이스의 구현체를 언제든지 변경할 수 있게 하자. -> 애플리케이션의 확장성을 높이고, 코드의 재사용성을 높이자.
 * UserDao 클래스가 ConnectionGenerator 인터페이스의 구현체를 직접 다루지 않고 추상화된 인터페이스에만 의존하도록 한다. (코드를 유연하게, 유지보수성을 높일 수 있다.)
 */
public class UserDao {

	private ConnectionGenerator connectionGenerator;

	public UserDao() {
		connectionGenerator = new NConnectionGenerator();
	}

	public void insert(User user) throws Exception {

		Connection conn = connectionGenerator.generateConnection();

		String sql = "INSERT INTO users VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public User select(String userId) throws Exception {

		Connection conn = connectionGenerator.generateConnection();

		String sql = "SELECT id, password, name FROM users WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);

		ResultSet result = pstmt.executeQuery();

		User user = new User();
		if (result.next()) {
			user = new User(result.getString("id"), result.getString("password"), result.getString("name"));
		}

		result.close();
		pstmt.close();
		conn.close();

		return user;
	}
}
