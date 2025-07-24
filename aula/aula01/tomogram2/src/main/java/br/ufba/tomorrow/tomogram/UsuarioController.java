package br.ufba.tomorrow.tomogram;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Operações com usuários")
public class UsuarioController {
    private GerenciadorDeUsuario gerenciador;

    public UsuarioController(GerenciadorDeUsuario gerenciador) {
        this.gerenciador = gerenciador;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return gerenciador.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") int id) {
        if (id < 0 || id >= gerenciador.getSize()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciador.getUsuario(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        gerenciador.createUsuario(usuario);
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int id,
            @RequestBody Usuario usuario) {
        if (id < 0 || id >= gerenciador.getSize()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gerenciador.updateUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") int id) {
        if (id < 0 || id >= gerenciador.getSize()) {
            return ResponseEntity.notFound().build();
        }
        gerenciador.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
