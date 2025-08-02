package com.exemplo.ufba.tomorrow.gerenciador.service;

import com.exemplo.ufba.tomorrow.gerenciador.dto.*;
import com.exemplo.ufba.tomorrow.gerenciador.model.*;
import com.exemplo.ufba.tomorrow.gerenciador.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecebimentoService {

    private final RecebimentoRepository recebimentoRepository;
    private final EmpresaService empresaService;

    public Recebimento salvar(Long empresaId, RecebimentoDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);

        Recebimento recebimento = new Recebimento();
        recebimento.setCliente(dto.cliente());
        recebimento.setValor(dto.valor());
        recebimento.setVencimento(dto.vencimento());
        recebimento.setRecebido(dto.recebido());
        recebimento.setEmpresa(empresa);

        return recebimentoRepository.save(recebimento);
    }

    public List<Recebimento> listar(Long empresaId) {
        return recebimentoRepository.findByEmpresaId(empresaId);
    }
}
