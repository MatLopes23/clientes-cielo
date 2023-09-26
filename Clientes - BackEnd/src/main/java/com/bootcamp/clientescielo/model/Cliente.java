package com.bootcamp.clientescielo.model;

import com.bootcamp.clientescielo.model.enums.TipoClienteEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoClienteEnum tipoCliente;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;

    @Column(name = "mcc")
    private String mcc;

    @Column(name = "email_contato", nullable = false)
    private String emailContato;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PessoaJuridica pessoaJuridica;
}
