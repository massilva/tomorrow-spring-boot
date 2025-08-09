package br.ufba.tomorrow.gerenciador.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.ufba.tomorrow.gerenciador.enums.TipoImposto;

public record ImpostoResponseDTO(
    Long id,
    TipoImposto tipo,
    BigDecimal valor,
    LocalDate dataCompetencia
) {}
