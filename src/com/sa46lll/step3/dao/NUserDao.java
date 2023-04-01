package com.sa46lll.step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NUserDao extends UserDao {

	@Override
	protected Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "sa46lll";
		String pw = "me";
		return DriverManager.getConnection(jdbcUrl, id, pw);
	}
}
