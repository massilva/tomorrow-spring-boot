package br.ufba.tomorrow.gerenciador;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.ufba.tomorrow.gerenciador.controllers.EmpresaController;
import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;
import br.ufba.tomorrow.gerenciador.services.EmpresaService;

@WebMvcTest(EmpresaController.class)
@Import({ EmpresaService.class, TestSecurityConfig.class })
public class EmpresaTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @MockitoBean
    private EmpresaRepository empresaRepository;

    private static final String BASE_URL = "/api/v1/empresa";

    private String getUrl(String url) {
        return BASE_URL + url;
    }

    @Test
    void shouldReturnCountAsOne() throws Exception {
        when(empresaRepository.count()).thenReturn(0L);
        mockMvc.perform(get(getUrl("/count")))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void shouldRegisterEmpresa() throws Exception {
        CadastraEmpresaDTO dto = new CadastraEmpresaDTO(
                "Tech Tomorrow",
                "Tech Tomorrow LTDA",
                "12345678000199",
                "contato@tomorrow.com",
                "senha123");

        Empresa empresaSalva = new Empresa(1L, dto.getNomeFantasia(), dto.getRazaoSocial(),
                dto.getCnpj(), dto.getEmail(), passwordEncoder.encode(dto.getSenha()));

        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresaSalva);
        mockMvc.perform(post(getUrl("/register"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.razaoSocial").value("Tech Tomorrow LTDA"))
                .andExpect(jsonPath("$.cnpj").value("12345678000199"));
    }
}