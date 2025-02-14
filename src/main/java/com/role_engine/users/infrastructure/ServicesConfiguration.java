package com.role_engine.users.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.role_engine.users.domain.service.UserService;
import com.role_engine.users.domain.service.UserServiceImpl;

@Configuration
public class ServicesConfiguration {

    @Bean
    UserService orderService() {
        return new UserServiceImpl();
    }
}