package br.com.lanche.pedido.entity.Request;

import br.com.lanche.pedido.entity.Request.enums.FormaDePagamentoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoRequest {

    @ApiModelProperty(position = 1, example = "12.50")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal valorDesconto;

    @ApiModelProperty(position = 2, example = "20.00")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal acrescimoPorcentagem;

    @ApiModelProperty(position = 3, example = "30.00")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal acrescimoReal;

    @ApiModelProperty(position = 4)
    @NotNull
    private List<ItemPedidoRequest> itens;

    @ApiModelProperty(position = 5, example = "PICPAY/NUBANK")
    @NotNull
    private FormaDePagamentoEnum formaDePagamento;

    @Valid
    private EntregaRequest entrega;
}
