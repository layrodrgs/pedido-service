package br.com.lanche.pedido.entity.Request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoRequest {

    @NotEmpty
    @ApiModelProperty(position = 1, example = "rua sao luis")
    private String logradouro;

    @NotEmpty
    @ApiModelProperty(position = 2, example = "101")
    private String numero;
}
