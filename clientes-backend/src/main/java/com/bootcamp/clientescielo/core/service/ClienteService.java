package com.bootcamp.clientescielo.core.service;

import com.bootcamp.clientescielo.core.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente criarCliente(Cliente cliente);

    List<Cliente> listarClientes();

    Cliente buscarClienteOuFalha(Long id);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);
}