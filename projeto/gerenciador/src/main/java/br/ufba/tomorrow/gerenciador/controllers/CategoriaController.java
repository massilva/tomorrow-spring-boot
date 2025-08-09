package br.ufba.tomorrow.gerenciador.controllers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraCategoriaDTO;
import br.ufba.tomorrow.gerenciador.mappers.CategoriaMapper;
import br.ufba.tomorrow.gerenciador.models.Categoria;
import br.ufba.tomorrow.gerenciador.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @GetMapping
    public List<Categoria> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Categoria salvar(@Valid @RequestBody CadastraCategoriaDTO dto) {
        Categoria categoria = CategoriaMapper.INSTANCE.cadastraCategoriaDTOParaCategoria(dto);
        return service.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}