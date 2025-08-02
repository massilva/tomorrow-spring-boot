package br.ufba.tomorrow.gerenciador.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(max = 100, message = "O nome fantasia deve ter no máximo 100 caracteres")
    private String nomeFantasia;

    @NotBlank(message = "A razão social é obrigatória")
    @Size(max = 100, message = "A razão social deve ter no máximo 100 caracteres")
    private String razaoSocial;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos numéricos")
    @Column(unique = true, length = 14)
    private String cnpj;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
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