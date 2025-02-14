package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.User;

public interface UserService {

    User getUser(String id);

    void saveUser(User user);

    void deleteUser(String id);

    User modifyUser(User user);
    
}
