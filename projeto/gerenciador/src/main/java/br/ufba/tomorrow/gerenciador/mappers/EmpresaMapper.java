package br.ufba.tomorrow.gerenciador.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.ufba.tomorrow.gerenciador.dtos.AtualizaEmpresaDTO;
import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.output.EmpresaSalva;

@Mapper
public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(target = "id", ignore = true)
    Empresa cadastraEmpresaDTOParaEmpresa(CadastraEmpresaDTO cadastraEmpresaDTO);

    @Mapping(target = "id", ignore = true)
    Empresa atualizaEmpresaDTOParaEmpresa(AtualizaEmpresaDTO atualizaEmpresaDTO);

    EmpresaSalva paraEmpresaSalva(Empresa empresa);
}
