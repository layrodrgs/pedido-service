package br.com.lanche.pedido.factory;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.GeradorLinkPagamentoStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LinkPagamentoFactory {

    private final Map<FormaDePagamentoEnum, GeradorLinkPagamentoStrategy> gerarLinkPagamentoStrategyMap;

    public LinkPagamentoFactory(List<GeradorLinkPagamentoStrategy> strategies) {
        this.gerarLinkPagamentoStrategyMap = createStrategy(strategies);

    }

    private Map<FormaDePagamentoEnum, GeradorLinkPagamentoStrategy> createStrategy(List<GeradorLinkPagamentoStrategy> strategies) {
        var strategyMap = new HashMap<FormaDePagamentoEnum, GeradorLinkPagamentoStrategy>();
        strategies.forEach(
                strategy -> strategyMap.put(strategy.getFormaPagamento(), strategy));
        return strategyMap;
    }

    public GeradorLinkPagamentoStrategy get(FormaDePagamentoEnum formaDePagamentoEnum){
        return this.gerarLinkPagamentoStrategyMap.get(formaDePagamentoEnum);
    }
}
