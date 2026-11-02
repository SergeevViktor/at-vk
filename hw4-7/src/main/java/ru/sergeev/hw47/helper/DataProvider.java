package ru.sergeev.hw47.helper;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> providerAuthorizationNegative() {

        return Stream.of(Arguments.of(
                "123123",
                "Epic sadface: Username and password do not match any user in this service"
        ));
    }

    public static Stream<Arguments> providerValidateSidebarMenu() {

        return Stream.of(Arguments.of(
                List.of("All Items", "Dynamic Catalog", "About", "Logout", "Reset App State")
        ));
    }
}
