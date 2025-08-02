package br.ufba.tomorrow.gerenciador.services;

import br.ufba.tomorrow.gerenciador.models.ContasAPagar;
import br.ufba.tomorrow.gerenciador.repositories.ContasAPagarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContasAPagarService {

    private final ContasAPagarRepository contasAPagarRepository;

    public ContasAPagar save(ContasAPagar contasAPagar) {
        return contasAPagarRepository.save(contasAPagar);
    }

    public List<ContasAPagar> listarContasPorEmpresa(Long empresaId) {
        return contasAPagarRepository.findByEmpresaId(empresaId);
    }

    public List<ContasAPagar> listarPorEmpresaEPago(Long empresaId, boolean pago) {
        return contasAPagarRepository.findByPago(empresaId, pago);
    }

    public ContasAPagar marcarComoPago(Long id, LocalDate dataPagamento) {
        ContasAPagar conta = contasAPagarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        conta.setPago(true);
        conta.setDataPagamento(dataPagamento);
        return contasAPagarRepository.save(conta);
    }
}
