package br.ufba.tomorrow.gerenciador.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Despesa;
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByEmpresaId(Long empresaId);
}
