package ru.sergeev.fakestoreapi;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sergeev.fakestoreapi.acts.FakeStoreApiAuthActs;
import ru.sergeev.fakestoreapi.dto.body.AuthRequestDto;
import ru.sergeev.fakestoreapi.service.FakeStoreApiRestService;

import java.util.Map;

import static ru.sergeev.fakestoreapi.specification.Specification.specInstall;
import static ru.sergeev.fakestoreapi.specification.Specification.specRequest;

@Owner("sergeev.v.a")
@Feature("auth-controller")
public class FakeStoreApiAuthTests extends FakeStoreApiAbstractRestTest {
    @Autowired
    private FakeStoreApiAuthActs acts;
    @Autowired
    private FakeStoreApiRestService service;

    @Story("1")
    @DisplayName("Аутентификация пользователя")
    @Link("https://fakestoreapi.com/docs#tag/Auth/operation/loginUser")
    @ParameterizedTest(name = ": /auth/login")
    @MethodSource("ru.sergeev.fakestoreapi.helper.AuthDataProvider#providerPostLoginUser")
    public void postLoginUser(Map<String, String> headers, AuthRequestDto body) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.postLoginUser(headers, body);
        acts.checkLoginUserResponseDto(response);
    }

    @Story("1")
    @DisplayName("Аутентификация пользователя - негативный")
    @Link("https://fakestoreapi.com/docs#tag/Auth/operation/loginUser")
    @ParameterizedTest(name = ": /auth/login")
    @MethodSource("ru.sergeev.fakestoreapi.helper.AuthDataProvider#providerPostLoginUserNegative")
    public void postLoginUserNegative(Map<String, String> headers, AuthRequestDto body, String errorMessage) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.postLoginUser(headers, body);
        acts.checkLoginUserResponseDtoNegative(response, errorMessage);
    }
}
