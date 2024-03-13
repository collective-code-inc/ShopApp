package com.shop.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.login.dto.product.ProductDto;
import com.shop.login.dto.product.ProductListDto;
import com.shop.login.modal.ProductEntity;
import com.shop.login.repo.ProductRepo;
import com.shop.login.util.Constants;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public String saveProduct(ProductListDto productList) {
		String response=null;
		for (ProductDto product : productList.getProductList()) {
			ProductEntity productEntity = ProductEntity.toProductEntity(product);
			if (productRepo.findByProductId(product.getProductId()) == null ) {
				productRepo.save(productEntity);
			response= Constants.PRODUCT_REGISTERED;
		}
		response= Constants.PRODUCT_EXISTS;
	}
	return response;
}
}
