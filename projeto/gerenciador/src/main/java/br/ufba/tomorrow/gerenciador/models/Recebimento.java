package com.exemplo.br.ufba.tomorrow.gerenciador.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recebimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private BigDecimal valor;
    private LocalDate vencimento;
    private boolean recebido;

    @ManyToOne
    private Empresa empresa;
}
