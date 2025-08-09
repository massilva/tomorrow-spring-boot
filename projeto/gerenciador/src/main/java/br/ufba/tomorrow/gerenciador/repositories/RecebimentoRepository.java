package br.ufba.tomorrow.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Recebimento;

import java.util.List;
import java.util.Optional;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findByEmpresaId(Long empresaId);
    Optional<Recebimento> findByIdAndEmpresaId(Long id, Long empresaId);
}
