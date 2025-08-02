package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraContasAPagarDTO;
import br.ufba.tomorrow.gerenciador.models.ContasAPagar;

public interface ContasAPagarMapper {

    ContasAPagarMapper INSTANCE = Mappers.getMapper(ContasAPagarMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "empresa.id", source = "empresaId")
    @Mapping(target = "fornecedor.id", source = "fornecedorId")
    @Mapping(target = "categoria.id", source = "categoriaId")
    ContasAPagar cadastraContasAPagarDTOParaContasAPagar(CadastraContasAPagarDTO dto);
}