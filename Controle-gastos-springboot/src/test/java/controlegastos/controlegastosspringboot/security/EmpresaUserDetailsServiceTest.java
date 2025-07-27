package controlegastos.controlegastosspringboot.security;


import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpresaUserDetailsServiceTest {

private final EmpresaRepository empresaRepository = mock(EmpresaRepository.class);
private final EmpresaUserDetailsService service = new EmpresaUserDetailsService(empresaRepository);

@Test
void loadUserByUsername_EmpresaExists() {
    Empresa empresa = new Empresa();
    empresa.setEmail("teste@empresa.com");
    empresa.setSenha("senha");

    when(empresaRepository.findByEmail("teste@empresa.com")).thenReturn(Optional.of(empresa));

    var userDetails = service.loadUserByUsername("teste@empresa.com");

    assertEquals("teste@empresa.com", userDetails.getUsername());
    assertEquals("senha", userDetails.getPassword());
}

@Test
void loadUserByUsername_EmpresaNaoEncontrada() {
    when(empresaRepository.findByEmail("naoexiste@empresa.com")).thenReturn(Optional.empty());

    assertThrows(UsernameNotFoundException.class, () -> {
        service.loadUserByUsername("naoexiste@empresa.com");
    });
}
}