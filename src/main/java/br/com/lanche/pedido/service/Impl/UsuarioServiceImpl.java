package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.entity.Request.UsuarioRequest;
import br.com.lanche.pedido.entity.Response.UsuarioResponse;
import br.com.lanche.pedido.entity.UsuarioEntity;
import br.com.lanche.pedido.mapper.UsuarioMapper;
import br.com.lanche.pedido.repository.UsuarioRepository;
import br.com.lanche.pedido.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    private final UsuarioMapper mapper;
    @Override
    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuario) {
        log.info("Cadastrando um novo usuário.");
        UsuarioEntity save = this.repository.save(this.mapper.map(usuario));
        log.info("Usuário foi cadastrado com sucesso, id '{}'", save.getId());
        return this.mapper.map(save);
    }
}
