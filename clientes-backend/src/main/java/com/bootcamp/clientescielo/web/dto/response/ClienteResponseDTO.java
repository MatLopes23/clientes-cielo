package com.bootcamp.clientescielo.web.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String tipoCliente;
    private String email;
    private String cpf;
    private String cnpj;
    private String razaoSocial;
    private String mcc;
    private String nome;
    private Date dataCadastro;
    private Date dataAtualizacao;
}
