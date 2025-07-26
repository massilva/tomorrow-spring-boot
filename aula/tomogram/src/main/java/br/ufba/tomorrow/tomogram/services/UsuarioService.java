package br.ufba.tomorrow.tomogram.services;

import br.ufba.tomorrow.tomogram.dtos.AtualizaUsuarioDTO;
import br.ufba.tomorrow.tomogram.dtos.CriaUsuarioDTO;
import br.ufba.tomorrow.tomogram.entities.Usuario;
import br.ufba.tomorrow.tomogram.exceptions.NotFoundException;
import br.ufba.tomorrow.tomogram.mappers.UsuarioMapper;
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
        return usuarioRepository.save(
            UsuarioMapper.fromCriaDTO(usuario)
        );
    }

    public Usuario update(Long id, AtualizaUsuarioDTO atualiza) {
        var optUsuario = this.findById(id);
        if (optUsuario.isEmpty()) {
            throw new NotFoundException();
        }
        var usuario = optUsuario.get();
        if (atualiza.getEmail() != null) {
            usuario.setEmail(atualiza.getEmail());
        }
        if (atualiza.getNome() != null) {
            usuario.setNome(atualiza.getNome());
        }
        return usuarioRepository.save(usuario);
    }

    public void delete(Long pk) {
        usuarioRepository.deleteById(pk);
    }
}
