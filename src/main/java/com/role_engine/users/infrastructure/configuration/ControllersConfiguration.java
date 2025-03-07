package com.role_engine.users.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.role_engine.users.application.controller.CharacterController;
import com.role_engine.users.application.controller.UserController;
import com.role_engine.users.domain.service.CharacterService;
import com.role_engine.users.domain.service.UserService;

@Configuration
public class ControllersConfiguration {

    @Bean
    UserController userController(UserService userService){
        return new UserController(userService);
    }

    @Bean
    CharacterController charaController(CharacterService characterService){
        return new CharacterController(characterService);
    }
}
