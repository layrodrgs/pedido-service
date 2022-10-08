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
public class ItemPedidoResponse {

    private String nomeProduto;
    private BigDecimal precoProduto;
}
