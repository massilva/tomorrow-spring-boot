package br.ufba.tomorrow.gerenciador.controller;

import br.ufba.tomorrow.gerenciador.dto.*;
import br.ufba.tomorrow.gerenciador.service.RecebimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas/{empresaId}/recebimentos")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoService recebimentoService;

    @PostMapping
    public RecebimentoResponseDTO criar(@PathVariable Long empresaId,
                                        @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresaId, dto);
    }

    @GetMapping
    public List<RecebimentoResponseDTO> listar(@PathVariable Long empresaId) {
        return recebimentoService.listar(empresaId);
    }
}
