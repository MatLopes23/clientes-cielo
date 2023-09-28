package com.bootcamp.clientescielo.core.model;

import com.bootcamp.clientescielo.core.model.enums.TipoClienteEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private PessoaJuridica pessoaJuridica;
}
