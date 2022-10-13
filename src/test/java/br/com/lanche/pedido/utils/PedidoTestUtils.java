package br.com.lanche.pedido.utils;

import br.com.lanche.pedido.entity.PedidoEntity;
import br.com.lanche.pedido.entity.Request.EntregaRequest;
import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
import br.com.lanche.pedido.entity.Response.PedidoResponse;

import java.math.BigDecimal;

public class PedidoTestUtils {

    private PedidoTestUtils(){

    }

    public static PedidoEntity obterPedidoEntity() {
        return PedidoEntity.builder()
                .id(1L)
                .identificacaoPedido("e4c9c433-6352-434d-9f84-c79660dcd4fa")
                .statusPedido(StatusPedidoEnum.AGUARDANDO_PAGAMENTO)
                .acrescimoPorcentagem(BigDecimal.ZERO)
                .acrescimoReal(BigDecimal.ZERO)
                .formaDePagamento(FormaDePagamentoEnum.NUBANK)
                .valorDesconto(new BigDecimal(20))
                .valorEntrega(new BigDecimal(8))
                .linkPagamento("nubank.com")
                .enderecoEntrega(EnderecoTestUtils.obterEnderecoEntity())
                .itens(ItemPedidoTestUtils.obterItensPedidos())
                .build();
    }

    public static PedidoRequest obterPedidoRequest() {
        return PedidoRequest.builder()
                .valorDesconto(new BigDecimal("20"))
                .acrescimoPorcentagem(BigDecimal.ZERO)
                .acrescimoReal(BigDecimal.ZERO)
                .itens(ItemPedidoTestUtils.obterItensPedidosRequest())
                .formaDePagamento(FormaDePagamentoEnum.NUBANK)
                .entrega(obterEntregaRequest())
                .build();
    }

    public static PedidoResponse getPedidoResponse() {
        return PedidoResponse.builder()
                .statusPedido(StatusPedidoEnum.AGUARDANDO_PAGAMENTO)
                .formaDePagamento(FormaDePagamentoEnum.NUBANK)
                .valorDesconto(new BigDecimal(20))
                .linkPagamento("nubank.com")
                .identificacaoPedido("e4c9c433-6352-434d-9f84-c79660dcd4fa")
                .itens(ItemPedidoTestUtils.obterItensPedidosResponse())
                .build();
    }

    private static EntregaRequest obterEntregaRequest() {
        return EntregaRequest.builder()
                .enderecoEntregaId(1L)
                .valorEntrega(new BigDecimal(8))
                .build();
    }
}
