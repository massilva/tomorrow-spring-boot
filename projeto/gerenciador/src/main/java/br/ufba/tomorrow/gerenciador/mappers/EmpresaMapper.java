package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.models.Empresa;

public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(target = "id", ignore = true)
    Empresa cadastraEmpresaDTOParaEmpresa(CadastraEmpresaDTO cadastraEmpresaDTO);
}
