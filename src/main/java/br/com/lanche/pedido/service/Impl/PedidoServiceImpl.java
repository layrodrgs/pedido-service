package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.entity.ItemPedidoEntity;
import br.com.lanche.pedido.entity.PedidoEntity;
import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
import br.com.lanche.pedido.entity.Response.CalculoPedidoResponse;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.entity.Response.ValorTotalPorPessoaResponse;
import br.com.lanche.pedido.entity.UsuarioEntity;
import br.com.lanche.pedido.exception.NotFoundException;
import br.com.lanche.pedido.factory.LinkPagamentoFactory;
import br.com.lanche.pedido.mapper.PedidoMapper;
import br.com.lanche.pedido.repository.PedidoRepository;
import br.com.lanche.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final LinkPagamentoFactory factory;

    private final PedidoMapper mapper;

    private final PedidoRepository repository;

    @Override
    public PedidoResponse realizarPedido(PedidoRequest pedido) {
        String identificacaoPedido = this.gerarIdentificador();

        log.info("Realizando cadastro de um pedido com identificador '{}'", identificacaoPedido);
        PedidoEntity pedidoEntity = this.mapper.map(pedido);
        pedidoEntity.setStatusPedido(StatusPedidoEnum.AGUARDANDO_PAGAMENTO);
        pedidoEntity.setIdentificacaoPedido(UUID.randomUUID().toString());
        pedidoEntity.setLinkPagamento(this.factory.get(pedido.getFormaDePagamento()).gerarlinkPagamento(pedido));
        return this.mapper.map(this.repository.save(pedidoEntity));
    }

    @Override
    public CalculoPedidoResponse calcularValorPedido(String identificacaoPedido) {

        log.info("Realizando calculo do pedido com o identificador '{}'", identificacaoPedido);
        PedidoEntity pedido = this.repository.findByIdentificacaoPedido(identificacaoPedido)
                .orElseThrow(NotFoundException::new);

        BigDecimal totalItensPedido = pedido.getItens().stream()
                .map(ItemPedidoEntity::getPrecoProduto)
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);


        CalculoPedidoResponse calculo = CalculoPedidoResponse.builder()
                .identificacaoPedido(identificacaoPedido)
                .valorTotalPedido(totalItensPedido)
                .taxaEntrega(pedido.getValorEntrega())
                .acrescimoReal(pedido.getAcrescimoReal())
                .acrescimoPorcentagem(pedido.getAcrescimoPorcentagem())
                .valorPorPessoa(new ArrayList<>())
                .build();

        Map<UsuarioEntity, List<ItemPedidoEntity>> listaDePedidosPorUsuario = getListaDePedidosPorUsuario(pedido);

        listaDePedidosPorUsuario.forEach(getUsuarioEntityListBiConsumer(pedido, totalItensPedido, calculo, listaDePedidosPorUsuario));

        return calculo;
    }

    private Map<UsuarioEntity, List<ItemPedidoEntity>> getListaDePedidosPorUsuario(PedidoEntity pedido) {
        return pedido.getItens()
                .stream()
                .collect(Collectors.groupingBy(ItemPedidoEntity::getUsuario));
    }

    private BiConsumer<UsuarioEntity, List<ItemPedidoEntity>> getUsuarioEntityListBiConsumer(PedidoEntity pedido, BigDecimal totalItensPedido, CalculoPedidoResponse calculo, Map<UsuarioEntity, List<ItemPedidoEntity>> listaDePedidosPorUsuario) {
        return (key, value) -> {

            BigDecimal totalPorPessoa = listaDePedidosPorUsuario.get(key).stream()
                    .map(ItemPedidoEntity::getPrecoProduto)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            BigDecimal percentualPessoa = this.calculaPercentual(totalItensPedido, totalPorPessoa);
            BigDecimal descontoPropocional = this.calculaValorPercentual(pedido.getValorDesconto(), percentualPessoa);
            BigDecimal taxaServicoPropocional = this.calculaValorPercentual(pedido.getValorEntrega(), percentualPessoa);
            BigDecimal valotTotal = this.calculaValorPercentual(totalItensPedido, percentualPessoa);
            BigDecimal valorPercentualFuncionario = this.calculaValorPercentual(totalItensPedido, pedido.getAcrescimoPorcentagem());
            BigDecimal valorRealProporcional = this.calculaValorPercentual(pedido.getAcrescimoReal(), percentualPessoa);

            valotTotal.add(valorPercentualFuncionario.divide(BigDecimal.valueOf(listaDePedidosPorUsuario.size())))
                    .add(valorRealProporcional);

            ValorTotalPorPessoaResponse valorPorPessoa = getValorTotalPorPessoaResponse(key, percentualPessoa, descontoPropocional, taxaServicoPropocional, valotTotal);

            calculo.getValorPorPessoa().add(valorPorPessoa);
        };
    }

    private String gerarIdentificador() {
        return UUID.randomUUID().toString();
    }


    private ValorTotalPorPessoaResponse getValorTotalPorPessoaResponse(UsuarioEntity key, BigDecimal percentualPessoa, BigDecimal descontoPropocional, BigDecimal taxaServicoPropocional, BigDecimal valotTotal) {
        return ValorTotalPorPessoaResponse
                .builder()
                .usuarioId(key.getId())
                .percentualAplicado(percentualPessoa)
                .valorDesconto(valotTotal.add(taxaServicoPropocional).subtract(descontoPropocional))
                .valorTotal(valotTotal)
                .build();
    }

    private BigDecimal calculaValorPercentual(final BigDecimal valor, final BigDecimal percentual) {
        if (Objects.isNull(valor) || Objects.isNull(percentual)) {
            return BigDecimal.ZERO;
        }
        return valor.multiply(percentual.divide(new BigDecimal(100)))
                .setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal calculaPercentual(final BigDecimal valorTotal, final BigDecimal valorAtual) {
        return valorAtual.divide(valorTotal, MathContext.DECIMAL64).multiply(new BigDecimal(100));
    }

}
