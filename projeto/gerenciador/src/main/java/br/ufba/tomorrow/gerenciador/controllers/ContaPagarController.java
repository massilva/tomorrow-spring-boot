package br.ufba.tomorrow.gerenciador.controllers;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.gerenciador.dtos.ContaPagarDTO;
import br.ufba.tomorrow.gerenciador.security.EmpresaUserDetails;
import br.ufba.tomorrow.gerenciador.services.ContaPagarService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/empresa/conta-pagar")
@RequiredArgsConstructor
public class ContaPagarController {

    private final ContaPagarService contaPagarService;

    @PostMapping
    public ContaPagarDTO criar(@AuthenticationPrincipal EmpresaUserDetails empresa, @Valid @RequestBody ContaPagarDTO dto) {
        return contaPagarService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<ContaPagarDTO> listar(@AuthenticationPrincipal EmpresaUserDetails empresa) {
        return contaPagarService.listar(empresa.getId());
    }
}