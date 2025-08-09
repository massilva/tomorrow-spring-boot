package br.ufba.tomorrow.gerenciador.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.ContaPagarDTO;
import br.ufba.tomorrow.gerenciador.mappers.ContaPagarMapper;
import br.ufba.tomorrow.gerenciador.models.ContaPagar;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.repositories.ContaPagarRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaPagarService {

    private final ContaPagarRepository contaPagarRepository;
    private final EmpresaService empresaService;

    public ContaPagarDTO salvar(Long empresaId, ContaPagarDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);

        ContaPagar conta = new ContaPagar();
        conta.setFornecedor(dto.fornecedor());
        conta.setValor(dto.valor());
        conta.setVencimento(dto.vencimento());
        conta.setPago(dto.pago());
        conta.setEmpresa(empresa);

        return ContaPagarMapper.toDTO(contaPagarRepository.save(conta));
    }

    public List<ContaPagarDTO> listar(Long empresaId) {
        return contaPagarRepository.findByEmpresaId(empresaId)
         .parallelStream()
            .map(ContaPagarMapper::toDTO)
            .toList();
    }
}