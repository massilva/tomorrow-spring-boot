package controlegastos.controlegastosspringboot.dto;

import controlegastos.controlegastosspringboot.model.TipoImposto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ImpostoDTO(
        @NotNull(message = "Tipo do imposto é obrigatório")
        TipoImposto tipo,

        @NotNull(message = "Valor é obrigatório")
        @Positive(message = "Valor deve ser positivo")
        BigDecimal valor,

        @NotNull(message = "Data da competência é obrigatória")
        LocalDate dataCompetencia
) {}
