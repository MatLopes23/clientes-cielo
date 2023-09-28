package com.bootcamp.clientescielo.web.dto.converter;

import com.bootcamp.clientescielo.web.dto.request.ClienteRequestDTO;
import com.bootcamp.clientescielo.core.model.Cliente;
import com.bootcamp.clientescielo.core.model.PessoaFisica;
import com.bootcamp.clientescielo.core.model.PessoaJuridica;
import com.bootcamp.clientescielo.core.model.enums.TipoClienteEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    private ModelMapper modelMapper;

    @Autowired
    public ClienteConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

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
