package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.factory.LinkPagamentoFactory;
import br.com.lanche.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final LinkPagamentoFactory factory;

    @Override
    public PedidoResponse realizarPedido(PedidoRequest pedido) {
        this.factory.get(pedido.getFormaDePagamento()).gerarlinkPagamento(pedido);
        return null;
    }
}
