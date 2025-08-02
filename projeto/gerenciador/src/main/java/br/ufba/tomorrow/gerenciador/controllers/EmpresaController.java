package br.ufba.tomorrow.gerenciador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.services.EmpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("${api.prefix}/empresa")
@Tag(name = "Empresa", description = "Operações com empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/register")
    public Empresa cadastrar(@Validated @RequestBody CadastraEmpresaDTO cadastraEmpresaDTO) {
        return empresaService.salvar(cadastraEmpresaDTO);
    }

    @GetMapping
    public List<Empresa> getAllUsuarios() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getUsuario(@PathVariable("id") Long id) {
        var optional =  empresaService.findById(id);
        return ResponseEntity.of(optional);
    }
}