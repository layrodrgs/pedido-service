package br.com.lanche.pedido.repository;

import br.com.lanche.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findByIdentificacaoPedido(String identificacaoPedido);
}
