package com.shop.login.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

	@JsonProperty("productId")
	private String productId;

	@JsonProperty("category")
	private String category;

	@JsonProperty("image")
	private String image;

	@JsonProperty("productDescription")
	private String productDescription;

	@JsonProperty("price")
	private String price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public ProductDto(String productId, String category, String image, String productDescription, String price) {
		super();
		this.productId = productId;
		this.category = category;
		this.image = image;
		this.productDescription = productDescription;
		this.price = price;
	}

	public ProductDto() {
		super();
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", category=" + category + ", image=" + image
				+ ", productDescription=" + productDescription + ", price=" + price + "]";
	}
	
}
