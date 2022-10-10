package br.com.lanche.pedido.controller;

import br.com.lanche.pedido.entity.Request.UsuarioRequest;
import br.com.lanche.pedido.entity.Response.UsuarioResponse;
import br.com.lanche.pedido.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastraUsuario(final @RequestBody @Valid UsuarioRequest usuario){
        return ResponseEntity.ok(this.service.cadastrarUsuario(usuario));
    }
}
