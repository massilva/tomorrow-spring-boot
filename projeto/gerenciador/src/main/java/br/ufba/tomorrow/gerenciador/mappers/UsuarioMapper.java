package br.ufba.tomorrow.gerenciador.mappers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.dtos.CadastraUsuarioDTO;
import br.ufba.tomorrow.gerenciador.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "empresa", ignore = true)
    Usuario cadastraEmpresaDTOParaUsuario(CadastraEmpresaDTO cadastraEmpresaDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "empresa", ignore = true)
    Usuario cadastraUsuarioDTOParaUsuario(CadastraUsuarioDTO cadastraEmpresaDTO);
}

