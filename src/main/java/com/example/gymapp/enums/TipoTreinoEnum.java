package com.example.gymapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTreinoEnum {
    A("Força"),
    B("Resistência"),
    C("Flexibilidade");

    private final String value;
    TipoTreinoEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
