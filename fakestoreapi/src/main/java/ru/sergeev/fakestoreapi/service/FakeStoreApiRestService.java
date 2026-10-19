package ru.sergeev.fakestoreapi.service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.corerest.service.Rest;

import java.util.Map;

import static ru.sergeev.corecommon.enums.BaseEndpointEnum.AUTH;
import static ru.sergeev.corecommon.enums.BaseEndpointEnum.USERS;
import static ru.sergeev.fakestoreapi.enums.Param.ID;

@Service
public class FakeStoreApiRestService {
    @Autowired
    private Rest rest;

    //user-controller

    @Step("Отправляем GET запрос в fakestoreapi - /users")
    public Response getAllUsers(Map<String, String> headers) {
        return rest.get(USERS.getVal(), headers);
    }

    @Step("Отправляем POST запрос в fakestoreapi - /users")
    public Response postAddUser(Map<String, String> headers, Object body) {
        return rest.post(USERS.getVal(), headers, body);
    }

    @Step("Отправляем PUT запрос в fakestoreapi - /users/{id}")
    public Response putUpdateUserById(Map<String, String> headers, Object body, String paramValue) {
        return rest.putWithParam(USERS.getVal() + ID.getVal(), headers, body, paramValue);
    }

    @Step("Отправляем DELETE запрос в fakestoreapi - /users/{id}")
    public Response deleteUserById(Map<String, String> headers, String paramValue) {
        return rest.deleteWithParam(USERS.getVal() + ID.getVal(), headers, paramValue);
    }


    //auth-controller

    @Step("Отправляем POST запрос в fakestoreapi - /auth/login")
    public Response postLoginUser(Map<String, String> headers, Object body) {
        return rest.post(AUTH.getVal(), headers, body);
    }
}
