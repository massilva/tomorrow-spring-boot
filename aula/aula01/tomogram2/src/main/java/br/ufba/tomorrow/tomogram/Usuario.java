package br.ufba.tomorrow.tomogram;

public class Usuario {
    private String email;
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
