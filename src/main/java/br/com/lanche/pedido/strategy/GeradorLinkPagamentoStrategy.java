package br.com.lanche.pedido.strategy;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;

public interface GeradorLinkPagamentoStrategy {

    String gerarlinkPagamento(final PedidoRequest pedido);

    FormaDePagamentoEnum getFormaPagamento();
}
