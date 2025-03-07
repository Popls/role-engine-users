package com.role_engine.users.domain.service;

import com.role_engine.users.domain.model.Usuario;
import com.role_engine.users.infrastructure.repository.UsuarioSpringRepository;
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
class UserServiceImplTest {

    @Mock
    private UsuarioSpringRepository usuarioSpringRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("TestUser");
        usuario.setContrasenaHash("hashedPassword");
    }

    @Test
    void testGetUser() {
        when(usuarioSpringRepository.findById(1)).thenReturn(Optional.of(usuario));

        Usuario result = userService.getUser(1);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getNombre()).isEqualTo("TestUser");
        assertThat(result.getContrasenaHash()).isNull();
        verify(usuarioSpringRepository, times(1)).findById(1);
    }

    @Test
    void testSaveUser() {
        userService.saveUser(usuario);

        verify(usuarioSpringRepository, times(1)).save(usuario);
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1);

        verify(usuarioSpringRepository, times(1)).deleteById(1);
    }
} 
