package br.ufba.tomorrow.tomogram.dtos;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class AtualizaUsuarioDTO {
    @Email
    private String email;
    private String nome;
}
