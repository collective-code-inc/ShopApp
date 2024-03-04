package com.shop.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {
	
	@GetMapping("/user")
	public String test() {
        
        return "Testing message";
    }

}
