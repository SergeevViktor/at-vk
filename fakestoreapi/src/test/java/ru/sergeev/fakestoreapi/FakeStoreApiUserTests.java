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
import ru.sergeev.fakestoreapi.acts.FakeStoreApiUserActs;
import ru.sergeev.fakestoreapi.dto.body.UserRequestDto;
import ru.sergeev.fakestoreapi.service.FakeStoreApiRestService;

import java.util.Map;

import static ru.sergeev.fakestoreapi.specification.Specification.specInstall;
import static ru.sergeev.fakestoreapi.specification.Specification.specRequest;

@Owner("sergeev.v.a")
@Feature("user-controller")
public class FakeStoreApiUserTests extends FakeStoreApiAbstractRestTest {
    @Autowired
    private FakeStoreApiUserActs acts;
    @Autowired
    private FakeStoreApiRestService service;

    @Story("1")
    @DisplayName("Получение списка пользователей")
    @Link("https://fakestoreapi.com/docs#tag/Users/operation/getAllUsers")
    @ParameterizedTest(name = ": /users")
    @MethodSource("ru.sergeev.fakestoreapi.helper.UserDataProvider#providerGetAllUsers")
    public void getAllUsers(Map<String, String> headers) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.getAllUsers(headers);
        acts.checkAllUserResponseDto(response);
    }

    @Story("2")
    @DisplayName("Создание нового пользователя")
    @Link("https://fakestoreapi.com/docs#tag/Users/operation/addUser")
    @ParameterizedTest(name = ": /users")
    @MethodSource("ru.sergeev.fakestoreapi.helper.UserDataProvider#providerPostAddUser")
    public void postAddUser(Map<String, String> headers, UserRequestDto body) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.postAddUser(headers, body);
        acts.checkAddUserResponseDto(response);
    }

    @Story("3")
    @DisplayName("Обновление пользователя")
    @Link("https://fakestoreapi.com/docs#tag/Users/operation/updateUser")
    @ParameterizedTest(name = ": /users/{2}")
    @MethodSource("ru.sergeev.fakestoreapi.helper.UserDataProvider#providerPutUpdateUserById")
    public void putUpdateUserById(Map<String, String> headers, UserRequestDto body, String paramValue) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.putUpdateUserById(headers, body, paramValue);
        acts.checkUpdateUserResponseDto(response, body);
    }

    @Story("4")
    @DisplayName("Удаление пользователя")
    @Link("https://fakestoreapi.com/docs#tag/Users/operation/deleteUser")
    @ParameterizedTest(name = ": /users/{1}")
    @MethodSource("ru.sergeev.fakestoreapi.helper.UserDataProvider#providerDeleteUserById")
    public void deleteUserById(Map<String, String> headers, String paramValue) {
        specInstall(specRequest(BASE_END_POINT));

        Response response = service.deleteUserById(headers, paramValue);
        acts.checkResponse200(response, paramValue);
    }
}