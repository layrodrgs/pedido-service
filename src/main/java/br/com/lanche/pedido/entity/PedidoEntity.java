package br.com.lanche.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoEntity extends BaseEntity{
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    private BigDecimal valorPropocional;
    private String formaDePagamento;
    @OneToOne
    private EnderecoEntity enderecoEntrega;

}
