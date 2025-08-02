package br.ufba.tomorrow.gerenciador.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import br.ufba.tomorrow.gerenciador.dtos.RecebimentoDTO;
import br.ufba.tomorrow.gerenciador.dtos.RecebimentoResponseDTO;
import br.ufba.tomorrow.gerenciador.services.RecebimentoService;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/empresa/{empresaId}/recebimento")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoService recebimentoService;

    @PostMapping
    public RecebimentoResponseDTO criar(@PathVariable("empresaId") Long empresaId,
                                        @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresaId, dto);
    }

    @GetMapping
    public List<RecebimentoResponseDTO> listar(@PathVariable("empresaId") Long empresaId) {
        return recebimentoService.listar(empresaId);
    }
}
