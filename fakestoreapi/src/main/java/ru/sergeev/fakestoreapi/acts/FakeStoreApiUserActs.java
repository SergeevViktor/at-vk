package ru.sergeev.fakestoreapi.acts;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.sergeev.fakestoreapi.dto.body.UserRequestDto;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static org.hamcrest.Matchers.*;

@Component
public class FakeStoreApiUserActs {

    @Step("Проверяем, что статус код ответа <200>, тело ответа не пустое и " +
            "поле 'id' соответствует 'paramValue'")
    public void checkResponse200(@Param(mode = HIDDEN) Response response,
                                 String paramValue) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
                .body("id", equalTo(Integer.valueOf(paramValue)));
    }

    @Step("Проверяем, что статус код ответа <200>, тело ответа не пустое и " +
            "поля соответствуют 'body' запроса")
    public void checkUpdateUserResponseDto(@Param(mode = HIDDEN) Response response,
                                           UserRequestDto reqDto) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
                .body("username", equalTo(reqDto.getUsername()))
                .body("email", equalTo(reqDto.getEmail()))
                .body("password", equalTo(reqDto.getPassword()));
    }

    @Step("Проверяем, что статус код ответа <201>, тело ответа не пустое, " +
            "поле 'id' содержит не пустое значение и является числовым")
    public void checkAddUserResponseDto(@Param(mode = HIDDEN) Response response) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body(not(empty()))
                .body("id", allOf(notNullValue(), instanceOf(Number.class)));
    }

    @Step("Проверяем, что статус код ответа <200>, тело ответа не пустое и " +
            "каждый элемент содержит не пустые поля: 'id', 'username', 'email', 'password'")
    public void checkAllUserResponseDto(@Param(mode = HIDDEN) Response response) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(not(empty()))
                .body("id", everyItem(notNullValue()))
                .body("username", everyItem(not(emptyOrNullString())))
                .body("email", everyItem(not(emptyOrNullString())))
                .body("password", everyItem(not(emptyOrNullString())));
    }
}
