package com.mook.dubbo.core.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.mook.dubbo.core.domain.User;
import com.mook.dubbo.core.service.UserService;

/**
 * Description: 用户Service
 *
 * @author wangdehai
 * @date 2017-02-26 01:33:06
 * @version 1.0 
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void insert(User user) {
        System.err.println("insert User.");
    }

    @Override
    public void update(User user) {
        System.err.println("update User.");
    }

    @Override
    public void delete(Integer id) {
        System.err.println("delete User by id, id is: " + id + ".");
    }

    @Override
    public List<User> selectAll() {
        System.err.println("select All user.");
        return null;
    }

}
