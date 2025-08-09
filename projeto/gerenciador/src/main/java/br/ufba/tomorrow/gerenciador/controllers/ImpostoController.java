package br.ufba.tomorrow.gerenciador.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import br.ufba.tomorrow.gerenciador.dtos.ImpostoDTO;
import br.ufba.tomorrow.gerenciador.dtos.ImpostoResponseDTO;
import br.ufba.tomorrow.gerenciador.models.Imposto;
import br.ufba.tomorrow.gerenciador.security.EmpresaUserDetails;
import br.ufba.tomorrow.gerenciador.services.ImpostoService;


@RestController
@RequestMapping("/api/impostos")
@RequiredArgsConstructor
public class ImpostoController {

    private final ImpostoService impostoService;

    @PostMapping
    public Imposto criar(@AuthenticationPrincipal EmpresaUserDetails empresa, @Valid @RequestBody ImpostoDTO dto) {
        return impostoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<ImpostoResponseDTO> listar(@AuthenticationPrincipal EmpresaUserDetails empresa) {
        return impostoService.listar(empresa.getId());
    }
}
