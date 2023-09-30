package com.bootcamp.clientescielo.core.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pessoa_juridica")
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonIgnore
    private Cliente cliente;

}
