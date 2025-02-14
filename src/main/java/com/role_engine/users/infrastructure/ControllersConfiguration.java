package com.role_engine.users.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.role_engine.users.application.UserController;
import com.role_engine.users.domain.service.UserService;

@Configuration
public class ControllersConfiguration {

    @Bean
    UserController userController(UserService userService){
        return new UserController(userService);
    }
}