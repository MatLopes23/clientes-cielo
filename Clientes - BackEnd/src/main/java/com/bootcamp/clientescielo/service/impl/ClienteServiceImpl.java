package com.bootcamp.clientescielo.service.impl;

import com.bootcamp.clientescielo.exception.ClienteExistenteException;
import com.bootcamp.clientescielo.exception.ClienteNaoEncontradoException;
import com.bootcamp.clientescielo.model.Cliente;
import com.bootcamp.clientescielo.model.enums.TipoClienteEnum;
import com.bootcamp.clientescielo.repository.ClienteRepository;
import com.bootcamp.clientescielo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClienteOuFalha(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + id));
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        validarDuplicacaoCliente(cliente);
        cliente.setDataCadastro(new Date());
        cliente.setDataAtualizacao(new Date());

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarClienteOuFalha(id);

        validarDuplicacaoCliente(clienteAtualizado, id);
       atualizarCamposCliente(clienteExistente, clienteAtualizado);

        return clienteRepository.save(clienteAtualizado);
    }


    private void validarDuplicacaoCliente(Cliente cliente, Long id) {
        if (cliente.getTipoCliente() == TipoClienteEnum.PESSOA_FISICA) {
            String cpf = cliente.getPessoaFisica().getCpf();
            if (clienteRepository.existsByPessoaFisicaCpfAndIdNot(cpf, id)) {
                throw new ClienteExistenteException("Cliente com o CPF já existe: " + cpf);
            }
        } else if (cliente.getTipoCliente() == TipoClienteEnum.PESSOA_JURIDICA) {
            String cnpj = cliente.getPessoaJuridica().getCnpj();
            if (clienteRepository.existsByPessoaJuridicaCnpjAndIdNot(cnpj, id)) {
                throw new ClienteExistenteException("Cliente com o CNPJ já existe: " + cnpj);
            }
        }
    }

    private void validarDuplicacaoCliente(Cliente cliente) {
        validarDuplicacaoCliente(cliente, null);
    }

    private void atualizarCamposCliente(Cliente clienteExistente, Cliente clienteAtualizado){

        if (clienteAtualizado.getPessoaFisica() != null && clienteExistente.getPessoaFisica() != null) {
            clienteAtualizado.getPessoaFisica().setId(clienteExistente.getPessoaFisica().getId());
        } else if (clienteAtualizado.getPessoaJuridica() != null && clienteExistente.getPessoaJuridica() != null) {
            clienteAtualizado.getPessoaJuridica().setId(clienteExistente.getPessoaJuridica().getId());
        }

        clienteAtualizado.setId(clienteExistente.getId());
        clienteAtualizado.setDataCadastro(clienteExistente.getDataCadastro());
        clienteAtualizado.setDataAtualizacao(new Date());
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
