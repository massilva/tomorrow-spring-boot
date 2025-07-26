package br.ufba.tomorrow.tomogram.controllers;

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
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") int id) {
        var optional =  usuarioService.findById(id);
        return ResponseEntity.of(optional);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createUsuario(@RequestBody @Valid Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.noContent().build();
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int id,
            @RequestBody Usuario usuario) {
        var optional = usuarioService.update(id, usuario);
        return ResponseEntity.of(optional);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") int id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
