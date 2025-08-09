package br.ufba.tomorrow.gerenciador.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import br.ufba.tomorrow.gerenciador.dtos.RecebimentoDTO;
import br.ufba.tomorrow.gerenciador.dtos.RecebimentoResponseDTO;
import br.ufba.tomorrow.gerenciador.security.EmpresaUserDetails;
import br.ufba.tomorrow.gerenciador.services.RecebimentoService;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/empresa/recebimento")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoService recebimentoService;

    @PostMapping
    public RecebimentoResponseDTO criar(@AuthenticationPrincipal EmpresaUserDetails empresa, @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<RecebimentoResponseDTO> listar(@AuthenticationPrincipal EmpresaUserDetails empresa) {
        return recebimentoService.listar(empresa.getId());
    }

    @GetMapping("/{id}")
    public RecebimentoResponseDTO buscarPorId(@AuthenticationPrincipal EmpresaUserDetails empresa,
                                   @PathVariable Long id) {
        return recebimentoService.buscaPorId(empresa.getId(), id);
    }

    @PutMapping("/{id}")
    public RecebimentoResponseDTO atualizar(@AuthenticationPrincipal EmpresaUserDetails empresa,
                                 @PathVariable Long id,
                                 @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.atualizar(empresa.getId(), id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@AuthenticationPrincipal EmpresaUserDetails empresa,
                        @PathVariable Long id) {
        recebimentoService.deletar(empresa.getId(), id);
    }
}
