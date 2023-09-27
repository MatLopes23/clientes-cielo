package com.bootcamp.clientescielo.dto.request;

import com.bootcamp.clientescielo.model.enums.TipoClienteEnum;
import com.bootcamp.clientescielo.validation.PessoaFisicaValidation;
import com.bootcamp.clientescielo.validation.PessoaJuridicaValidation;
import com.bootcamp.clientescielo.validation.ValidatorUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClienteRequestDTO {

    @NotNull(message = "Tipo de cliente é obrigatório")
    private TipoClienteEnum tipoCliente;

    @Email
    @NotBlank(message = "Email é obrigatório", groups = {PessoaFisicaValidation.class, PessoaJuridicaValidation.class})
    private String emailContato;

    @CPF
    @NotBlank(message = "CPF é obrigatório", groups = {PessoaFisicaValidation.class})
    private String cpfResponsavel;

    @CNPJ
    @NotBlank(message = "CNPJ é obrigatório", groups = {PessoaJuridicaValidation.class})
    private String cnpj;

    @Size(max = 50)
    @NotBlank(message = "Razão social é obrigatória", groups = {PessoaJuridicaValidation.class})
    private String razaoSocial;

    @Size(max = 4)
    @NotBlank(message = "MCC é obrigatório", groups = {PessoaFisicaValidation.class, PessoaJuridicaValidation.class})
    private String mcc;

    @Size(max = 50)
    @NotBlank(message = "Nome é obrigatório", groups = {PessoaFisicaValidation.class, PessoaJuridicaValidation.class})
    private String nomeResponsavel;

    @JsonIgnore
    public void validaRequest(){
        if (this.getTipoCliente() == TipoClienteEnum.PESSOA_FISICA) {
            ValidatorUtil.validate(this, PessoaFisicaValidation.class);
        } else if (this.getTipoCliente() == TipoClienteEnum.PESSOA_JURIDICA) {
            ValidatorUtil.validate(this, PessoaJuridicaValidation.class);
        }
    }
}
