package br.com.lanche.pedido.strategy;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.Impl.NubankLinkPagamentoStrategyImpl;
import br.com.lanche.pedido.strategy.Impl.PicPayLinkPagamentoStrategyImpl;
import br.com.lanche.pedido.utils.PedidoTestUtils;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PicPayLinkPagamentoStrategyImplTest {
    @Test
    public void deveRetornarLinkPagamentoPicPay() {
        GeradorLinkPagamentoStrategy geradorLinkPagamentoStrategy = new PicPayLinkPagamentoStrategyImpl();

        String response = geradorLinkPagamentoStrategy.gerarlinkPagamento(PedidoTestUtils.obterPedidoRequest());

        assertAll(
                () -> assertEquals("picpay.com", response),
                () -> assertNotNull(response)
        );
    }

    @Test
    public void deveRetornarFormaPagamentoPicPay() {
        GeradorLinkPagamentoStrategy geradorLinkPagamentoStrategy = new PicPayLinkPagamentoStrategyImpl();

        FormaDePagamentoEnum response = geradorLinkPagamentoStrategy.getFormaPagamento();

        assertAll(
                () -> assertEquals(FormaDePagamentoEnum.PICPAY, response),
                () -> assertNotNull(response)
        );
    }
}
