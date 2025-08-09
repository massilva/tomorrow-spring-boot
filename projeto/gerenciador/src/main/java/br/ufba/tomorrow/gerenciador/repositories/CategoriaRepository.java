package br.ufba.tomorrow.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.tomorrow.gerenciador.models.Categoria;
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}