package com.shop.login.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserReq {
    @JsonProperty("emailId")
	private String emailId;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("userName")
	private String userName;

	@JsonProperty("password")
	private String password;

	public String getEmail_Id() {
		return emailId;
	}

	public void setEmail_Id(String email_Id) {
		this.emailId = email_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public UserReq(String emailId, String firstName, String lastName, String userName, String password) {
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
    
}
