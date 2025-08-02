package br.ufba.tomorrow.gerenciador;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.ufba.tomorrow.gerenciador.controllers.EmpresaController;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;
import br.ufba.tomorrow.gerenciador.services.EmpresaService;

@WebMvcTest(EmpresaController.class)
@Import({EmpresaService.class, TestSecurityConfig.class})
public class EmpresaTests {     

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @MockitoBean
    private EmpresaRepository empresaRepository;

    @Test
    void shouldReturnCountAsOne() throws Exception {
        when(empresaRepository.count()).thenReturn(0L);
        mockMvc.perform(get("/api/v1/empresa/count"))  
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}