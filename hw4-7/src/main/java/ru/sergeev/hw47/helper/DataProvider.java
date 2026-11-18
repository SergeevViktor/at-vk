package ru.sergeev.hw47.helper;

import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.Cookie;
import ru.sergeev.coreui.valueObjects.Credentials;

import java.util.List;
import java.util.stream.Stream;

import static ru.sergeev.coreui.enums.SauceDemoAccountEnum.PASSWORD;
import static ru.sergeev.coreui.enums.SauceDemoAccountEnum.STANDARD_USER;

public class DataProvider {

    public static Stream<Arguments> providerAuthorizationNegative() {

        return Stream.of(Arguments.of(
                "123123",
                "Epic sadface: Username and password do not match any user in this service"
        ));
    }

    public static Stream<Arguments> providerValidateSidebarMenu() {

        return Stream.of(Arguments.of(
                new Cookie("session-username", "standard_user"),
                List.of("All Items", "Dynamic Catalog", "About", "Logout", "Reset App State")
        ));
    }

    public static Stream<Arguments> providerAuthorizationByValueObject() {

        return Stream.of(Arguments.of(
                new Credentials(STANDARD_USER.getVal(), PASSWORD.getVal())
        ));
    }

    public static Stream<Arguments> providerValidateItemCard() {

        return Stream.of(Arguments.of(
                new Cookie("session-username", "standard_user"),
                List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"),
                "aria-label"
        ));
    }
}
