package br.ufba.tomorrow.gerenciador.repositories;

import br.ufba.tomorrow.gerenciador.models.ContasAPagar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContasAPagarRepository extends JpaRepository<ContasAPagar,Long> {
    List<ContasAPagar> findByEmpresaId(Long empresaId);
    List<ContasAPagar> findByPago(Long empresaId, boolean pago);
}
