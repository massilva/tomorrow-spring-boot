package com.exemplo.ufba.tomorrow.gerenciador.controller;

import com.exemplo.ufba.tomorrow.gerenciador.dto.*;
import com.exemplo.ufba.tomorrow.gerenciador.model.Empresa;
import com.exemplo.ufba.tomorrow.gerenciador.service.RecebimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recebimentos")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoService recebimentoService;

    @PostMapping
    public RecebimentoResponseDTO criar(@AuthenticationPrincipal Empresa empresa,
                                        @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<RecebimentoResponseDTO> listar(@AuthenticationPrincipal Empresa empresa) {
        return recebimentoService.listar(empresa.getId());
    }
}
