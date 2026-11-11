package ru.sergeev.coreui.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SauceDemoLoginPageEnum {
    LOGIN_LOGO("//div[@class='login_logo']"),
    USER_FIELD("user-name"),
    PASSWORD_FIELD("password"),
    LOGIN_BUTTON("login-button"),
    ERROR_MESSAGE("//h3");

    private final String val;
}
