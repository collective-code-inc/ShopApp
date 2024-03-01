package com.shop.login.modal;

import com.shop.login.dto.user.UserReq;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
	@SequenceGenerator(name = "user_id_seq", sequenceName = "USER_ID_SEQ_GEN")
	private Long id;

	@Column(name = "EMAIL_ID", nullable = false, unique = true)
	private String email;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "USER_NAME", nullable = false)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public UserEntity(Long id, String email, String firstName, String lastName, String userName, String password) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public UserEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + "]";
	}

	public static UserEntity toUserEntity(UserReq userReq) {
		UserEntity userEntity = new UserEntity();

		userEntity.setEmail(userReq.getEmail_Id());
		userEntity.setFirstName(userReq.getFirstName());
		userEntity.setLastName(userReq.getLastName());
		userEntity.setUserName(userReq.getUserName());
		userEntity.setPassword(userReq.getPassword());
		return userEntity;
	}
	
	

}
