package br.com.lanche.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EnderecoEntity extends BaseEntity{

    private String logradouro;

    private String numero;
}
