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
public class DespesaService {

    private final DespesaRepository despesaRepository;
    private final CategoriaRepository categoriaRepository;
    private final EmpresaService empresaService;

    public Despesa salvar(Long empresaId, DespesaDTO dto) {
        Empresa empresa = empresaService.buscarPorId(empresaId);
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        Despesa despesa = new Despesa();
        despesa.setDescricao(dto.descricao());
        despesa.setValor(dto.valor());
        despesa.setData(dto.data());
        despesa.setEmpresa(empresa);
        despesa.setCategoria(categoria);

        return despesaRepository.save(despesa);
    }

    public List<Despesa> listarPorEmpresa(Long empresaId) {
        return despesaRepository.findByEmpresaId(empresaId);
    }
}