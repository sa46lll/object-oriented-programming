package com.sa46lll.step2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa46lll.step1.vo.User;

/*
 * 관심사 분리 (SOC)
 * 중복 코드를 제거하여 유지보수성과 코드의 가독성 향상
 */
public class UserDao {

	private Connection getConnection() throws Exception {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 데이터베이스 접속
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "sa46lll";
		String pw = "me";
		return DriverManager.getConnection(jdbcUrl, id, pw);
	}

	public void insert(User user) throws Exception {

		Connection conn = getConnection();

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

		Connection conn = getConnection();

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
