package br.ufba.tomorrow.gerenciador.mappers;

import br.ufba.tomorrow.gerenciador.dtos.*;
import br.ufba.tomorrow.gerenciador.models.*;

public class ImpostoMapper {

    public static ImpostoResponseDTO toDTO(Imposto entity) {
        return new ImpostoResponseDTO(
            entity.getId(),
            entity.getTipo(),
            entity.getValor(),
            entity.getDataCompetencia()
        );
    }
}

