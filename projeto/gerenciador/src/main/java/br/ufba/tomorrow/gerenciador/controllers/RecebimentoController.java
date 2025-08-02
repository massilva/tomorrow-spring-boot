package br.ufba.tomorrow.gerenciador.controllers;

import com.exemplo.br.ufba.tomorrow.gerenciador.dto.EmpresaDTO;
import com.exemplo.br.ufba.tomorrow.gerenciador.model.Empresa;
import com.exemplo.br.ufba.tomorrow.gerenciador.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/recebimentos")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoService recebimentoService;

    @PostMapping
    public Recebimento criar(@AuthenticationPrincipal Empresa empresa, @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<Recebimento> listar(@AuthenticationPrincipal Empresa empresa) {
        return recebimentoService.listar(empresa.getId());
    }
}
