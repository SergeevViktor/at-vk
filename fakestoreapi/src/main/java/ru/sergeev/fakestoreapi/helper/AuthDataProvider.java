package ru.sergeev.fakestoreapi.helper;

import org.junit.jupiter.params.provider.Arguments;
import ru.sergeev.fakestoreapi.dto.factory.AuthRequestDtoFactory;

import java.util.Map;
import java.util.stream.Stream;

public class AuthDataProvider {

    public static Stream<Arguments> providerPostLoginUser() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers,
                AuthRequestDtoFactory.defaultAuthReqDtoBuilder().build()
        ));
    }

    public static Stream<Arguments> providerPostLoginUserNegative() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers,
                AuthRequestDtoFactory.defaultAuthReqDtoBuilder()
                        .username(null)
                        .password(null).build(),
                "username and password are not provided in JSON format"
        ));
    }
}
