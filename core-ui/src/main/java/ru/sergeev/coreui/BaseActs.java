package ru.sergeev.coreui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Param;
import io.qameta.allure.Step;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class BaseActs {

    @Step("Переходим по адресу: {relativeOrAbsoluteUrl}")
    public <PageObjectClass> PageObjectClass open(@Param(mode = HIDDEN) String relativeOrAbsoluteUrl,
                                                  @Param(mode = HIDDEN) Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }
}
