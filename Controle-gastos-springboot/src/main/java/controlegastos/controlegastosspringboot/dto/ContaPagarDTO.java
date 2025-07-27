package controlegastos.controlegastosspringboot.dto;

import controlegastos.controlegastosspringboot.model.TipoImposto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
