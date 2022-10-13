package br.com.lanche.pedido.utils;

import br.com.lanche.pedido.entity.UsuarioEntity;

public class UsuarioTestUtils {

    private UsuarioTestUtils(){

    }

    public static UsuarioEntity obterUsuarioEntity(Long id, String nome){
        return UsuarioEntity.builder()
                .id(id)
                .nome(nome)
                .endereco(EnderecoTestUtils.obterEnderecoEntity())
                .build();
    }
}
