package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.entity.PedidoEntity;
import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.factory.LinkPagamentoFactory;
import br.com.lanche.pedido.mapper.PedidoMapper;
import br.com.lanche.pedido.repository.PedidoRepository;
import br.com.lanche.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final LinkPagamentoFactory factory;

    private final PedidoMapper mapper;

    private final PedidoRepository repository;

    @Override
    public PedidoResponse realizarPedido(PedidoRequest pedido) {
        PedidoEntity pedidoEntity = this.mapper.map(pedido);
        pedidoEntity.setStatusPedido(StatusPedidoEnum.PENDENTE);
        pedidoEntity.setIdentificacaoPagamento(UUID.randomUUID().toString());
        pedidoEntity.setLinkPagamento(this.factory.get(pedido.getFormaDePagamento()).gerarlinkPagamento(pedido));
        return this.mapper.map(this.repository.save(pedidoEntity));
    }
}
