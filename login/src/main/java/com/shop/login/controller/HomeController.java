package com.shop.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.login.dto.product.ProductListDto;
import com.shop.login.dto.product.ProductRegisterResponse;
import com.shop.login.service.ProductService;

@RestController
@RequestMapping(path = "/home")
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	//This method is used to save new products in the DB 
	@PostMapping("/registerProduct")
	@ResponseBody
	public ResponseEntity<String> registerProduct(@RequestBody ProductListDto productList) {
		ProductRegisterResponse productRegisterResponse = new ProductRegisterResponse();
		String response = productService.saveProduct(productList);
		//productRegisterResponse.s
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	
	
	
	

}
