package br.ufba.tomorrow.gerenciador.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.ContaPagar;

public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {
    List<ContaPagar> findByEmpresaId(Long empresaId);
}
