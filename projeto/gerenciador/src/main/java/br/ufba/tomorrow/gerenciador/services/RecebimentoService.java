package com.exemplo.ufba.tomorrow.gerenciador.service;

import com.exemplo.ufba.tomorrow.gerenciador.dto.*;
import com.exemplo.ufba.tomorrow.gerenciador.mapper.RecebimentoMapper;
import com.exemplo.ufba.tomorrow.gerenciador.model.*;
import com.exemplo.ufba.tomorrow.gerenciador.repository.RecebimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
