package ru.sergeev.fakestoreapi.dto.factory;

import lombok.experimental.UtilityClass;
import ru.sergeev.fakestoreapi.dto.body.UserRequestDto;

@UtilityClass
public class UserRequestDtoFactory {

    public static UserRequestDto.UserRequestDtoBuilder defaultUserReqDtoBuilder() {
        return UserRequestDto.builder()
                .username("Viktor")
                .email("viktor@123.ru")
                .password("viktor-aqa");
    }
}
