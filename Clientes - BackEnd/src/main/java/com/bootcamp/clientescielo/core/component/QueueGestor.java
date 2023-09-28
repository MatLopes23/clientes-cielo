package com.bootcamp.clientescielo.core.component;

import com.bootcamp.clientescielo.core.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class QueueGestor {
    private ConcurrentLinkedQueue<Cliente> clientesAtualizados = new ConcurrentLinkedQueue<>();

    public void adicionarCliente(Cliente cliente) {
        clientesAtualizados.add(cliente);
    }

    public Cliente removerCliente() {
        return clientesAtualizados.poll();
    }

}
