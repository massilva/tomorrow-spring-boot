package controlegastos.controlegastosspringboot.repository;

import controlegastos.controlegastosspringboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}