package com.exemplo.ufba.tomorrow.gerenciador.repository;

import com.exemplo.ufba.tomorrow.gerenciador.model.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findByEmpresaId(Long empresaId);
}
