package br.com.lanche.pedido.entity.Request;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoRequest {

    private FormaDePagamentoEnum formaDePagamento;
}
