package ru.sergeev.fakestoreapi.specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Класс создания различных спецификаций для тестовых методов
 */
public class Specification {

    public static RequestSpecification specRequest(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .build();
    }

    public static void specInstall(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }

    public static void specInstall(ResponseSpecification response) {
        RestAssured.responseSpecification = response;
    }

    public static void specDelete() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}
