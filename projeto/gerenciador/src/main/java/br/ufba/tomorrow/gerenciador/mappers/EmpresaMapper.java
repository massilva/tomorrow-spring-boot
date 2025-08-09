package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.AtualizaEmpresaDTO;
import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.output.EmpresaSalva;

@Mapper
public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Empresa cadastraEmpresaDTOParaEmpresa(CadastraEmpresaDTO cadastraEmpresaDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Empresa atualizaEmpresaDTOParaEmpresa(AtualizaEmpresaDTO atualizaEmpresaDTO);

    EmpresaSalva paraEmpresaSalva(Empresa empresa);
}
