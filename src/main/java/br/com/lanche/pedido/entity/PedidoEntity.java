package br.com.lanche.pedido.entity;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import br.com.lanche.pedido.entity.Request.enums.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PedidoEntity extends BaseEntity {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ItemPedidoEntity> itens;

    @OneToOne
    private EnderecoEntity enderecoEntrega;

    private BigDecimal valorEntrega;

    private BigDecimal valorDesconto;

    private String linkPagamento;

    @Enumerated(EnumType.STRING)
    private FormaDePagamentoEnum formaDePagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum statusPedido;

    private String identificacaoPagamento;

    private BigDecimal acrescimoPorcentagem;

    private BigDecimal acrescimoReal;


}
