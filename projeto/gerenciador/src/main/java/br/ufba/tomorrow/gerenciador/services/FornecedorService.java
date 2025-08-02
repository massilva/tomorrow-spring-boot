package br.ufba.tomorrow.gerenciador.services;

import br.ufba.tomorrow.gerenciador.models.Fornecedor;
import br.ufba.tomorrow.gerenciador.repositories.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository repository;

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}