package br.ufba.tomorrow.gerenciador.controllers;

import br.ufba.tomorrow.gerenciador.dtos.CadastraContasAPagarDTO;
import br.ufba.tomorrow.gerenciador.mappers.ContasAPagarMapper;
import br.ufba.tomorrow.gerenciador.models.ContasAPagar;
import br.ufba.tomorrow.gerenciador.services.ContasAPagarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/contas-a-pagar")
@RequiredArgsConstructor
public class ContasAPagarController {

    private final ContasAPagarService service;

    @PostMapping
    public ContasAPagar salvar(@Valid @RequestBody CadastraContasAPagarDTO dto) {
        ContasAPagar conta = ContasAPagarMapper.INSTANCE.cadastraContasAPagarDTOParaContasAPagar(dto);
        return service.save(conta);
    }

    @GetMapping
    public List<ContasAPagar> listarTodas() {
        Long empresaId= 1234L;
        return service.listarContasPorEmpresa(empresaId);
    }

    @GetMapping("/empresa/{empresaId}/status/{pago}")
    public List<ContasAPagar> listarPorEmpresaEPago(@PathVariable Long empresaId,
                                                    @PathVariable boolean pago) {
        return service.listarPorEmpresaEPago(empresaId, pago);
    }

    @PutMapping("/{id}/pagar")
    public void marcarComoPago(@PathVariable Long id, @RequestBody String dataPagamento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dataPagamento,formatter);
        service.marcarComoPago(id, date);
    }
}