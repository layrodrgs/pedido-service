package br.com.lanche.pedido.strategy.Impl;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.GeradorLinkPagamentoStrategy;
import org.springframework.stereotype.Component;

@Component
public class NubankLinkPagamentoStrategyImpl implements GeradorLinkPagamentoStrategy {

    @Override
    public String gerarlinkPagamento(PedidoRequest pedido) {
        return null;
    }

    @Override
    public FormaDePagamentoEnum getFormaPagamento() {
        return FormaDePagamentoEnum.NUBANK;
    }
}
