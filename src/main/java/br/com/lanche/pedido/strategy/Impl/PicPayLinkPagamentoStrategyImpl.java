package br.com.lanche.pedido.strategy.Impl;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.GeradorLinkPagamentoStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class PicPayLinkPagamentoStrategyImpl implements GeradorLinkPagamentoStrategy {

    @Override
    public String gerarlinkPagamento(PedidoRequest pedido) {
        log.info("Gerando link de pagamento '{}'", this.getFormaPagamento());
        final String linkGerado = UUID.randomUUID().toString();
        log.info("Link de pagamento gerado com sucesso: '{}'", linkGerado);
        return "picpay.com";
    }

    @Override
    public FormaDePagamentoEnum getFormaPagamento() {
        return FormaDePagamentoEnum.PICPAY;
    }
}
