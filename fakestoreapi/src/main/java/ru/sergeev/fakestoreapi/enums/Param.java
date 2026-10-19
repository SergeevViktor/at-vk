package ru.sergeev.fakestoreapi.enums;

import lombok.Getter;

public enum Param {
    ID("/{id}");

    @Getter
    private final String val;

    Param(String val) {
        this.val = val;
    }
}
