package br.ufba.tomorrow.gerenciador.repositories;

import br.ufba.tomorrow.gerenciador.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}