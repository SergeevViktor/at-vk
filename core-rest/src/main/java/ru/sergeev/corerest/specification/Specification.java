package ru.sergeev.corerest.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Класс создания различных спецификаций для тестовых методов
 */
public class Specification {
    private static final ThreadLocal<RequestSpecification> requestSpecHolder = new ThreadLocal<>();
    private static final ThreadLocal<ResponseSpecification> responseSpecHolder = new ThreadLocal<>();

    private static final RequestSpecification DEFAULT_REQUEST_SPEC = new RequestSpecBuilder().build();
    private static final ResponseSpecification DEFAULT_RESPONSE_SPEC = new ResponseSpecBuilder().build();

    public static RequestSpecification specRequest(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .build();
    }

    public static void specInstall(RequestSpecification spec) {
        requestSpecHolder.set(spec);
    }

    public static void specInstall(ResponseSpecification spec) {
        responseSpecHolder.set(spec);
    }

    public static RequestSpecification getRequestSpec() {
        RequestSpecification spec = requestSpecHolder.get();
        return spec != null ? spec : DEFAULT_REQUEST_SPEC;
    }

    public static ResponseSpecification getResponseSpec() {
        ResponseSpecification spec = responseSpecHolder.get();
        return spec != null ? spec : DEFAULT_RESPONSE_SPEC;
    }

    public static void specDelete() {
        requestSpecHolder.remove();
        responseSpecHolder.remove();
    }
}
