package com.sa46lll.step7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa46lll.step1.vo.User;

public class UserDao {

	private ConnectionGenerator connectionGenerator;

	public UserDao(ConnectionGenerator connectionGenerator) {
		this.connectionGenerator = connectionGenerator;
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
