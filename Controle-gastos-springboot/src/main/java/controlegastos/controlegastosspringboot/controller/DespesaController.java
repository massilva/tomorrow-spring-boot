package controlegastos.controlegastosspringboot.controller;

import controlegastos.controlegastosspringboot.dto.EmpresaDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public Despesa criar(@AuthenticationPrincipal Empresa empresa, @Valid @RequestBody DespesaDTO dto) {
        return despesaService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<Despesa> listar(@AuthenticationPrincipal Empresa empresa) {
        return despesaService.listarPorEmpresa(empresa.getId());
    }
}