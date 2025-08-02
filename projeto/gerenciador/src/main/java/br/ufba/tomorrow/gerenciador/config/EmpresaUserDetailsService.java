
package br.ufba.tomorrow.gerenciador.security;


import br.ufba.tomorrow.gerenciador.model.Empresa;
import br.ufba.tomorrow.gerenciador.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;

@RequiredArgsConstructor
public class EmpresaUserDetailsService implements UserDetailsService {

    private final EmpresaRepository empresaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Empresa empresa = empresaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada"));
        return new EmpresaUserDetails(empresa);
    }
}
