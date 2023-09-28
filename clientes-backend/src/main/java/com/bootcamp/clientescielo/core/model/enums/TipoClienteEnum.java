package com.bootcamp.clientescielo.core.model.enums;

import lombok.Getter;

public enum TipoClienteEnum {
    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Jurídica");

    @Getter
    private final String value;

    TipoClienteEnum(String value) {
        this.value = value;
    }
}