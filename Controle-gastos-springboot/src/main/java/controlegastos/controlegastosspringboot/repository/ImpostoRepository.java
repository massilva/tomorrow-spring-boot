package controlegastos.controlegastosspringboot.repository;

import controlegastos.controlegastosspringboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImpostoRepository extends JpaRepository<Imposto, Long> {
    List<Imposto> findByEmpresaId(Long empresaId);
}
