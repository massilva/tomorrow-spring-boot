package br.ufba.tomorrow.gerenciador.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.RecebimentoDTO;
import br.ufba.tomorrow.gerenciador.dtos.RecebimentoResponseDTO;
import br.ufba.tomorrow.gerenciador.mappers.RecebimentoMapper;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.models.Recebimento;
import br.ufba.tomorrow.gerenciador.repositories.RecebimentoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecebimentoService {

    private final RecebimentoRepository recebimentoRepository;
    private final EmpresaService empresaService;

    public RecebimentoResponseDTO salvar(Long empresaId, RecebimentoDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);
        Recebimento entity = RecebimentoMapper.toEntity(dto, empresa);
        return RecebimentoMapper.toDTO(recebimentoRepository.save(entity));
    }

    public List<RecebimentoResponseDTO> listar(Long empresaId) {
        return recebimentoRepository.findByEmpresaId(empresaId)
                .stream()
                .map(RecebimentoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
