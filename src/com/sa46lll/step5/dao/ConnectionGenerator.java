package com.sa46lll.step5.dao;

import java.sql.Connection;

public interface ConnectionGenerator {
	// UserDao가 이 interface를 통해 실제 Connection을 생성하는 class와 연결된다.
	// 즉, 해당 interface의 method를 통해 두 클래스가 서로 연동될 수 있다.

	// UserDao는 이 interface의 구현체의 method를 통해 데이터베이스 connection을 획득할 거예요!
	Connection generateConnection() throws Exception;
}
