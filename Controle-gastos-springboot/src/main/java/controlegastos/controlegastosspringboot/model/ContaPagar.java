package controlegastos.controlegastosspringboot.model;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fornecedor;

    private BigDecimal valor;

    private LocalDate vencimento;

    private boolean pago;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
