package com.sa46lll.step8.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NConnectionGenerator implements ConnectionGenerator {

	@Override
	public Connection generateConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String id = "sa46lll";
		String pw = "me";
		return DriverManager.getConnection(jdbcUrl, id, pw);
	}
}
