package br.com.lanche.pedido.controller;

import br.com.lanche.pedido.entity.Request.EnderecoRequest;
import br.com.lanche.pedido.entity.Response.EnderecoResponse;
import br.com.lanche.pedido.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;
    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastraEndereco(final @RequestBody @Valid EnderecoRequest endereco){
        return ResponseEntity.ok(service.cadastrarEndereco(endereco));
    }
}
