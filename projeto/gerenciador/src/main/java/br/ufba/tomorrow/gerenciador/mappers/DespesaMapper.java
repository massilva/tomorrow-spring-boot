package br.ufba.tomorrow.gerenciador.mappers;

import br.ufba.tomorrow.gerenciador.dtos.*;
import br.ufba.tomorrow.gerenciador.models.*;

public class DespesaMapper {

    public static DespesaDTO toDTO(Despesa entity) {
        return new DespesaDTO(
            entity.getDescricao(),
            entity.getValor(),
            entity.getData(),
            entity.getId()
        );
    }
}

