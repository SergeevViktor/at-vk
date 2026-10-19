package ru.sergeev.fakestoreapi.helper;

import org.junit.jupiter.params.provider.Arguments;
import ru.sergeev.fakestoreapi.dto.factory.UserRequestDtoFactory;

import java.util.Map;
import java.util.stream.Stream;

public class UserDataProvider {

    public static Stream<Arguments> providerGetAllUsers() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers
        ));
    }

    public static Stream<Arguments> providerPostAddUser() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers,
                UserRequestDtoFactory.defaultUserReqDtoBuilder().build()
        ));
    }

    public static Stream<Arguments> providerPutUpdateUserById() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers,
                UserRequestDtoFactory.defaultUserReqDtoBuilder().build(),
                "1"
        ));
    }

    public static Stream<Arguments> providerDeleteUserById() {
        Map<String, String> headers = new DataHeaders();

        return Stream.of(Arguments.of(
                headers, "1"
        ));
    }
}
