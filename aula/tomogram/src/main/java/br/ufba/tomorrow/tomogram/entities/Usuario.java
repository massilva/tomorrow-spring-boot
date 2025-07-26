package br.ufba.tomorrow.tomogram.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Usuario {
    @Email
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String nome;

    public Usuario(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
