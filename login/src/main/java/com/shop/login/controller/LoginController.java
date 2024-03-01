package com.shop.login.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.login.dto.user.LoginReq;
import com.shop.login.dto.user.UserReq;
import com.shop.login.service.LoginService;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/api")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response createUser(@RequestBody UserReq user) {
		String response = loginService.persistData(user);
		return Response.ok(response).build();

	}

	@PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response login(@RequestBody LoginReq loginReq) {
		String response = loginService.login(loginReq);
		return Response.ok(response).build();

	}

}
