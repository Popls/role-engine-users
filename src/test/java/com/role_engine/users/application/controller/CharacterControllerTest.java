package com.role_engine.users.application.controller;

import com.role_engine.users.domain.model.Personaje;
import com.role_engine.users.domain.service.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {

    @Mock
    private CharacterService characterService;

    @InjectMocks
    private CharacterController characterController;

    private Personaje character;

    @BeforeEach
    void setUp() {
        character = Personaje.builder()
                .id(1)
                .nombre("Hero")
                .build();
    }

    @Test
    void getCharacter_ShouldReturnCharacter() {
        when(characterService.getCharacter(1)).thenReturn(character);

        ResponseEntity<Personaje> response = characterController.getCharacter(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody()).isEqualTo(character);
    }

    @Test
    void createCharacter_ShouldSaveCharacter() {
        doNothing().when(characterService).saveCharacter(character);

        ResponseEntity<Personaje> response = characterController.createCharacter(character);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody()).isEqualTo(character);
        verify(characterService, times(1)).saveCharacter(character);
    }

    @Test
    void deleteUser_ShouldReturnOk() {
        doNothing().when(characterService).deleteCharacter(1);

        ResponseEntity<Void> response = characterController.deleteCharacter(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(characterService, times(1)).deleteCharacter(1);
    }
}
