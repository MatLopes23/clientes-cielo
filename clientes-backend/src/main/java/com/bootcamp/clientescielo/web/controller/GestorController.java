package com.bootcamp.clientescielo.web.controller;

import com.bootcamp.clientescielo.core.model.Cliente;
import com.bootcamp.clientescielo.core.service.GestorService;
import com.bootcamp.clientescielo.web.dto.converter.ClienteConverter;
import com.bootcamp.clientescielo.web.dto.response.ClienteResponseDTO;
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

    private final ClienteConverter clienteConverter;

    @Autowired
    public GestorController(GestorService gestorService, ClienteConverter clienteConverter) {
        this.gestorService = gestorService;
        this.clienteConverter = clienteConverter;
    }

    @GetMapping("/cliente/atualizacoes")
    public ResponseEntity<ClienteResponseDTO> buscarUltimoClienteAtualizado() {
        logger.info("Endpoint: Busca por ultimo cliente atualizado");

        Cliente cliente = gestorService.getUltimoClienteAtualizado();

        logger.info("Cliente recuperado com sucesso da fila de atendimento. ID: {}", cliente.getId());

        return ResponseEntity.ok(clienteConverter.toResponse(cliente));
    }

}
