package controlegastos.controlegastosspringboot.security;


import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.repository.EmpresaRepository;
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

