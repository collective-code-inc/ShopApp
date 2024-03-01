package com.shop.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.login.modal.UserEntity;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {

	UserEntity findByUserName(String userName);

}
