package br.com.lanche.pedido.service;

import br.com.lanche.pedido.entity.Request.EnderecoRequest;
import br.com.lanche.pedido.entity.Response.EnderecoResponse;

public interface EnderecoService {
    EnderecoResponse cadastrarEndereco(final EnderecoRequest endereco);
}
