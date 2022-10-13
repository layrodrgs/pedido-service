package br.com.lanche.pedido.entity.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValorTotalPorPessoaResponse {

    private Long usuarioId;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    private BigDecimal percentualAplicado;
}
