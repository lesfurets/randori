package com.lesfurets.coffeemachine.model;

public enum EDrink {
    COFFEE("C"),
    TEA("T"),
    CHOCOLATE("H");

    private final String code;

    EDrink(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
