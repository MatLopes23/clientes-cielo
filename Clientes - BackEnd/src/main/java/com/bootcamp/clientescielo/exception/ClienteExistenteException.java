package com.bootcamp.clientescielo.exception;

public class ClienteExistenteException extends RuntimeException {

    public ClienteExistenteException(String mensagem) {
        super(mensagem);
    }
}