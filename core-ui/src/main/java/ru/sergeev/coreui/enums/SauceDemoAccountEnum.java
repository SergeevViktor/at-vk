package ru.sergeev.coreui.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SauceDemoAccountEnum {
    STANDARD_USER("standard_user"),
    ERROR_USER("error_user"),
    PASSWORD("secret_sauce");

    private final String val;
}
