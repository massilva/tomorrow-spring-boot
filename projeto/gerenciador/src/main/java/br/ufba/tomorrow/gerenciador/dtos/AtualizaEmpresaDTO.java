package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizaEmpresaDTO(
    @NotBlank
    String nomeFantasia,

    @NotBlank(message = "Razão social é obrigatória")
    String razaoSocial,

    @NotBlank(message = "CNPJ é obrigatório")
    String cnpj,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    String senha
) {}
