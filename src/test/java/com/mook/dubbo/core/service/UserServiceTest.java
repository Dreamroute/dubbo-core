package com.mook.dubbo.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mook.dubbo.core.domain.User;

public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;
    
    @Test
    public void insertTest() throws Exception {
        User user = new User();
        user.setId(100);
        userService.insert(user);
        Thread.sleep(1000 * 1000);
    }
}
