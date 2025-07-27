package controlegastos.controlegastosspringboot.service;

import controlegastos.controlegastosspringboot.dto.*;
import controlegastos.controlegastosspringboot.model.*;
import controlegastos.controlegastosspringboot.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaPagarService {

    private final ContaPagarRepository contaPagarRepository;
    private final EmpresaService empresaService;

    public ContaPagar salvar(Long empresaId, ContaPagarDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);

        ContaPagar conta = new ContaPagar();
        conta.setFornecedor(dto.fornecedor());
        conta.setValor(dto.valor());
        conta.setVencimento(dto.vencimento());
        conta.setPago(dto.pago());
        conta.setEmpresa(empresa);

        return contaPagarRepository.save(conta);
    }

    public List<ContaPagar> listar(Long empresaId) {
        return contaPagarRepository.findByEmpresaId(empresaId);
    }
}
