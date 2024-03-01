package com.shop.login.entity;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	@JsonProperty("response")
	public String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public UserResponse(String response) {
		super();
		this.response = response;
	}

	public UserResponse() {
		super();
	}

}
