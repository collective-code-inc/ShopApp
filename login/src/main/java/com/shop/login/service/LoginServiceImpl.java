package com.shop.login.service;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.shop.login.entity.User;
import com.shop.login.entity.repo.UserEntity;
import com.shop.login.entity.repo.UserRepo;
import com.shop.login.util.Constants;
import com.shop.login.util.MessageUtil;

@Service
public class LoginServiceImpl implements LoginInterface {

	@Autowired
	UserRepo userRepo;

	@Override
	public String persistData(User user) {
		MessageUtil messageUtil = new MessageUtil();
		UserEntity userEntity = new UserEntity();

		userEntity.setId(user.getId());
		userEntity.setEmail(user.getEmail_Id());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());

		boolean checkUser = checkExistingUser(user.getUserName());
		if (checkUser != true) {
			userRepo.save(userEntity);
			messageUtil.setMessage(Constants.USER_REGISTERED);
		} else {
			messageUtil.setMessage(Constants.USER_EXISTS);
		}
		return messageUtil.getMessage();
		// TODO Auto-generated method stub

	}

	private boolean checkExistingUser(String userName) {
		UserEntity user = userRepo.findByUserName(userName);
		return user != null;
	}

}
