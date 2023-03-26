package com.sa46lll.step1.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {
	
	private String id;
	private String password;
	private String name;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
}
