package ru.sergeev.hw47.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SauceDemoEndpoints {
    INVENTORY("/inventory.html");

    private final String val;
}
