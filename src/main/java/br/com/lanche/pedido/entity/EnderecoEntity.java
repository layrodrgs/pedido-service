package br.com.lanche.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoEntity extends BaseEntity{

    private String numero;
    private String logradouro;
    private String complemento;
    private String cep;
}
