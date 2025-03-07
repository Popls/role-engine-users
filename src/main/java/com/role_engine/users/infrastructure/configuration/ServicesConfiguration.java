package com.role_engine.users.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.role_engine.users.domain.service.CharacterService;
import com.role_engine.users.domain.service.CharacterServiceImpl;
import com.role_engine.users.domain.service.UserService;
import com.role_engine.users.domain.service.UserServiceImpl;
import com.role_engine.users.infrastructure.repository.PersonajeSpringRepository;
import com.role_engine.users.infrastructure.repository.UsuarioSpringRepository;

@Configuration
public class ServicesConfiguration {

    @Bean
    UserService userService(UsuarioSpringRepository usuarioSpringRepository) {
        return new UserServiceImpl(usuarioSpringRepository);
    }

    @Bean
    CharacterService characterService(PersonajeSpringRepository personajeSpringRepository) {
        return new CharacterServiceImpl(personajeSpringRepository);
    }
}