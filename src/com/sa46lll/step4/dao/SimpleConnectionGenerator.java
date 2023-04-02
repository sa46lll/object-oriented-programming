package com.sa46lll.step4.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleConnectionGenerator {
	public Connection getConnection() throws Exception {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 데이터베이스 접속
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "sa46lll";
		String pw = "me";
		return DriverManager.getConnection(jdbcUrl, id, pw);
	}
}
