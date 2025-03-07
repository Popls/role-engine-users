package com.role_engine.users.domain.service;

import org.springframework.stereotype.Component;

import com.role_engine.users.domain.model.Usuario;
import com.role_engine.users.infrastructure.repository.UsuarioSpringRepository;

@Component
public class UserServiceImpl implements UserService{
    
    UsuarioSpringRepository usuarioSpringRepository;

    public UserServiceImpl(UsuarioSpringRepository usuarioSpringRepository){
        this.usuarioSpringRepository = usuarioSpringRepository;
    }

    @Override
    public Usuario getUser(Integer id) {
        Usuario result = usuarioSpringRepository.findById(id).get();
        result.setContrasenaHash(null);
        return result;
    }

    @Override
    public void saveUser(Usuario user) {
        usuarioSpringRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        usuarioSpringRepository.deleteById(id);
    }
    
}
