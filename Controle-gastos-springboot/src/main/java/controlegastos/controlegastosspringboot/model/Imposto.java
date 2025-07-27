package controlegastos.controlegastosspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imposto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoImposto tipo;

    private BigDecimal valor;
    private LocalDate dataCompetencia;

    @ManyToOne
    private Empresa empresa;
}