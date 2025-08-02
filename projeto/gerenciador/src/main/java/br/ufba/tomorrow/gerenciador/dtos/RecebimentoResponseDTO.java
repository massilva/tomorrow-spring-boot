package br.ufba.tomorrow.gerenciador.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RecebimentoResponseDTO(
    Long id,
    String cliente,
    BigDecimal valor,
    LocalDate vencimento,
    boolean recebido
) {}
