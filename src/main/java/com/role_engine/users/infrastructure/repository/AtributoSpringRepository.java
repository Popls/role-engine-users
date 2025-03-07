package com.role_engine.users.infrastructure.repository;

import com.role_engine.users.domain.model.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtributoSpringRepository extends JpaRepository<Atributo, Integer> {

    Optional<Atributo> findById(Integer id);
}

