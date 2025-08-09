package br.ufba.tomorrow.gerenciador.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpresaSaida {
    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String email;
}
