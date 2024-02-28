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
		String message;

		userEntity.setId(user.getId());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		boolean checkUser = checkExistingUser(user.getUserName());
		if (checkUser != true) {
			userRepo.save(userEntity);
			message = "User Registered";
		} else {
			message = "User Already Exists";
		}

		return message;
		// TODO Auto-generated method stub

	}

	private boolean checkExistingUser(String userName) {
		UserEntity user = userRepo.findByUserName(userName);
		return  user != null ;
	}

}
