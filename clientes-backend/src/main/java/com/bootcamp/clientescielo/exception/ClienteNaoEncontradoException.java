package com.bootcamp.clientescielo.exception;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}