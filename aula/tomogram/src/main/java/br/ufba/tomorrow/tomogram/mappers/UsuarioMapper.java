package br.ufba.tomorrow.tomogram.mappers;

import br.ufba.tomorrow.tomogram.dtos.CriaUsuarioDTO;
import br.ufba.tomorrow.tomogram.entities.Usuario;

public class UsuarioMapper {
    public static Usuario fromCriaDTO(CriaUsuarioDTO cria) {
        return new Usuario(
            cria.getEmail(),
            cria.getNome()
        );
    }
}
