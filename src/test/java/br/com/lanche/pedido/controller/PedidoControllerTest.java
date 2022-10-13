package br.com.lanche.pedido.controller;

import br.com.lanche.pedido.service.PedidoService;
import br.com.lanche.pedido.utils.JsonUtils;
import br.com.lanche.pedido.utils.PedidoTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PedidoController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PedidoControllerTest {
    private static final String PATH = "/pedidos";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService service;

    @Test
    public void deveRealizarPedidoComSucesso() throws Exception {

        when(this.service.realizarPedido(any())).thenReturn(PedidoTestUtils.getPedidoResponse());
        mockMvc.perform(
                        post(PATH)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonUtils.toJson(PedidoTestUtils.obterPedidoRequest())))
                .andDo(print())
                .andExpectAll(status().isOk(),
                        content().string(JsonUtils.toJson(PedidoTestUtils.getPedidoResponse())));
    }
}
