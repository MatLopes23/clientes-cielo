package com.bootcamp.clientescielo.service;

import com.bootcamp.clientescielo.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente criarCliente(Cliente cliente);

    List<Cliente> listarClientes();

    Cliente buscarClienteOuFalha(Long id);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);
}