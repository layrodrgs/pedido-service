package br.com.lanche.pedido.service;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Response.CalculoPedidoResponse;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.exception.NotFoundException;
import br.com.lanche.pedido.factory.LinkPagamentoFactory;
import br.com.lanche.pedido.mapper.PedidoMapper;
import br.com.lanche.pedido.repository.PedidoRepository;
import br.com.lanche.pedido.service.Impl.PedidoServiceImpl;
import br.com.lanche.pedido.strategy.Impl.NubankLinkPagamentoStrategyImpl;
import br.com.lanche.pedido.utils.PedidoTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceImplTest {

    @Mock
    private PedidoRepository repository;

    @Mock
    private LinkPagamentoFactory factory;

    @Spy
    private PedidoMapper mapper = Mappers.getMapper(PedidoMapper.class);

    @InjectMocks
    private PedidoServiceImpl service;

    @Test
    public void deveLancarExececaoQuandoNaoEncontrarPedidoPorIdentificador() {
        when(this.repository.findByIdentificacaoPedido(any())).thenReturn(Optional.ofNullable(null));

        assertThrows(NotFoundException.class, () -> this.service.calcularValorPedido(UUID.randomUUID().toString()));
    }

    @Test
    public void deveRealizarUmPedidoComSucesso() {

        when(this.repository.save(any())).thenReturn(PedidoTestUtils.obterPedidoEntity());
        when(this.factory.get(eq(FormaDePagamentoEnum.NUBANK))).thenReturn(new NubankLinkPagamentoStrategyImpl());

        PedidoResponse pedidoResponse = service.realizarPedido(PedidoTestUtils.obterPedidoRequest());

        assertAll(
                () -> assertEquals(new BigDecimal(20), pedidoResponse.getValorDesconto()),
                () -> assertEquals("nubank.com", pedidoResponse.getLinkPagamento()),
                () -> assertEquals("e4c9c433-6352-434d-9f84-c79660dcd4fa", pedidoResponse.getIdentificacaoPedido()));

    }

    @Test
    public void deveCalcularValorPedido() {
        final String identificacaPedido = UUID.randomUUID().toString();

        when(this.repository.findByIdentificacaoPedido(eq(identificacaPedido)))
                .thenReturn(Optional.of(PedidoTestUtils.obterPedidoEntity()));

        CalculoPedidoResponse response = this.service.calcularValorPedido(identificacaPedido);

        assertAll(
                () -> assertEquals(new BigDecimal("50"), response.getValorTotalPedido()),
                () -> assertEquals(new BigDecimal("42.00"), response.getValorPorPessoa().get(1).getValorTotal()),
                () -> assertEquals(new BigDecimal("6.08"), response.getValorPorPessoa().get(0).getValorDesconto()),
                () -> assertEquals(new BigDecimal("31.92"), response.getValorPorPessoa().get(1).getValorDesconto()),
                () -> assertEquals(new BigDecimal("84.00"), response.getValorPorPessoa().get(1).getPercentualAplicado()),
                () -> assertEquals(identificacaPedido, response.getIdentificacaoPedido()),
                () -> assertEquals(identificacaPedido, response.getIdentificacaoPedido()));
    }
}
