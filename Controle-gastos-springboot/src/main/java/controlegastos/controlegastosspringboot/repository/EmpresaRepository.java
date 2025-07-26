package controlegastos.controlegastosspringboot.repository;

import controlegastos.controlegastosspringboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByEmail(String email);
}
