package br.com.lanche.pedido.utils;

import br.com.lanche.pedido.entity.ItemPedidoEntity;
import br.com.lanche.pedido.entity.Request.ItemPedidoRequest;
import br.com.lanche.pedido.entity.Response.ItemPedidoResponse;
import br.com.lanche.pedido.entity.UsuarioEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemPedidoTestUtils {

    private ItemPedidoTestUtils(){

    }

    public static List<ItemPedidoEntity> obterItensPedidos() {
        UsuarioEntity layanne = UsuarioTestUtils.obterUsuarioEntity(1L, "layanne");

        ItemPedidoEntity itemPedido1 = ItemPedidoEntity.builder()
                .nomeProduto("Hamburguer")
                .precoProduto(new BigDecimal(40))
                .usuario(layanne)
                .build();

        ItemPedidoEntity itemPedido2 = ItemPedidoEntity.builder()
                .nomeProduto("Sobremesa")
                .precoProduto(new BigDecimal(2))
                .usuario(layanne)
                .build();

        ItemPedidoEntity itemPedido3 = ItemPedidoEntity.builder()
                .nomeProduto("Sanduiche")
                .precoProduto(new BigDecimal(8))
                .usuario(UsuarioTestUtils.obterUsuarioEntity(2L, "Matheus"))
                .build();


        return Arrays.asList(itemPedido1, itemPedido2, itemPedido3);

    }

    public static List<ItemPedidoResponse> obterItensPedidosResponse() {

        ItemPedidoResponse itemPedido1 = ItemPedidoResponse.builder()
                .nomeProduto("Hamburguer")
                .precoProduto(new BigDecimal(40))
                .build();

        ItemPedidoResponse itemPedido2 = ItemPedidoResponse.builder()
                .nomeProduto("Sobremesa")
                .precoProduto(new BigDecimal(2))
                .build();

        ItemPedidoResponse itemPedido3 = ItemPedidoResponse.builder()
                .nomeProduto("Sanduiche")
                .precoProduto(new BigDecimal(8))
                .build();


        return Arrays.asList(itemPedido1, itemPedido2, itemPedido3);

    }

    public static List<ItemPedidoRequest> obterItensPedidosRequest() {

        ItemPedidoRequest itemPedido1 = ItemPedidoRequest.builder()
                .nomeProduto("Hamburguer")
                .precoProduto(new BigDecimal(40))
                .usuarioId(1L)
                .build();

        ItemPedidoRequest itemPedido2 = ItemPedidoRequest.builder()
                .nomeProduto("Sobremesa")
                .precoProduto(new BigDecimal(2))
                .usuarioId(1L)
                .build();

        ItemPedidoRequest itemPedido3 = ItemPedidoRequest.builder()
                .nomeProduto("Sanduiche")
                .precoProduto(new BigDecimal(8))
                .usuarioId(2L)
                .build();


        return Arrays.asList(itemPedido1, itemPedido2, itemPedido3);

    }

}
