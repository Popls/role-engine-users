package com.role_engine.users.application.controller;

import com.role_engine.users.domain.model.Usuario;
import com.role_engine.users.domain.service.UserService;
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
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private Usuario user;

    @BeforeEach
    void setUp() {
        user = Usuario.builder()
                .id(1)
                .nombre("John Doe")
                .correo("john.doe@example.com")
                .contrasenaHash("hashed_password_here")
                .build();
    }

    @Test
    void getUser_ShouldReturnUser() {
        when(userService.getUser(1)).thenReturn(user);

        ResponseEntity<Usuario> response = userController.getUser(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody()).isEqualTo(user);
    }

    @Test
    void createUser_ShouldSaveUser() {
        doNothing().when(userService).saveUser(user);

        ResponseEntity<Usuario> response = userController.createUser(user);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertThat(response.getBody()).isEqualTo(user);
        verify(userService, times(1)).saveUser(user);
    }

    @Test
    void deleteUser_ShouldReturnOk() {
        doNothing().when(userService).deleteUser(1);

        ResponseEntity<Void> response = userController.deleteUser(1);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(userService, times(1)).deleteUser(1);
    }
}
