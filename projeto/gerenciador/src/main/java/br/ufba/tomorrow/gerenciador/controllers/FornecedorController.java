package br.ufba.tomorrow.gerenciador.controllers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraFornecedorDTO;
import br.ufba.tomorrow.gerenciador.mappers.FornecedorMapper;
import br.ufba.tomorrow.gerenciador.models.Fornecedor;
import br.ufba.tomorrow.gerenciador.services.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService service;

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Fornecedor salvar(@Valid @RequestBody CadastraFornecedorDTO dto) {
        Fornecedor fornecedor = FornecedorMapper.INSTANCE.cadastraFornecedorDTOParaFornecedor(dto);
        return service.salvar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}