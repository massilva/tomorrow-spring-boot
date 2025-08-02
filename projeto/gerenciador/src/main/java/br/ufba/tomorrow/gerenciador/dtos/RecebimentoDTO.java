package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record RecebimentoDTO(
    @NotBlank String cliente,
    @NotNull @DecimalMin("0.01") BigDecimal valor,
    @NotNull LocalDate vencimento,
    boolean recebido
) {}
