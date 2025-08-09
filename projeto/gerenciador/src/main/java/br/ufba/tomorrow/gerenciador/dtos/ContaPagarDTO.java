package br.ufba.tomorrow.gerenciador.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ContaPagarDTO(
    @NotBlank(message = "Fornecedor é obrigatório")
    String fornecedor,

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser positivo")
    BigDecimal valor,

    @NotNull(message = "Data de vencimento é obrigatória")
    LocalDate vencimento,

    boolean pago
) {}