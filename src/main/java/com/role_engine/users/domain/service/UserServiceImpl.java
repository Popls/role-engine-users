package com.role_engine.users.domain.service;

import org.springframework.stereotype.Component;

import com.role_engine.users.domain.model.User;

@Component
public class UserServiceImpl implements UserService{

    @Override
    public User getUser(String id) {
        // TODO Dummy getUser
        return User.builder().build();
    }

    @Override
    public void saveUser(User user) {
        // TODO
    }

    @Override
    public void deleteUser(String id) {
        // TODO
    }

    @Override
    public User modifyUser(User user) {
        // TODO Dummy modifyUser
        return User.builder().build();
    }
    
}
