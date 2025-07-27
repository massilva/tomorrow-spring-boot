package controlegastos.controlegastosspringboot.controller;

import controlegastos.controlegastosspringboot.dto.EmpresaDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.service.EmpresaService;
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