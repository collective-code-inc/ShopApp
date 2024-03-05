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
import com.shop.login.dto.user.JwtResponse;
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
		String response = loginService.login(loginReq);
		if(response.equals(Constants.LOGIN_SUCCESS)) {
			String token = jwtUtil.generateToken(loginReq.getUserName());

			JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).username(loginReq.getUserName()).build();
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		}
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}

}
