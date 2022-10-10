package br.com.lanche.pedido.mapper;

import br.com.lanche.pedido.entity.Request.UsuarioRequest;
import br.com.lanche.pedido.entity.Response.UsuarioResponse;
import br.com.lanche.pedido.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {

    UsuarioEntity map(final UsuarioRequest usuario);

    UsuarioResponse map(final UsuarioEntity usuario);
}
