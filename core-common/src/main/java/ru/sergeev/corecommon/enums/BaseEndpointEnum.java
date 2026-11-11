package ru.sergeev.corecommon.enums;

import lombok.Getter;

public enum BaseEndpointEnum {
    PRODUCTS("/products"),
    CARTS("/carts"),
    USERS("/users"),
    AUTH("/auth/login");

    @Getter
    private final String val;

    BaseEndpointEnum(String val) {
        this.val = val;
    }
}
