package br.com.lanche.pedido.strategy;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.Impl.NubankLinkPagamentoStrategyImpl;
import br.com.lanche.pedido.utils.PedidoTestUtils;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NubankLinkPagamentoStrategyImplTest {

    @Test
    public void deveRetornarLinkPagamentoNubank() {
        GeradorLinkPagamentoStrategy geradorLinkPagamentoStrategy = new NubankLinkPagamentoStrategyImpl();

        String response = geradorLinkPagamentoStrategy.gerarlinkPagamento(PedidoTestUtils.obterPedidoRequest());

        assertAll(
                () -> assertEquals("nubank.com", response),
                () -> assertNotNull(response)
        );
    }

    @Test
    public void deveRetornarFormaPagamentoNubank() {
        GeradorLinkPagamentoStrategy geradorLinkPagamentoStrategy = new NubankLinkPagamentoStrategyImpl();

        FormaDePagamentoEnum response = geradorLinkPagamentoStrategy.getFormaPagamento();

        assertAll(
                () -> assertEquals(FormaDePagamentoEnum.NUBANK, response),
                () -> assertNotNull(response)
        );
    }
}
