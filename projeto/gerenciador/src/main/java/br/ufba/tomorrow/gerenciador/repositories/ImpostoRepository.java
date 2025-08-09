package br.ufba.tomorrow.gerenciador.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Imposto;

public interface ImpostoRepository extends JpaRepository<Imposto, Long> {
    List<Imposto> findByEmpresaId(Long empresaId);
}
