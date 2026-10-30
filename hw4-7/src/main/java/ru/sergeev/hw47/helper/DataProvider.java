package ru.sergeev.hw47.helper;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> providers() {

        return Stream.of(Arguments.of(
                "Test"
        ));
    }
}
