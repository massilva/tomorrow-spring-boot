package br.ufba.tomorrow.gerenciador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.models.Usuario;
import br.ufba.tomorrow.gerenciador.services.UsuarioService;

import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada"));

        return new User(
            usuario.getEmail(),
            usuario.getSenha(),
            List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
