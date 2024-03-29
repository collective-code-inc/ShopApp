package com.shop.login.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.login.dto.jwt.JwtResponse;
import com.shop.login.dto.user.LoginReq;
import com.shop.login.dto.user.UserReq;
import com.shop.login.jwt.security.JwtUtil;
import com.shop.login.service.LoginService;
import com.shop.login.util.Constants;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/api")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response createUser(@RequestBody UserReq user) {
		String response = loginService.registerUser(user);
		return Response.ok(response).build();

	}

	@PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JwtResponse> login(@RequestBody LoginReq loginReq) {
		String token = null;
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
		String response = loginService.login(loginReq);
		if(response.equals(Constants.LOGIN_SUCCESS)) {
			token = jwtUtil.generateToken(loginReq.getUserName());
			httpStatus = HttpStatus.OK;
		}
		JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).message(response).build();
		return new ResponseEntity<>(jwtResponse, httpStatus);
			
	}

}
