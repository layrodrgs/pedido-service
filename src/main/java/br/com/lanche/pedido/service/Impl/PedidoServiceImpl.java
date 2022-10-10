package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.factory.LinkPagamentoFactory;
import br.com.lanche.pedido.service.PedidoService;
import br.com.lanche.pedido.strategy.GeradorLinkPagamentoStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final LinkPagamentoFactory factory;

    private final Map<FormaDePagamentoEnum, GeradorLinkPagamentoStrategy> strategies;

    @Override
    public PedidoResponse realizarPedido(PedidoRequest pedido) {
        this.factory.get(pedido.getFormaDePagamento()).gerarlinkPagamento(pedido);
        return null;
    }
}
