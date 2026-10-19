package ru.sergeev.fakestoreapi.dto.factory;

import lombok.experimental.UtilityClass;
import ru.sergeev.fakestoreapi.dto.body.AuthRequestDto;

@UtilityClass
public class AuthRequestDtoFactory {

    public static AuthRequestDto.AuthRequestDtoBuilder defaultAuthReqDtoBuilder() {
        return AuthRequestDto.builder()
                .username("johnd")
                .password("m38rmF$");
    }
}
