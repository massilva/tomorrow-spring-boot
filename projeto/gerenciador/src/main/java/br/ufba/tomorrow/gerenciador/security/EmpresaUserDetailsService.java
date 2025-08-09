
package br.ufba.tomorrow.gerenciador.security;


import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.models.Usuario;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;
import br.ufba.tomorrow.gerenciador.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class EmpresaUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada"));
        return new EmpresaUserDetails(usuario.getEmpresa());
    }
}
