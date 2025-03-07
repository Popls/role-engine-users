package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.Usuario;

public interface UserService {

    Usuario getUser(Integer id);

    void saveUser(Usuario user);

    void deleteUser(Integer id);
    
}
