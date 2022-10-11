package br.com.lanche.pedido.controller;

import br.com.lanche.pedido.entity.Request.PedidoRequest;
import br.com.lanche.pedido.entity.Response.PedidoResponse;
import br.com.lanche.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(final @RequestBody @Valid PedidoRequest pedido){
        return ResponseEntity.ok(service.realizarPedido(pedido));
    }
}
