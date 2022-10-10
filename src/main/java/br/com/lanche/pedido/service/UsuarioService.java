package br.com.lanche.pedido.service;

import br.com.lanche.pedido.entity.Request.UsuarioRequest;
import br.com.lanche.pedido.entity.Response.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse cadastrarUsuario(final UsuarioRequest usuario);
}
