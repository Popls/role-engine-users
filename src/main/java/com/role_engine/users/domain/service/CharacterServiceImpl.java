package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.Personaje;
import com.role_engine.users.infrastructure.repository.PersonajeSpringRepository;

public class CharacterServiceImpl implements CharacterService {

    PersonajeSpringRepository personajeSpringRepository;

    public CharacterServiceImpl(PersonajeSpringRepository personajeSpringRepository){
        this.personajeSpringRepository = personajeSpringRepository;
    }

    @Override
    public Personaje getCharacter(Integer id) {
        return personajeSpringRepository.findById(id).get();
    }

    @Override
    public void saveCharacter(Personaje personaje) {
        personajeSpringRepository.save(personaje);
    }

    @Override
    public void deleteCharacter(Integer id) {
        personajeSpringRepository.deleteById(id);
    }

    
}
