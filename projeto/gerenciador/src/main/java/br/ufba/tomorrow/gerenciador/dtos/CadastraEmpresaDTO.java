package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CadastraEmpresaDTO {
        private String nomeFantasia;

        @NotBlank(message = "Razão social é obrigatória")
        private String razaoSocial;

        @NotBlank(message = "CNPJ é obrigatório")
        private String cnpj;

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        private String email;

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        private String senha;
}
