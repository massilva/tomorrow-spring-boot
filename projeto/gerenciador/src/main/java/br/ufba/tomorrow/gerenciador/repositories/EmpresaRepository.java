package br.ufba.tomorrow.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
