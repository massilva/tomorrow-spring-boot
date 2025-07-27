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

    public List<Imposto> listar(Long empresaId) {
        return impostoRepository.findByEmpresaId(empresaId);
    }
}