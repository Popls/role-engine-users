package com.role_engine.users.infrastructure.repository;

import com.role_engine.users.domain.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonajeSpringRepository extends JpaRepository<Personaje, Integer> {

    Optional<Personaje> findById(Integer id);
}
