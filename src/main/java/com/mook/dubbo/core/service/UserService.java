package com.mook.dubbo.core.service;

import java.util.List;

import com.mook.dubbo.core.domain.User;

public interface UserService {
    
    void insert(User user);
    
    void update(User user);
    
    void delete(Integer id);
    
    List<User> selectAll();
}
