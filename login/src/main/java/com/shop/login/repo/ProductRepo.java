package com.shop.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.login.modal.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, String>{

	ProductEntity findByProductId(String productId);

}
