package br.com.lanche.pedido.entity.Request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoRequest {

    @ApiModelProperty(position = 1, example = "layanne")
    @NotEmpty
    private String nomeProduto;

    @ApiModelProperty(position = 2, example = "10.25")
    @NotNull
    @Digits(integer = 4, fraction = 2)
    private BigDecimal precoProduto;

    @ApiModelProperty(position = 3, example = "2")
    @NotEmpty
    private Long usuarioId;
}
