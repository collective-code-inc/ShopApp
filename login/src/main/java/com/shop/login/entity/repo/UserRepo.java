package com.shop.login.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.login.entity.User;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {

	// boolean findByUserName(String userName);

	UserEntity findByUserName(String userName);

}
