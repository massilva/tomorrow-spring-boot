package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record RecebimentoDTO(
    @NotBlank(message = "Cliente é obrigatório")
    String cliente,

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser positivo")
    BigDecimal valor,

    @NotNull(message = "Data de vencimento é obrigatória")
    LocalDate vencimento,

    boolean recebido
) {}
