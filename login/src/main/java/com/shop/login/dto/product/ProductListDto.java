package com.shop.login.dto.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductListDto {

	@JsonProperty("productList")
	private List<ProductDto> productList;

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	public ProductListDto(List<ProductDto> productList) {
		super();
		this.productList = productList;
	}

	public ProductListDto() {
		super();
	}

	@Override
	public String toString() {
		return "ProductListDto [productList=" + productList + "]";
	}

}
