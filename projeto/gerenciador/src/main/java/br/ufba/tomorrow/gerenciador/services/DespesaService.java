package br.ufba.tomorrow.gerenciador.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.DespesaDTO;
import br.ufba.tomorrow.gerenciador.models.Categoria;
import br.ufba.tomorrow.gerenciador.models.Despesa;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.repositories.CategoriaRepository;
import br.ufba.tomorrow.gerenciador.repositories.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

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