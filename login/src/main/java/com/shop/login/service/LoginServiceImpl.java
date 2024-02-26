package com.shop.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.shop.login.entity.User;
import com.shop.login.entity.repo.UserEntity;
import com.shop.login.entity.repo.UserRepo;

@Service
public class LoginServiceImpl implements LoginInterface {

	@Autowired
	UserRepo userRepo;

	@Override
	public String persistData(User user) {

		UserEntity userEntity = new UserEntity();

		userEntity.setId(user.getId());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());

		userRepo.save(userEntity);
		String response = "Success";

		return response;
		// TODO Auto-generated method stub

	}

}
