package ru.sergeev.hw47.pageElements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Param;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class Button {
    private final SelenideElement root;
    private final String name;

    public Button(SelenideElement root) {
        this.root = root;
        if (root.getText().isBlank()) {
            this.name = "unnamed";
        } else {
            this.name = root.getText();
        }
    }

    public void clickOnElement() {
        Allure.step("Кликаем на кнопку '" + name + "'", () ->
                root.shouldBe(visible).click());
    }

    @Step("Сохраняем атрибут '{attribute}'")
    public String getAttribute(@Param(mode = HIDDEN) String attribute) {
        return root.getAttribute(attribute);
    }
}
