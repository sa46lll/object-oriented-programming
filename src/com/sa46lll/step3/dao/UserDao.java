package com.sa46lll.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sa46lll.step1.vo.User;

/*
 * 클래스를 재사용하기 유리하게 변경 -> 상속
 * 추상 클래스로 UserDao를 구현함으로써 상속받은 UserDao를 상속받은 클래스에서 쉽게 오버라이드해서 사용할 수 있도록 하자.
 */
public abstract class UserDao {

	// access modifier는 protected로 설정
	// 내용을 확장할 method는 abstract method로 지정
	// class는 abstract 클래스가 되어야 한다.
	protected abstract Connection getConnection() throws Exception;

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
