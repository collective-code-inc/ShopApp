package com.shop.login.dto.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;


@Builder
public class JwtResponse {

	@JsonProperty("message")
	private String message;

	@JsonProperty("token")
	private String jwtToken;


	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(String message, String jwtToken) {
		super();
		this.message = message;
		this.jwtToken = jwtToken;
	}

	public JwtResponse() {
		super();
	}

	@Override
	public String toString() {
		return "JwtResponse [message=" + message + ", jwtToken=" + jwtToken + "]";
	}

	

}