package com.shop.login.dto.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;


@Builder
public class JwtResponse {

	@JsonProperty("userName")
	private String username;

	@JsonProperty("token")
	private String jwtToken;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(String username, String jwtToken) {
		super();
		this.username = username;
		this.jwtToken = jwtToken;
	}

	public JwtResponse() {
		super();
	}

	@Override
	public String toString() {
		return "JwtResponse [username=" + username + ", jwtToken=" + jwtToken + "]";
	}

	

}