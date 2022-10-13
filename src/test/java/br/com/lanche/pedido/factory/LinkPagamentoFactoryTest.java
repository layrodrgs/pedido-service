package br.com.lanche.pedido.factory;

import br.com.lanche.pedido.PedidoApplication;
import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.strategy.Impl.PicPayLinkPagamentoStrategyImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PedidoApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class LinkPagamentoFactoryTest {
    @Autowired
    private LinkPagamentoFactory factory;

    @Test
    public void deveRetornarPicPayQuandoFormaPagamentoForPicPay() {
        assertTrue(factory.get(FormaDePagamentoEnum.PICPAY) instanceof PicPayLinkPagamentoStrategyImpl);
    }
}
