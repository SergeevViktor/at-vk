package ru.sergeev.coreui.acts;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class BaseActs {

    @Step("Переходим по адресу: {relativeOrAbsoluteUrl}")
    public <PageObjectClass> PageObjectClass open(@Param(mode = HIDDEN) String relativeOrAbsoluteUrl,
                                                  @Param(mode = HIDDEN) Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }

    @Step("Проверка результата: объекты должны быть равны")
    public static void checkResult(Object result, Object expected) {
        Assertions.assertEquals(expected, result,
                "Фактический результат не совпадает с ожидаемым. " +
                        result + "|" + expected);
    }
}
