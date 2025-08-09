package br.ufba.tomorrow.gerenciador.security;

import br.ufba.tomorrow.gerenciador.models.Empresa;

import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class EmpresaUserDetails implements UserDetails {

    private Empresa empresa;
    
    public EmpresaUserDetails(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_EMPRESA");
    }

    @Override
    public String getPassword() {
        return empresa.getUsuario().getSenha();
    }

    @Override
    public String getUsername() {
        return empresa.getUsuario().getEmail();
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public Long getId() {
        return this.empresa.getId();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}    
    
