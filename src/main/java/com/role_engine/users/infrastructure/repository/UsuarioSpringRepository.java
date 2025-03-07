package com.role_engine.users.infrastructure.repository;

import com.role_engine.users.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioSpringRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findById(Integer id);
}
