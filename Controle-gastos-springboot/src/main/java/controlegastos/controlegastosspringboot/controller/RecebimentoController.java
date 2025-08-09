package controlegastos.controlegastosspringboot.controller;

import controlegastos.controlegastosspringboot.dto.RecebimentoDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.model.Recebimento;
import controlegastos.controlegastosspringboot.service.RecebimentoService;
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
    public Recebimento criar(@AuthenticationPrincipal Empresa empresa,
                             @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<Recebimento> listar(@AuthenticationPrincipal Empresa empresa) {
        return recebimentoService.listar(empresa.getId());
    }

    @GetMapping("/{id}")
    public Recebimento buscarPorId(@AuthenticationPrincipal Empresa empresa,
                                   @PathVariable Long id) {
        return recebimentoService.buscarPorId(empresa.getId(), id);
    }

    @PutMapping("/{id}")
    public Recebimento atualizar(@AuthenticationPrincipal Empresa empresa,
                                 @PathVariable Long id,
                                 @Valid @RequestBody RecebimentoDTO dto) {
        return recebimentoService.atualizar(empresa.getId(), id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@AuthenticationPrincipal Empresa empresa,
                        @PathVariable Long id) {
        recebimentoService.deletar(empresa.getId(), id);
    }
}
