package br.com.lanche.pedido.mapper;

import br.com.lanche.pedido.entity.EnderecoEntity;
import br.com.lanche.pedido.entity.Request.EnderecoRequest;
import br.com.lanche.pedido.entity.Response.EnderecoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper {

    EnderecoEntity map(final EnderecoRequest endereco);

    EnderecoResponse map(final EnderecoEntity endereco);

}
