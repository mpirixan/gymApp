package com.example.gymapp.enums;

public enum TipoTreinoEnum {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F");

    private final String value;
    TipoTreinoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
