package com.bootcamp.clientescielo.core.service.impl;

import com.bootcamp.clientescielo.core.component.QueueGestor;
import com.bootcamp.clientescielo.core.model.Cliente;
import com.bootcamp.clientescielo.core.service.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorServiceImpl implements GestorService {

    private final QueueGestor queueGestor;

    @Autowired
    public GestorServiceImpl(QueueGestor queueGestor) {
        this.queueGestor = queueGestor;
    }


    @Override
    public Cliente getUltimoClienteAtualizado() {
        return queueGestor.removerCliente();
    }
}
