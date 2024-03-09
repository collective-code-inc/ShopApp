package com.shop.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.login.dto.user.LoginReq;
import com.shop.login.dto.user.UserReq;
import com.shop.login.modal.UserEntity;
import com.shop.login.repo.UserRepo;
import com.shop.login.util.Constants;

import jakarta.transaction.Transactional;

@Service
public class LoginService {

	@Autowired
	UserRepo userRepo;
	
	@Transactional
	public String registerUser(UserReq user) {
		UserEntity userEntity = UserEntity.toUserEntity(user);
		if (userRepo.findByUserName(user.getUserName()) == null ) {
			userRepo.save(userEntity);
			return Constants.USER_REGISTERED;
		}
		return Constants.USER_EXISTS;
	}

	public String login(LoginReq loginReq) {
		UserEntity userEntity =userRepo.findByUserName(loginReq.getUserName());
		if(userEntity == null || !userEntity.getPassword().equals(loginReq.getPassword())) {
			return Constants.LOGIN_FAILED;
		}
		return Constants.LOGIN_SUCCESS;
	}

}
