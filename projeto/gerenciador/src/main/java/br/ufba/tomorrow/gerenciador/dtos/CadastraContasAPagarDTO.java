package br.ufba.tomorrow.gerenciador.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CadastraContasAPagarDTO {

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Valor é obrigatório")
    private Double valor;

    @NotNull(message = "Data de vencimento é obrigatória")
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull(message = "Status de pagamento é obrigatório")
    private Boolean pago;

    @NotNull(message = "Empresa é obrigatória")
    private Long empresaId;

    @NotNull(message = "Fornecedor é obrigatório")
    private Long fornecedorId;

    @NotNull(message = "Categoria é obrigatória")
    private Long categoriaId;
}