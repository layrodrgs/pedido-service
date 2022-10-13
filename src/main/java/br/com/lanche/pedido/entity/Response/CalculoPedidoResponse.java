package br.com.lanche.pedido.entity.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculoPedidoResponse {

    private BigDecimal valorTotalPedido;
    private BigDecimal taxaEntrega;
    private BigDecimal acrescimoPorcentagem;
    private BigDecimal acrescimoReal;
    private String identificacaoPedido;
    private List<ValorTotalPorPessoaResponse> valorPorPessoa;
}
