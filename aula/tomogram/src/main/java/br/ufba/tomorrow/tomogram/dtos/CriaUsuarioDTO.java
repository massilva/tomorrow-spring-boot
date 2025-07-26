package br.ufba.tomorrow.tomogram.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CriaUsuarioDTO {
    @Email
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String nome;
}
