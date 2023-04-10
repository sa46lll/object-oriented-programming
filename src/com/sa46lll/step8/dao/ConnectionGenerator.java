package com.sa46lll.step8.dao;

import java.sql.Connection;

public interface ConnectionGenerator {

	Connection generateConnection() throws Exception;
	
}
