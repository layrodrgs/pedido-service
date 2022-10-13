package br.com.lanche.pedido.entity.Response;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
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
public class PedidoResponse {

    private List<ItemPedidoResponse> itens;

    private BigDecimal valorDesconto;

    private String linkPagamento;

    private FormaDePagamentoEnum formaDePagamento;

    private StatusPedidoEnum statusPedido;

    private String identificacaoPedido;
}
