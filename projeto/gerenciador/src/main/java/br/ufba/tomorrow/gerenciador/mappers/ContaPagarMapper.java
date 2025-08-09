package br.ufba.tomorrow.gerenciador.mappers;

import br.ufba.tomorrow.gerenciador.dtos.*;
import br.ufba.tomorrow.gerenciador.models.*;

public class ContaPagarMapper {

    public static ContaPagarDTO toDTO(ContaPagar entity) {
        return new ContaPagarDTO(
            entity.getFornecedor(),
            entity.getValor(),
            entity.getVencimento(),
            entity.isPago()
        );
    }
}

