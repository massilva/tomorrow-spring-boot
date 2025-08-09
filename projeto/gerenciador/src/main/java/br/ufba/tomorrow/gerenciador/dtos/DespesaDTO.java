package br.ufba.tomorrow.gerenciador.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DespesaDTO(
    @NotBlank(message = "Descrição é obrigatória")
    String descricao,

    @NotNull(message = "Valor é obrigatório")
    @Positive(message = "Valor deve ser positivo")
    BigDecimal valor,

    @NotNull(message = "Data é obrigatória")
    LocalDate data,

    @NotNull(message = "CategoriaId é obrigatório")
    Long categoriaId
) {}