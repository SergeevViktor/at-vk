package ru.sergeev.fakestoreapi.acts;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static org.hamcrest.Matchers.*;

@Component
public class FakeStoreApiAuthActs {

    @Step("Проверяем, что статус код ответа <201>, тело ответа не пустое и " +
            "поле 'token' содержит текст")
    public void checkLoginUserResponseDto(@Param(mode = HIDDEN) Response response) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body(not(empty()))
                .body("token", not(emptyOrNullString()));
    }

    @Step("Проверяем, что статус код ответа <400>, тело ответа не пустое и " +
            "соответствует 'errorMessage'")
    public void checkLoginUserResponseDtoNegative(@Param(mode = HIDDEN) Response response,
                                                  String errorMessage) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(not(empty()))
                .body(equalTo(errorMessage));
    }
}
