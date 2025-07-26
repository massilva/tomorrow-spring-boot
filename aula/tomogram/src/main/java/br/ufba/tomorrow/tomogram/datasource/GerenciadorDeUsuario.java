package br.ufba.tomorrow.tomogram.datasource;

import br.ufba.tomorrow.tomogram.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GerenciadorDeUsuario {
    private List<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario("joao@example.com", "João"),
            new Usuario("maria@example.com", "Maria")
    ));

    public int getSize() {
        return usuarios.size();
    }
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }
    public Usuario getUsuario(int id) {
        return usuarios.get(id);
    }
    public void createUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public Usuario updateUsuario(int id, Usuario usuario) {
        usuarios.set(id, usuario);
        return usuario;
    }
    public void deleteUsuario(int id) {
        usuarios.remove(id);
    }
}
