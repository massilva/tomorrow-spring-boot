package br.ufba.tomorrow.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Empresa;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByEmail(String email);
}
