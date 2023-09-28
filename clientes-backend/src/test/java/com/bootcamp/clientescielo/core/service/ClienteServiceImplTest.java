package com.bootcamp.clientescielo.core.service;

import static org.junit.jupiter.api.Assertions.*;

import com.bootcamp.clientescielo.core.component.QueueGestor;
import com.bootcamp.clientescielo.exception.ClienteExistenteException;
import com.bootcamp.clientescielo.exception.ClienteNaoEncontradoException;
import com.bootcamp.clientescielo.core.model.Cliente;
import com.bootcamp.clientescielo.core.model.PessoaFisica;
import com.bootcamp.clientescielo.core.model.enums.TipoClienteEnum;
import com.bootcamp.clientescielo.core.repository.ClienteRepository;
import com.bootcamp.clientescielo.core.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private QueueGestor queueGestor;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private Cliente clienteExemplo;
    private PessoaFisica pessoaFisicaExemplo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        clienteExemplo = Cliente
                .builder()
                .id(1L)
                .tipoCliente(TipoClienteEnum.PESSOA_FISICA)
                .build();

        pessoaFisicaExemplo = PessoaFisica
                .builder()
                .cpf("12345678901")
                .build();
    }

    @Test
    void testListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.add(new Cliente());

        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> resultado = clienteService.listarClientes();
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    void testBuscarClienteOuFalha() {
        Cliente cliente = clienteExemplo;

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.buscarClienteOuFalha(1L);
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void testBuscarClienteOuFalhaNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.buscarClienteOuFalha(1L));
    }

    @Test
    void testCriarCliente() {
        Cliente cliente = clienteExemplo;
        PessoaFisica pessoaFisica = pessoaFisicaExemplo;
        cliente.setPessoaFisica(pessoaFisica);

        when(clienteRepository.existsByPessoaFisicaCpfAndIdNot("12345678901", null)).thenReturn(false);
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente resultado = clienteService.criarCliente(cliente);
        assertNotNull(resultado);
        assertEquals(TipoClienteEnum.PESSOA_FISICA, resultado.getTipoCliente());
    }

    @Test
    void testCriarClienteExistente() {
        Cliente cliente = Cliente
                .builder()
                .tipoCliente(TipoClienteEnum.PESSOA_FISICA)
                .build();
        PessoaFisica pessoaFisica = pessoaFisicaExemplo;
        cliente.setPessoaFisica(pessoaFisica);

        when(clienteRepository.existsByPessoaFisicaCpfAndIdNot("12345678901", null)).thenReturn(true);

        assertThrows(ClienteExistenteException.class, () -> clienteService.criarCliente(cliente));
    }

    @Test
    void testAtualizarCliente() {
        Cliente clienteExistente = clienteExemplo;

        PessoaFisica pessoaFisicaExistente = pessoaFisicaExemplo;
        clienteExistente.setPessoaFisica(pessoaFisicaExistente);

        Cliente clienteAtualizado = Cliente
                .builder()
                .tipoCliente(TipoClienteEnum.PESSOA_FISICA)
                .build();
        PessoaFisica pessoaFisicaAtualizada = PessoaFisica
                .builder()
                .cpf("9876543210")
                .build();
        clienteAtualizado.setPessoaFisica(pessoaFisicaAtualizada);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));
        when(clienteRepository.existsByPessoaFisicaCpfAndIdNot("9876543210", 1L)).thenReturn(false);
        when(clienteRepository.save(clienteAtualizado)).thenReturn(clienteAtualizado);

        Cliente resultado = clienteService.atualizarCliente(1L, clienteAtualizado);
        assertNotNull(resultado);
        assertEquals("9876543210", resultado.getPessoaFisica().getCpf());
    }

    @Test
    void testAtualizarClienteNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Cliente clienteAtualizado = new Cliente();
        assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.atualizarCliente(1L, clienteAtualizado));
    }

    @Test
    void testAtualizarClienteExistente() {
        Cliente clienteExistente = clienteExemplo;
        PessoaFisica pessoaFisicaExistente = pessoaFisicaExemplo;
        clienteExistente.setPessoaFisica(pessoaFisicaExistente);

        Cliente clienteAtualizado = Cliente
                .builder()
                .tipoCliente(TipoClienteEnum.PESSOA_FISICA)
                .build();
        PessoaFisica pessoaFisicaAtualizada = PessoaFisica.builder().cpf("12345678901").build();
        clienteAtualizado.setPessoaFisica(pessoaFisicaAtualizada);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));
        when(clienteRepository.existsByPessoaFisicaCpfAndIdNot("12345678901", 1L)).thenReturn(true);

        assertThrows(ClienteExistenteException.class, () -> clienteService.atualizarCliente(1L, clienteAtualizado));
    }

    @Test
    void testExcluirCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        assertDoesNotThrow(() -> clienteService.excluirCliente(1L));

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
