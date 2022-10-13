package br.com.lanche.pedido.utils;

import br.com.lanche.pedido.entity.EnderecoEntity;

public class EnderecoTestUtils {

    private EnderecoTestUtils(){

    }
    public static EnderecoEntity obterEnderecoEntity(){
        return EnderecoEntity.builder()
                .id(1L)
                .logradouro("avenida mario andreaza")
                .numero("140")
                .build();
    }
}
