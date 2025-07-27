package controlegastos.controlegastosspringboot.controller;

import controlegastos.controlegastosspringboot.dto.EmpresaDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/impostos")
@RequiredArgsConstructor
public class ImpostoController {

    private final ImpostoService impostoService;

    @PostMapping
    public Imposto criar(@AuthenticationPrincipal Empresa empresa, @Valid @RequestBody ImpostoDTO dto) {
        return impostoService.salvar(empresa.getId(), dto);
    }

    @GetMapping
    public List<Imposto> listar(@AuthenticationPrincipal Empresa empresa) {
        return impostoService.listar(empresa.getId());
    }
}
