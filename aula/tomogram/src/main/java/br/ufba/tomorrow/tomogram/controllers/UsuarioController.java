package br.ufba.tomorrow.tomogram.controllers;

import br.ufba.tomorrow.tomogram.dtos.AtualizaUsuarioDTO;
import br.ufba.tomorrow.tomogram.dtos.CriaUsuarioDTO;
import br.ufba.tomorrow.tomogram.entities.Usuario;
import br.ufba.tomorrow.tomogram.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Operações com usuários")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id) {
        var optional =  usuarioService.findById(id);
        return ResponseEntity.of(optional);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createUsuario(@RequestBody @Valid CriaUsuarioDTO usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.noContent().build();
    }

    // put
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable("id") Long id,
            @RequestBody AtualizaUsuarioDTO usuario) {
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
