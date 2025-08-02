package br.ufba.tomorrow.gerenciador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String senha;

    public Empresa(Long id, String nomeFantasia, String razaoSocial, String cnpj, String email, String senha) {
        this(nomeFantasia, razaoSocial, cnpj, email, senha);
        this.id = id;
    }

    public Empresa(String nomeFantasia, String razaoSocial, String cnpj, String email, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}