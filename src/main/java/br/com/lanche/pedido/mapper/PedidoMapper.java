package br.com.lanche.pedido.mapper;

import br.com.lanche.pedido.entity.ItemPedidoEntity;
import br.com.lanche.pedido.entity.PedidoEntity;
import br.com.lanche.pedido.entity.Request.ItemPedidoRequest;
import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PedidoMapper {

    @Mapping(target = "enderecoEntrega.id", source = "entrega.enderecoEntregaId")
    @Mapping(target = "valorEntrega", source = "entrega.valorEntrega")
    PedidoEntity map(final PedidoRequest pedido);

    @Mapping(target = "usuario.id", source = "usuarioId")
    ItemPedidoEntity map(final ItemPedidoRequest itemPedido);

    PedidoResponse map(final PedidoEntity pedido);


}
