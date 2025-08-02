package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AtualizaEmpresaDTO(
    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(max = 100, message = "O nome fantasia deve ter no máximo 100 caracteres")
    String nomeFantasia,

    @NotBlank(message = "A razão social é obrigatória")
    @Size(max = 100, message = "A razão social deve ter no máximo 100 caracteres")
    String razaoSocial,

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos numéricos")
    String cnpj
) {}
