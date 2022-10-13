package br.com.lanche.pedido.service;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Response.CalculoPedidoResponse;
import br.com.lanche.pedido.entity.Response.PedidoResponse;

public interface PedidoService {
    PedidoResponse realizarPedido(final PedidoRequest pedido);

    CalculoPedidoResponse calcularValorPedido(final String idenficacaoPedido);
}
