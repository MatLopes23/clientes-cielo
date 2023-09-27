package com.bootcamp.clientescielo.service;

import com.bootcamp.clientescielo.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente criarCliente(Cliente cliente);

    List<Cliente> listarClientes();

    Cliente buscarClienteOuFalha(Long id);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);
}