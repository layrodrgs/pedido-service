package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.repository.EnderecoRepository;
import br.com.lanche.pedido.entity.EnderecoEntity;
import br.com.lanche.pedido.entity.Request.EnderecoRequest;
import br.com.lanche.pedido.entity.Response.EnderecoResponse;
import br.com.lanche.pedido.mapper.EnderecoMapper;
import br.com.lanche.pedido.service.EnderecoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    private final EnderecoMapper mapper;

    @Override
    public EnderecoResponse cadastrarEndereco(final EnderecoRequest endereco) {
        log.info("Cadastrando um endereço");
        EnderecoEntity save = this.repository.save(this.mapper.map(endereco));
        log.info("Cadastro de endereço realizado com sucesso: '{}'", save.getId());
        return this.mapper.map(save);
    }
}
