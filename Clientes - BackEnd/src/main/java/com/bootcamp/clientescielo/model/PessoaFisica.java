package com.bootcamp.clientescielo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
