package controlegastos.controlegastosspringboot.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "empresa")
    private List<ContaPagar> contasPagar;

    @OneToMany(mappedBy = "empresa")
    private List<Recebimento> recebimentos;

    @OneToMany(mappedBy = "empresa")
    private List<Imposto> impostos;
}