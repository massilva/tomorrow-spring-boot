package br.ufba.tomorrow.tomogram.services;

import br.ufba.tomorrow.tomogram.dtos.CriaUsuarioDTO;
import br.ufba.tomorrow.tomogram.entities.Usuario;
import br.ufba.tomorrow.tomogram.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long pk) {
        return usuarioRepository.findById(pk);
    }

    public Usuario save(CriaUsuarioDTO usuario) {
        var user = new Usuario();
        user.setEmail(usuario.getEmail());
        user.setNome(usuario.getNome());
        return usuarioRepository.save(user);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long pk) {
        usuarioRepository.deleteById(pk);
    }
}
