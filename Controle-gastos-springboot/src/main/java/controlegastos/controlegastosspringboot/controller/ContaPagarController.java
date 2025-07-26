package controlegastos.controlegastosspringboot.controller;

import controlegastos.controlegastosspringboot.dto.EmpresaDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contas-pagar")
@RequiredArgsConstructor
public class ContaPagarController {

    private final ContaPagarService contaPagarService;

    @PostMapping
    public ContaPagar criar(@AuthenticationPrincipal Empresa empresa, @Valid @RequestBody ContaPagarDTO dto) {
        return contaPagarService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<ContaPagar> listar(@AuthenticationPrincipal Empresa empresa) {
        return contaPagarService.listar(empresa.getId());
    }
}