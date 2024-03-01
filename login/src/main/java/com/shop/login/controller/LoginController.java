package com.shop.login.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.login.entity.User;
import com.shop.login.entity.UserResponse;
import com.shop.login.service.LoginInterface;

@RestController
@RequestMapping(path = "/api")
public class LoginController {

	@Autowired
	LoginInterface loginInterface;

	@PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserResponse createUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		String response = loginInterface.persistData(user);
		userResponse.setResponse(response);
		return userResponse;

	}
	
	//@PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	
}
