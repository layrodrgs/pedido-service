package br.com.lanche.pedido.Repository;

import br.com.lanche.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
