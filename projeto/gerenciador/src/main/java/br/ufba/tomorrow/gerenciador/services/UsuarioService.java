package br.ufba.tomorrow.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.CadastraUsuarioDTO;
import br.ufba.tomorrow.gerenciador.mappers.UsuarioMapper;
import br.ufba.tomorrow.gerenciador.models.Usuario;
import br.ufba.tomorrow.gerenciador.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(CadastraUsuarioDTO dto) {
        Usuario usuario = UsuarioMapper.INSTANCE.cadastraUsuarioDTOParaUsuario(dto);
        return usuarioRepository.save(usuario);
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
}
