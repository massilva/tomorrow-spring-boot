package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraCategoriaDTO;
import br.ufba.tomorrow.gerenciador.models.Categoria;

public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    @Mapping(target = "id", ignore = true)
    Categoria cadastraCategoriaDTOParaCategoria(CadastraCategoriaDTO dto);
}