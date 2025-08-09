package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraFornecedorDTO;
import br.ufba.tomorrow.gerenciador.models.Fornecedor;

public interface FornecedorMapper {

    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);

    @Mapping(target = "id", ignore = true)
    Fornecedor cadastraFornecedorDTOParaFornecedor(CadastraFornecedorDTO dto);
}