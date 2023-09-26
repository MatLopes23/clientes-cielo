package com.bootcamp.clientescielo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pessoa_juridica")
public class PessoaJuridica {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "cpf_contato", nullable = false)
    private String cpfContato;

    @Column(name = "nome_contato", nullable = false)
    private String nomeContato;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

}
