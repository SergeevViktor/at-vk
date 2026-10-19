package ru.sergeev.fakestoreapi.dto.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthRequestDto {
    private String username;
    private String password;
}
