package br.ufba.tomorrow.gerenciador.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.RecebimentoDTO;
import br.ufba.tomorrow.gerenciador.dtos.RecebimentoResponseDTO;
import br.ufba.tomorrow.gerenciador.exceptions.NotFoundException;
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

    public RecebimentoResponseDTO atualizar(Long empresaId, Long id, RecebimentoDTO dto) {
        Recebimento recebimento = buscarPorId(empresaId, id);
        recebimento.setCliente(dto.cliente());
        recebimento.setValor(dto.valor());
        recebimento.setVencimento(dto.vencimento());
        recebimento.setRecebido(dto.recebido());
        return RecebimentoMapper.toDTO(recebimentoRepository.save(recebimento));
    }

    public void deletar(Long empresaId, Long id) {
        Recebimento recebimento = buscarPorId(empresaId, id);
        recebimentoRepository.delete(recebimento);
    }

    public RecebimentoResponseDTO buscaPorId(Long empresaId, Long id) {
        Recebimento recebimento = buscarPorId(empresaId, id);
        return RecebimentoMapper.toDTO(recebimento);
    }

    private Recebimento buscarPorId(Long empresaId, Long id) {
        return recebimentoRepository.findByIdAndEmpresaId(id, empresaId)
                .orElseThrow(() -> new NotFoundException("Recebimento não encontrado"));
    }
}
