package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.Personaje;

public interface CharacterService {

    Personaje getCharacter(Integer id);

    void saveCharacter(Personaje personaje);

    void deleteCharacter(Integer id);
    
}
