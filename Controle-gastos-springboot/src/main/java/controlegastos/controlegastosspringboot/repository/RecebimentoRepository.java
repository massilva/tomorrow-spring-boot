package controlegastos.controlegastosspringboot.repository;

import controlegastos.controlegastosspringboot.model.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findByEmpresaId(Long empresaId);
    Optional<Recebimento> findByIdAndEmpresaId(Long id, Long empresaId);
}
