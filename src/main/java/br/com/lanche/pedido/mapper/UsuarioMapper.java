package br.com.lanche.pedido.mapper;

import br.com.lanche.pedido.entity.Request.UsuarioRequest;
import br.com.lanche.pedido.entity.Response.UsuarioResponse;
import br.com.lanche.pedido.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UsuarioMapper {

    @Mapping(target = "endereco.id", source = "enderecoId")
    UsuarioEntity map(final UsuarioRequest usuario);

    UsuarioResponse map(final UsuarioEntity usuario);


}
