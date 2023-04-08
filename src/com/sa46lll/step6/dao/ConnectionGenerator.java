package com.sa46lll.step6.dao;

import java.sql.Connection;

public interface ConnectionGenerator {
	
	Connection generateConnection() throws Exception;
	
}
