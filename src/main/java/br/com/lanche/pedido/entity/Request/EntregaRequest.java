package br.com.lanche.pedido.entity.Request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntregaRequest {

    @ApiModelProperty(position = 1, example = "6")
    @NotEmpty
    private Long enderecoEntregaId;

    @ApiModelProperty(position = 2, example = "5.50")
    @Digits(integer = 4, fraction = 2)
    @NotEmpty
    private BigDecimal valorEntrega;

}
