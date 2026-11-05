package io.github.caiovvieira.demo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoDto {
    private String numeroPedido;
    private BigDecimal valor;
    private String produto;
}
