package com.bootcamp.clientescielo.dto.converter;

import com.bootcamp.clientescielo.dto.request.ClienteRequestDTO;
import com.bootcamp.clientescielo.model.Cliente;
import com.bootcamp.clientescielo.model.PessoaFisica;
import com.bootcamp.clientescielo.model.PessoaJuridica;
import com.bootcamp.clientescielo.model.enums.TipoClienteEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {


    @Autowired
    private ModelMapper modelMapper;

    public Cliente toModel(ClienteRequestDTO clienteRequest) {
        Cliente cliente =  modelMapper.map(clienteRequest, Cliente.class);

        if(clienteRequest.getTipoCliente().equals(TipoClienteEnum.PESSOA_FISICA)){
            PessoaFisica pessoaFisica = PessoaFisica
                    .builder()
                    .cpf(clienteRequest.getCpfResponsavel())
                    .nome(clienteRequest.getNomeResponsavel())
                    .build();

            cliente.setPessoaFisica(pessoaFisica);

        } else if (clienteRequest.getTipoCliente().equals(TipoClienteEnum.PESSOA_JURIDICA)) {
            PessoaJuridica pessoaJuridica =  PessoaJuridica
                    .builder()
                    .cnpj(clienteRequest.getCnpj())
                    .razaoSocial(clienteRequest.getRazaoSocial())
                    .cpfContato(clienteRequest.getCpfResponsavel())
                    .nomeContato(clienteRequest.getNomeResponsavel())
                    .build();

            cliente.setPessoaJuridica(pessoaJuridica);

        }
        return cliente;
    }
}
