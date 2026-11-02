package ru.sergeev.coreui.pages;

import io.qameta.allure.Param;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static ru.sergeev.coreui.acts.BaseActs.checkResult;

public abstract class BasePage {

    public BasePage validatePageByText(@Param(mode = HIDDEN) String name,
                                       @Param(mode = HIDDEN) String xpath) {
        String text = $x(xpath).shouldBe(visible).getText();
        checkResult(name, text);

        return this;
    }
}
