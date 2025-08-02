package br.ufba.tomorrow.gerenciador.security;

import br.ufba.tomorrow.gerenciador.model.Empresa;
import lombok.Getter;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class EmpresaUserDetails implements UserDetails {

    private final Empresa empresa;

    public EmpresaUserDetails(Empresa empresa) {
        this.empresa = empresa;
    }
