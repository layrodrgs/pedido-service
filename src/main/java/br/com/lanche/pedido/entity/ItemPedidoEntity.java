package br.com.lanche.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name = "item_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemPedidoEntity extends BaseEntity {

    private String nomeProduto;

    private BigDecimal precoProduto;

    @ManyToOne
    private PedidoEntity pedido;

    @OneToOne
    private UsuarioEntity usuario;

}
