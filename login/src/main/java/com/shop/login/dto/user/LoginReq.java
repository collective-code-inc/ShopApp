package com.shop.login.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReq {

	@JsonProperty("userName")
	private String userName;

	@JsonProperty("password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public LoginReq(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
}
