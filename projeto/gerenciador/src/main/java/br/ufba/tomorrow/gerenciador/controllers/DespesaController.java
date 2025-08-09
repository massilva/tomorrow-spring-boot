package br.ufba.tomorrow.gerenciador.controllers;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.gerenciador.dtos.DespesaDTO;
import br.ufba.tomorrow.gerenciador.security.EmpresaUserDetails;
import br.ufba.tomorrow.gerenciador.services.DespesaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/empresa/despesa")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public DespesaDTO criar(@AuthenticationPrincipal EmpresaUserDetails empresa, @Valid @RequestBody DespesaDTO dto) {
        return despesaService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<DespesaDTO> listar(@AuthenticationPrincipal EmpresaUserDetails empresa) {
        return despesaService.listarPorEmpresa(empresa.getId());
    }
}