package br.ufba.tomorrow.gerenciador.mapper;

import br.ufba.tomorrow.gerenciador.dto.*;
import br.ufba.tomorrow.gerenciador.model.*;

public class RecebimentoMapper {

    public static Recebimento toEntity(RecebimentoDTO dto, Empresa empresa) {
        Recebimento recebimento = new Recebimento();
        recebimento.setCliente(dto.cliente());
        recebimento.setValor(dto.valor());
        recebimento.setVencimento(dto.vencimento());
        recebimento.setRecebido(dto.recebido());
        recebimento.setEmpresa(empresa);
        return recebimento;
    }

    public static RecebimentoResponseDTO toDTO(Recebimento entity) {
        return new RecebimentoResponseDTO(
            entity.getId(),
            entity.getCliente(),
            entity.getValor(),
            entity.getVencimento(),
            entity.isRecebido()
        );
    }
}

