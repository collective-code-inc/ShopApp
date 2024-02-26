package com.shop.login.entity.repo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Create_User")
public class UserEntity {
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public UserEntity(String id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public UserEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

	
}
