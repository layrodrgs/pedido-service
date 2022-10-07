package br.com.lanche.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEntity extends BaseEntity{
    private String nome;

    @OneToOne
    private EnderecoEntity endereco;

}
