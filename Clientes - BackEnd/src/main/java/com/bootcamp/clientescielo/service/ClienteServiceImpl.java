package com.bootcamp.clientescielo.service;

import com.bootcamp.clientescielo.exception.ClienteExistenteException;
import com.bootcamp.clientescielo.exception.ClienteNaoEncontradoException;
import com.bootcamp.clientescielo.model.Cliente;
import com.bootcamp.clientescielo.model.enums.TipoClienteEnum;
import com.bootcamp.clientescielo.repository.ClienteRepository;
import com.bootcamp.clientescielo.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        validarCliente(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {

            validarCliente(clienteAtualizado, id);
            clienteAtualizado.setId(clienteExistente.get().getId());
            return clienteRepository.save(clienteAtualizado);
        } else {
            throw new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + id);
        }
    }


    private void validarCliente(Cliente cliente, Long id) {
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

    private void validarCliente(Cliente cliente) {
        validarCliente(cliente, null);
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
