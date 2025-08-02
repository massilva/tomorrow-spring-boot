package br.ufba.tomorrow.gerenciador.repository;

import br.ufba.tomorrow.gerenciador.model.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findByEmpresaId(Long empresaId);
}
