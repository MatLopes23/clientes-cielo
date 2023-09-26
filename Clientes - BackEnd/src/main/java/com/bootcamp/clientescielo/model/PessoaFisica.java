package com.bootcamp.clientescielo.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "pessoa_fisica")
public class PessoaFisica {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

}
