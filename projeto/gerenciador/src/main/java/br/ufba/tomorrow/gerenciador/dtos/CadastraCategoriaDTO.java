package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CadastraCategoriaDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;
}