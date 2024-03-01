package com.shop.login.util;

import lombok.Data;

@Data
public class MessageUtil {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	public MessageUtil() {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageUtil [message=" + message + ", getMessage()=" + getMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
