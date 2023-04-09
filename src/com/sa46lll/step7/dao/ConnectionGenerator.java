package com.sa46lll.step7.dao;

import java.sql.Connection;

public interface ConnectionGenerator {
	
	Connection generateConnection() throws Exception;
	
}
