package com.bootcamp.clientescielo.controller;

import com.bootcamp.clientescielo.dto.request.ClienteRequestDTO;
import com.bootcamp.clientescielo.model.Cliente;
import com.bootcamp.clientescielo.service.ClienteService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Autowired
    public ClienteController(ClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
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

        Cliente cliente = modelMapper.map(clienteRequest, Cliente.class);

        Cliente novoCliente = clienteService.criarCliente(cliente);
        logger.info("Cliente criado com sucesso. ID: {}", novoCliente.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        logger.info("Endpoint: Atualizar cliente. ID: {}", id);

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
