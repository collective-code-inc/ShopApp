package com.shop.login.modal;

import com.shop.login.dto.product.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "PRODUCT")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
	@SequenceGenerator(name = "item_id_seq", sequenceName = "ITEM_ID_SEQ_GEN")
	private Long id;
	
	@Column(name ="PRODUCT_ID" ,nullable = false, unique = true )
	private String productId;

	@Column(name ="CATEGORY",nullable = false)
	private String category;

	@Column(name ="IMAGES",nullable = false)
	private String image;

	@Column(name ="PRODUCT_DESCRIPTION",nullable = false)
	private String productDescription;

	@Column(name ="PRICE",nullable = false)
	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public ProductEntity(Long id, String productId, String category, String image, String productDescription,
			String price) {
		super();
		this.id = id;
		this.productId = productId;
		this.category = category;
		this.image = image;
		this.productDescription = productDescription;
		this.price = price;
	}

	public ProductEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", productId=" + productId + ", category=" + category + ", image=" + image
				+ ", productDescription=" + productDescription + ", price=" + price + "]";
	}
	
	public static ProductEntity toProductEntity(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategory(productDto.getCategory());
		productEntity.setImage(productDto.getImage());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setProductDescription(productDto.getProductDescription());
		productEntity.setProductId(productDto.getProductId());
		
		return productEntity;
	}


}
