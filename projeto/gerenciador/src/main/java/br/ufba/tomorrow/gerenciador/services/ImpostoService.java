package br.ufba.tomorrow.gerenciador.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.ImpostoDTO;
import br.ufba.tomorrow.gerenciador.dtos.ImpostoResponseDTO;
import br.ufba.tomorrow.gerenciador.mappers.ImpostoMapper;
import br.ufba.tomorrow.gerenciador.mappers.RecebimentoMapper;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.models.Imposto;
import br.ufba.tomorrow.gerenciador.repositories.ImpostoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImpostoService {

    private final ImpostoRepository impostoRepository;
    private final EmpresaService empresaService;

    public Imposto salvar(Long empresaId, ImpostoDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);
        Imposto imposto = new Imposto();
        imposto.setTipo(dto.tipo());
        imposto.setValor(dto.valor());
        imposto.setDataCompetencia(dto.dataCompetencia());
        imposto.setEmpresa(empresa);
        return impostoRepository.save(imposto);
    }

    public List<ImpostoResponseDTO> listar(Long empresaId) {
        return impostoRepository.findByEmpresaId(empresaId)
                .stream()
                .map(ImpostoMapper::toDTO)
                .collect(Collectors.toList());
    }
}