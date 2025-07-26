package br.ufba.tomorrow.tomogram.services;

import br.ufba.tomorrow.tomogram.GerenciadorDeUsuario;
import br.ufba.tomorrow.tomogram.entities.Usuario;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private final GerenciadorDeUsuario gerenciadorDeUsuario;

    public UsuarioService(GerenciadorDeUsuario gerenciadorDeUsuario) {
        this.gerenciadorDeUsuario = gerenciadorDeUsuario;
    }

    public List<Usuario> findAll() {
        return this.gerenciadorDeUsuario.getAllUsuarios();
    }

    public Optional<Usuario> findById(int index) {
        if (index < 0 || index >= gerenciadorDeUsuario.getSize()) {
            return Optional.empty();
        }
        return Optional.of(gerenciadorDeUsuario.getUsuario(index));
    }

    public void save(Usuario usuario) {
        gerenciadorDeUsuario.createUsuario(usuario);
    }

    public Optional<Usuario> update(int index, Usuario usuario) {
        if (index < 0 || index >= gerenciadorDeUsuario.getSize()) {
            return Optional.empty();
        }
        return Optional.of(gerenciadorDeUsuario.updateUsuario(index, usuario));
    }

    public void delete(int index) {
        if (index < 0 || index >= gerenciadorDeUsuario.getSize()) {
            return;
        }
        gerenciadorDeUsuario.deleteUsuario(index);
    }
}
