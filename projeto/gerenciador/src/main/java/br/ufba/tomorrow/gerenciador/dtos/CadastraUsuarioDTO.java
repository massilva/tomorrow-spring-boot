package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastraUsuarioDTO {
    @NotNull
    @Size(min = 3)
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Min(6)
    private String senha;
}
