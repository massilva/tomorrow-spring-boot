package controlegastos.controlegastosspringboot.service;

import controlegastos.controlegastosspringboot.dto.RecebimentoDTO;
import controlegastos.controlegastosspringboot.model.Empresa;
import controlegastos.controlegastosspringboot.model.Recebimento;
import controlegastos.controlegastosspringboot.repository.RecebimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecebimentoService {

    private final RecebimentoRepository recebimentoRepository;
    private final EmpresaService empresaService;

    public Recebimento salvar(Long empresaId, RecebimentoDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);

        Recebimento recebimento = Recebimento.builder()
                .cliente(dto.cliente())
                .valor(dto.valor())
                .vencimento(dto.vencimento())
                .recebido(dto.recebido())
                .empresa(empresa)
                .build();

        return recebimentoRepository.save(recebimento);
    }

    public List<Recebimento> listar(Long empresaId) {
        return recebimentoRepository.findByEmpresaId(empresaId);
    }

    public Recebimento buscarPorId(Long empresaId, Long id) {
        return recebimentoRepository.findByIdAndEmpresaId(id, empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Recebimento não encontrado"));
    }

    public Recebimento atualizar(Long empresaId, Long id, RecebimentoDTO dto) {
        Recebimento recebimento = buscarPorId(empresaId, id);
        recebimento.setCliente(dto.cliente());
        recebimento.setValor(dto.valor());
        recebimento.setVencimento(dto.vencimento());
        recebimento.setRecebido(dto.recebido());
        return recebimentoRepository.save(recebimento);
    }

    public void deletar(Long empresaId, Long id) {
        Recebimento recebimento = buscarPorId(empresaId, id);
        recebimentoRepository.delete(recebimento);
    }
}
