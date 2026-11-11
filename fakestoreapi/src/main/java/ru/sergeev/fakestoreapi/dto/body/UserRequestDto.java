package ru.sergeev.fakestoreapi.dto.body;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
}
