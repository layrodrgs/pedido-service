package br.com.lanche.pedido.entity;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoEntity extends BaseEntity {
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ItemPedidoEntity> itens;
    @OneToOne
    private EnderecoEntity enderecoEntrega;
    private BigDecimal valorTotal;
    private BigDecimal valorEntrega;
    private BigDecimal valorDesconto;
    private BigDecimal valorPropocional;
    private FormaDePagamentoEnum formaPagamento;
    private StatusPedidoEnum statusPedido;


}
