package br.ufba.tomorrow.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.br.ufba.tomorrow.gerenciador.model.*;

import java.util.Optional;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findByEmpresaId(Long empresaId);
}
