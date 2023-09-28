package com.bootcamp.clientescielo.web.controller;

import com.bootcamp.clientescielo.core.service.ClienteService;
import com.bootcamp.clientescielo.web.dto.converter.ClienteConverter;
import com.bootcamp.clientescielo.web.dto.request.ClienteRequestDTO;
import com.bootcamp.clientescielo.core.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;
    private final ClienteConverter converter;

    @Autowired
    public ClienteController(ClienteService clienteService, ClienteConverter converter) {
        this.clienteService = clienteService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        logger.info("Lista todos os clientes cadastrados.");

        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        logger.info("Endpoint: Busca por cliente com ID: {}", id);

        Cliente cliente = clienteService.buscarClienteOuFalha(id);
        logger.info("Cliente recuperado com sucesso. ID: {}", id);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteRequestDTO clienteRequest) {
        logger.info("Endpoint: Criar cliente");

        clienteRequest.validaRequest();

        Cliente cliente = converter.toModel(clienteRequest);

        Cliente novoCliente = clienteService.criarCliente(cliente);
        logger.info("Cliente criado com sucesso. ID: {}", novoCliente.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequest) {
        logger.info("Endpoint: Atualizar cliente. ID: {}", id);

        clienteRequest.validaRequest();

        Cliente cliente = converter.toModel(clienteRequest);

        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        logger.info("Cliente atualizado com sucesso. ID: {}", clienteAtualizado.getId());

        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        logger.info("Endpoint: Excluir cliente. ID: {}", id);

        clienteService.excluirCliente(id);
        logger.info("Cliente excluido com sucesso. ID: {}", id);

        return ResponseEntity.ok().build();
    }
}
