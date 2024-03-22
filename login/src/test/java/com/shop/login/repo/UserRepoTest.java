package com.shop.login.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.shop.login.config.TestAppConfig;
import com.shop.login.modal.UserEntity;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@Transactional
public class UserRepoTest {

    @Autowired
    private UserRepo repository;
    private UserEntity user;

    @Before
    public void init() {
        prepareData();
    }

    @Test
    public void findByUsername() {
        UserEntity user = repository.findByUserName("UserName");
        Assert.assertEquals(this.user, user);
    }

    private void prepareData() {
        user = new UserEntity();
        user.setEmail("test@arezzosky.com");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setUserName("UserName");
        user.setPassword("Password");
        repository.save(user);
    }
}

