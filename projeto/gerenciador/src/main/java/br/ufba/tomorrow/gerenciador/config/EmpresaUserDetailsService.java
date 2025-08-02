
package br.ufba.tomorrow.gerenciador.config;


import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class EmpresaUserDetailsService implements UserDetailsService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Empresa empresa = empresaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada"));
        return new EmpresaUserDetails(empresa);
    }
}
