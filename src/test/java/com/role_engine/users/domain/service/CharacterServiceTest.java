package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.Personaje;
import com.role_engine.users.infrastructure.repository.PersonajeSpringRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharacterServiceImplTest {

    @Mock
    private PersonajeSpringRepository personajeSpringRepository;

    @InjectMocks
    private CharacterServiceImpl characterService;

    private Personaje personaje;

    @BeforeEach
    void setUp() {
        personaje = new Personaje();
        personaje.setId(1);
        personaje.setNombre("TestCharacter");
    }

    @Test
    void testGetCharacter() {
        when(personajeSpringRepository.findById(1)).thenReturn(Optional.of(personaje));

        Personaje result = characterService.getCharacter(1);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getNombre()).isEqualTo("TestCharacter");
        verify(personajeSpringRepository, times(1)).findById(1);
    }

    @Test
    void testSaveCharacter() {
        characterService.saveCharacter(personaje);

        verify(personajeSpringRepository, times(1)).save(personaje);
    }

    @Test
    void testDeleteCharacter() {
        characterService.deleteCharacter(1);

        verify(personajeSpringRepository, times(1)).deleteById(1);
    }
} 

