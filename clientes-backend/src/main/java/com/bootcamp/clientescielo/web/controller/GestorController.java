package com.bootcamp.clientescielo.web.controller;

import com.bootcamp.clientescielo.core.model.Cliente;
import com.bootcamp.clientescielo.core.service.GestorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestor")
public class GestorController {

    private static final Logger logger = LoggerFactory.getLogger(GestorController.class);

    private final GestorService gestorService;

    @Autowired
    public GestorController(GestorService gestorService) {
        this.gestorService = gestorService;
    }

    @GetMapping("/cliente/atualizacoes")
    public ResponseEntity<Cliente> buscarUltimoClienteAtualizado() {
        logger.info("Endpoint: Busca por ultimo cliente atualizado");

        Cliente cliente = gestorService.getUltimoClienteAtualizado();

        logger.info("Cliente recuperado com sucesso. ID: {}", cliente.getId());

        return ResponseEntity.ok(cliente);
    }

}
