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

    @ApiModelProperty(position = 1, example = "698dc19d489c4e4db73e28a713eab07b")
    @NotEmpty
    private String enderecoEntregaId;

    @ApiModelProperty(position = 2, example = "5.50")
    @Digits(integer = 4, fraction = 2)
    @NotEmpty
    private BigDecimal valorEntrega;

}
