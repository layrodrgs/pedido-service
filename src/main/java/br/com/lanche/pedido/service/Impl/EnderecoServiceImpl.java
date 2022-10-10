package br.com.lanche.pedido.service.Impl;

import br.com.lanche.pedido.Repository.EnderecoRepository;
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
        EnderecoEntity save = this.repository.save(this.mapper.map(endereco));
        return this.mapper.map(save);
    }
}
