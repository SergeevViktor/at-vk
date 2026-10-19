package ru.sergeev.corerest.service;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Класс с основными методами для отправки запроса
 */
@Service
public class Rest {

    public Response get(String url, Map<String, String> headers) {
        return given()
                .filter(new AllureRestAssured())
                .headers(headers)
                .when()
                .get(url);
    }

    public Response post(String url, Map<String, String> headers, Object body) {
        return given()
                .filter(new AllureRestAssured())
                .headers(headers)
                .body(body)
                .when()
                .post(url);
    }

    public Response putWithParam(String url, Map<String, String> headers, Object body, String paramValue) {
        String param = getParam(url);

        return given()
                .filter(new AllureRestAssured())
                .headers(headers)
                .pathParam(param, paramValue)
                .body(body)
                .when()
                .put(url);
    }

    public Response deleteWithParam(String url, Map<String, String> headers, String paramValue) {
        String param = getParam(url);

        return given()
                .filter(new AllureRestAssured())
                .headers(headers)
                .pathParam(param, paramValue)
                .when()
                .delete(url);
    }


    private String getParam(String url) {
        return url.replaceAll(".*\\/\\{(.*?)\\}.*", "$1");
    }
}
