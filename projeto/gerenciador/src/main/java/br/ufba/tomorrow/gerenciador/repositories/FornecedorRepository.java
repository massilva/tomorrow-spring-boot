package br.ufba.tomorrow.gerenciador.repositories;

import br.ufba.tomorrow.gerenciador.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}